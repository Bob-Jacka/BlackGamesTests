package org.example.core.Functional

import com.codeborne.selenide.Browsers
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import org.example.core.enums.Stages

@Service
class PageDistributionService {

    private var stage: Stages
    private var browser: String
    
    companion object singletonPage {

        private var pagedist: PageDistributionService = null

        fun PageDistributionService getInstance(stage: Stages, browser: String = Browsers.CHROME) {
            if (pagedist == null) {
                pagedist = PageDistributionService(stage, browser)
            }
            return pagedist
        }
    }

    private constructor(stage: Stages, browser: String = Browsers.CHROME) {
        this.stage = stage
        this.browser = browser
        Configuration.browser = browser
        Configuration.webdriverLogsEnabled = true
        WebDriverRunner.getWebDriver().manage().window().maximize()
    }

    /*
        Возвращает страницу в зависимости от переданного параметра stage
     */
    fun getStage(): Stages {
        if (pagedist != null) {
            Selenide.open(this.stage.name)
            println("Currenct stage is " + this.stage)
            return this.stage
        }
    }
}
