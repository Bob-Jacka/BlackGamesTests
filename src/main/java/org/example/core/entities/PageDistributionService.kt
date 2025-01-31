package org.example.core.entities

import com.codeborne.selenide.*
import org.awaitility.Durations
import org.example.core.annotations.DistributionPage
import org.example.core.entities.operator.FairSpin
import org.example.core.entities.operator.SprutCloud
import org.example.core.entities.operator.Web3BlockChain
import org.example.core.enums.Stages_web_addresses
import org.example.core.enums.Stages_web_addresses.PROD
import org.example.core.enums.Stages_web_addresses.SLOT_PROD
import org.example.core.main_functionalities.*
import org.example.core.main_functionalities.ActionController.wait_For
import org.openqa.selenium.By
import java.net.URL

/**
 * Сервис для открытия браузера по переданному значению 'stage' в browser
 */
@DistributionPage(description = "Service for configuring web driver and processing monitors")
open class PageDistributionService : IDistributionServ {

    companion object SingletonPage {

        private lateinit var stage: Stages_web_addresses
        private lateinit var browser: string
        private var pagedist: PageDistributionService? = null
        private var isLeftMonitor: bool = false

        /**
         * Get instance of Distribution service by defining which stage to open and which browser to proceed.
         * @return Concrete realization of PageDistributionService and Selenide with configure.
         * @param stage autowired from application.properties
         * @param browser autowired from application.properties
         * @param monitor  autowired from application.properties
         */
        fun getInstance(stage: string, browser: string, monitor: Monitor): PageDistributionService {
            if (pagedist == null) {
                this.stage = Stages_web_addresses.reverse_getting(stage)
                this.browser = browser
                this.pagedist = PageDistributionService()
            }
            Configuration.browser = browser
            Configuration.webdriverLogsEnabled = true
            Configuration.timeout = 100_000
            Configuration.pageLoadTimeout = 15_000
            Configuration.screenshots = false
            Configuration.selectorMode = SelectorMode.Sizzle
            Configuration.pollingInterval = 15_000
            Configuration.reopenBrowserOnFail = false
            Configuration.fastSetValue = false
            Configuration.assertionMode = AssertionMode.SOFT
            Selenide.open(URL(this.stage.web_address))
            wait_For(0.3)
            if (monitor == Monitor.LEFT) {
//                getForSecondMonitor() //By default, browser opens on right display
            }
            WebDriverRunner.getWebDriver().manage().window().maximize()
            wait_For(0.5)
            return pagedist!!
        }

        /**
         * Get string coordinates for selenide configuration to change right monitor to second monitor
         * @sample "1920x1080" or "-1920x1080"
         */
        private fun getForSecondMonitor() {
            try {
                if (!isLeftMonitor) {
                    WebDriverRunner.getWebDriver().manage().window().position = org.openqa.selenium.Point(-1920, 1080)
                    isLeftMonitor = true
                } else {
                    isLeftMonitor = false
                }
            } catch (e: Exception) {
                println(e.message)
                println("Error in getting for second monitor")
            }
        }

        /**
         * Enumerate for monitor representation.
         * Only for two monitors. Left and Right.
         */
        enum class Monitor(var value: string) {

            RIGHT("Right"),
            LEFT("Left");
        }

        fun getWhichMonitor(): Monitor {
            if (isLeftMonitor) {
                println("Current monitor is Left")
                return Monitor.LEFT
            } else {
                println("Current monitor is Right")
                return Monitor.RIGHT
            }
        }
    }

    private constructor() {
        println("Page distribution constructor invoked")
    }

    /**
    Открывает страницу в зависимости от переданного параметра stage
     */
    override fun get_Stage(): Stages_web_addresses {
        if (pagedist != null) {
            println("Current stage is ${stage.web_address}")
            return stage
        }
        return stage
    }

    /**
     * @return Concrete realization of operator
     */
    override fun get_Operator(): IStageOperator {
        val operator: IStageOperator
        when (stage) {
            PROD -> {
                operator = FairSpin()
            }

            SLOT_PROD -> {
                operator = Web3BlockChain()
            }

            Stages_web_addresses.DEV -> {
                operator = SprutCloud()
            }

            Stages_web_addresses.STABLE -> {
                operator = SprutCloud()
            }

            Stages_web_addresses.PREPROD -> {
                operator = SprutCloud()
            }
        }
        return operator
    }

    /**
     * Static object for page actions
     */
    object Waiter {

        /**
         * Объект драйвера Selenide текущего браузера.
         * Для нахождения элементов необходимо - driver.webDriver.findElement(<селектор>)
         * @suppress Закрытие данного драйвера
         * @see Driver
         */
        private val driver: Driver = Selenide.webdriver().driver()

        /**
         * This method waits until game stop loading.
         * Wait until progress bar width equals 100% and progress bar element exists.
         * @throws com.codeborne.selenide.ex.ElementNotFound if no element presents.
         */
        fun wait_until_load() {
            println("Enter game loading wait")
            val iframe = driver.webDriver.findElement(By.id("game"))
            driver.webDriver.manage().timeouts().implicitlyWait(Durations.FIVE_MINUTES)
            driver.switchTo().frame(iframe)
            wait_For(1)
//            val canvas = driver.webDriver.findElement(By.xpath("//canvas[@id='application-canvas']"))
//            wait_For(1)
            val progressbar = driver.webDriver.findElement(By.xpath("//div[@id='progress-bar']"))
            while (true) {
                if (progressbar.getAttribute("style")!!.contains("width: 100%;")) {
                    println("Progressbar is finished")
                    val endingProgressBar: SelenideElement = Selenide.`$`(progressbar)
                    while (true) {
                        if (!endingProgressBar.isDisplayed) {
                            println("Game fully loaded")
                            wait_For(1)
                            break
                        }
                    }
                    wait_For(0.5)
                    break
                }
            }
        }

        /**
         * Method for taking text from pop up.
         * Receives text from div with container class.
         * @see Selenide.webdriver.driver.webDriver.switchTo.alert()
         * @throws com.codeborne.selenide.ex.ElementNotFound
         * @return String text from pop up or null if exception
         */
        fun get_text_from_popup(): string? {
            if (check_elem("popup") == true) {
                return driver.webDriver.switchTo().alert().text
            } else {
                println("Pop up не существует!")
                return null
            }
        }

        /**
         * Проверка, существует ли элемент на странице.
         * @param id уникальный идентификатор элемента (id в html)
         * @return булево значение - (true / false). Если элемента нет или произошла ошибка - null
         */
        fun check_elem(id: string): bool? {
            try {
                driver.webDriver.findElement(By.id(id))
                return driver.webDriver.getPageSource().contains(id)
            } catch (e: Exception) {
                println(e.stackTrace.printAll())
                println("Error in checking element on page")
            }
            return null
        }
    }
}