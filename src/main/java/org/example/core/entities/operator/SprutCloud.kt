package org.example.core.entities.operator

import com.codeborne.selenide.Selenide
import org.example.core.Functional.ActionController.waitFor
import org.example.core.Functional.GamesPageSprut
import org.example.core.pages.SC_games.IStageOperator
import org.openqa.selenium.By

@Component
class SprutCloud : IStageOperator {

    private val userName = Selenide.`$`(By.xpath("//input[@type='text']"))
    private val loginBtn = Selenide.`$`(By.xpath("//input[@type='submit']"))

    override fun loginInto(): GamesPageSprut {
        loginBtn.click()
        waitFor(1)
        return GamesPageSprut()
    }

    /**
     * enters username on sprut page
     */
    override fun enterUserCred() {
        userName.sendKeys(player)
    }

    companion object {

        private const val player = "q"
        private const val empty_player = "empty"
    }
}