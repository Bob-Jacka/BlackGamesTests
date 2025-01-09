package org.example.core.pages

import com.codeborne.selenide.Browsers
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import org.example.core.pages.ActionController.waitFor
import org.openqa.selenium.By

abstract class General_stage {}

class PageDistribution {

    private lateinit var stage: Stages
    private lateinit var browser: String

    constructor(stage: Stages, browser: String = Browsers.CHROME) { 
        this.stage = stage
        this.browser = browser
        Configuration.browser = browser
        Configuration.webdriverLogsEnabled = true
        WebDriverRunner.getWebDriver().manage().window().maximize()
    }
    
    /*
    Возвращает страницу в зависимости от переданного параметра stage
     */
    fun getStage() : General_stage {
        curr_stage = this.stage.getName()
        Selenide.open(curr_stage)
        System.`out`("Currenct stage is " + this.stage)
    }
}

class SprutCloud: General_stage {

    private val userName = Selenide.`$`(By.xpath("//input[@type='text']"))
    private val loginBtn = Selenide.`$`(By.xpath("//input[@type='submit']"))
    
    fun loginInto(): GamesPage {
        loginBtn.click()
        waitFor(1)
        return GamesPage()
    }

    /**
     * enters username on sprut page
     */
    fun enterUserName() {
        userName.sendKeys(player)
    }

    companion object {
        
        private const val player = "q"
        private const val empty_player = "empty"
    }
}

class FairSpinProd: General_stage { //TODO переделать локаторы

    private val userName = Selenide.`$`(By.xpath("//input[@type='text']"))
    private val loginBtn = Selenide.`$`(By.xpath("//input[@type='submit']"))

    companion object {
        
        private const val player_login = "q"
        private const val player_password = "q"
    }
}
