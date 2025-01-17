package org.example.core.entities

import com.codeborne.selenide.Browsers
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import org.example.core.annotation.DistributionPage
import org.example.core.enums.Stages
import org.example.core.functional.string

/**
 * Сервис для открытия браузера по переданному значению 'stage'
 */
@DistributionPage
open class PageDistributionService {

    private lateinit var stage: Stages
    private lateinit var browser: string

    companion object singletonPage {

        private var pagedist: PageDistributionService? = null

        fun getInstance(stage: Stages, browser: string = Browsers.CHROME): PageDistributionService? {
            if (pagedist == null) {
                pagedist = PageDistributionService(stage, browser)
            }
            return pagedist
        }
    }

    constructor()

    constructor(stage: Stages, browser: string = Browsers.CHROME) {
        this.stage = stage
        this.browser = browser
        Configuration.browser = browser
        Configuration.webdriverLogsEnabled = true
        WebDriverRunner.getWebDriver().manage().window().maximize()
    }

    /**
    Открывает страницу в зависимости от переданного параметра stage
     */
    fun getStage(): Stages {
        if (pagedist != null) {
            Selenide.open(this.stage.name)
            println("Current stage is " + this.stage)
            return this.stage
        }
        return stage
    }
}