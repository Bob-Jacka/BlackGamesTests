package org.example.core.entities.operator

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.example.core.annotation.BetOperator
import org.example.core.entities.gameLists.GamesPageSprut
import org.example.core.functional.ActionController.wait_For
import org.example.core.functional.IGameList
import org.example.core.functional.IStageOperator
import org.openqa.selenium.By

@BetOperator
class SprutCloud : IStageOperator {

    override val user_name_field: SelenideElement = Selenide.`$`(By.xpath("//input[@type='text']"))
    override val user_password_field: SelenideElement? = null
    override val login_btn = Selenide.`$`(By.xpath("//input[@type='submit']"))

    override fun login_into_account(): IGameList {
        login_btn.click()
        wait_For(1)
        return GamesPageSprut()
    }

    /**
     * enters username on sprut page
     */
    override fun enter_user_cred() {
        user_name_field.sendKeys(player)
    }

    companion object credits {

        private const val player = "q"
        private const val empty_player = "empty"
    }
}