package org.example.core.entities

import com.codeborne.selenide.*
import org.example.core.annotation.DistributionPage
import org.example.core.entities.operator.FairSpin
import org.example.core.entities.operator.SprutCloud
import org.example.core.entities.operator.Web3BlockChain
import org.example.core.enums.Stages_web_addresses
import org.example.core.enums.Stages_web_addresses.PROD
import org.example.core.enums.Stages_web_addresses.SLOT_PROD
import org.example.core.functional.ActionController.wait_For
import org.example.core.functional.IStageOperator
import org.example.core.functional.string
import java.awt.Dimension
import java.awt.Toolkit
import java.net.URL

/**
 * Сервис для открытия браузера по переданному значению 'stage' в browser
 */
@DistributionPage
open class PageDistributionService {

    companion object SingletonPage {

        private lateinit var stage: Stages_web_addresses
        private lateinit var browser: string
        private var pagedist: PageDistributionService? = null

        /**
         * Get instance of Distribution service by defining which stage to open and which browser to proceed
         * @param stage autowired from application.properties
         * @param browser autowired from application.properties
         */
        fun getInstance(stage: string, browser: string): PageDistributionService {
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

//            Configuration.browserPosition = getForSecondMonitor()
            Configuration.reopenBrowserOnFail = true
            Configuration.fastSetValue = false
            Configuration.assertionMode = AssertionMode.SOFT
            Selenide.open(URL(this.stage.stage_name))
            wait_For(1)
            WebDriverRunner.getWebDriver().manage().window().maximize()
            return pagedist!!
        }

        /**
         * Get coordinates for second monitor
         * @sample "1920x1080"
         */
        fun getForSecondMonitor(): string {
            val dimension: Dimension = Toolkit.getDefaultToolkit().screenSize
            val width = dimension.width
            val height = dimension.height
            return "$width" + "x" + "$height"
        }
    }

    private constructor() {
        println("Page distribution constructor invoked")
    }

    /**
    Открывает страницу в зависимости от переданного параметра stage
     */
    fun getStage(): Stages_web_addresses {
        if (pagedist != null) {
            println("Current stage is ${stage.stage_name}")
            return stage
        }
        return stage
    }

    fun getOperator(): IStageOperator {
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
}