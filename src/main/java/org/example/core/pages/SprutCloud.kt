package org.example.core.pages

import com.codeborne.selenide.Browsers
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import org.example.core.pages.ActionController.waitFor
import org.openqa.selenium.By

class SprutCloud(browser: String = Browsers.CHROME) {

    private val userName = Selenide.`$`(By.xpath("//input[@type='text']"))
    private val loginBtn = Selenide.`$`(By.xpath("//input[@type='submit']"))

    /**
     * creates page object and opens start page of sprut cloud
     */
    init {
        Configuration.browser = browser
        Configuration.webdriverLogsEnabled = true
        waitFor(1)
        Selenide.open(url)
        WebDriverRunner.getWebDriver().manage().window().maximize()
    }

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

        private const val url = "https://dev.sprut.cloud/wl/index.php"
        private const val player = "q"
    }
}
