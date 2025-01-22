package org.example.core.entities

import com.codeborne.selenide.AssertionMode
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import org.example.core.annotation.DistributionPage
import org.example.core.enums.Stages_web_addresses
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
            Configuration.timeout = 5_000
            Configuration.pageLoadTimeout = 5_000
            Configuration.screenshots = false
            Configuration.pollingInterval = 10_000

//            Configuration.browserPosition = getForSecondMonitor()

            Configuration.reopenBrowserOnFail = false
            Configuration.fastSetValue = false
            Configuration.assertionMode = AssertionMode.SOFT
            Selenide.open(URL(this.stage.stage_name))
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

    constructor() {
        println("Default constructor invoked")
    }

    /**
    Открывает страницу в зависимости от переданного параметра stage
     */
    fun getStage(): Stages_web_addresses {
        if (pagedist != null) {
            println("Current stage is $stage")
            return stage
        }
        return stage
    }
}