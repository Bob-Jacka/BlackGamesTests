package org.example.core.Functional.Operator

import com.codeborne.selenide.Selenide
import org.example.core.Functional.ActionController.waitFor
import org.example.core.Functional.GamesPageFairSpin
import org.example.core.pages.SC_games.StageOperator
import org.openqa.selenium.By

class FairSpin : StageOperator { //TODO переделать локаторы

    private val userName = Selenide.`$`(By.xpath("//input[@type='text']"))
    private val password = Selenide.`$`(By.xpath())
    private val loginBtn = Selenide.`$`(By.xpath("//input[@type='submit']"))


    fun loginInto(): GamesPageFairSpin {
        enterUserCred()
        loginBtn.click()
        waitFor(1)
        return GamesPageFairSpin()
    }

    /**
     * enters username on sprut page
     */
    fun enterUserCred() {
        userName.sendKeys(player_login)
        password.sendKeys(player_password)
    }

    companion object {

        private const val player_login = "q"
        private const val player_password = "q"
    }
}