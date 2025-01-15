package org.example.core.entities.operator

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.example.core.annotation.BetOperator
import org.example.core.entities.gameLists.GamesPageFairSpin
import org.example.core.functional.ActionController.wait_For
import org.example.core.functional.IGameList
import org.example.core.functional.IStageOperator
import org.openqa.selenium.By

@BetOperator
class FairSpin : IStageOperator { //TODO переделать локаторы

    override val user_name_field: SelenideElement = Selenide.`$`(By.xpath(""))
    override val user_password_field: SelenideElement = Selenide.`$`(By.xpath(""))
    override val login_btn: SelenideElement = Selenide.`$`(By.xpath("")) //TODO()
    private val loginBtn = Selenide.`$`(By.xpath(""))

    override fun login_into_account(): IGameList {
        enter_user_cred()
        loginBtn.click()
        wait_For(1)
        return GamesPageFairSpin()
    }

    /**
     * enters username on sprut page
     */
    override fun enter_user_cred() {
        user_name_field.sendKeys(player_login)
        user_password_field.sendKeys(player_password)
    }

    companion object Credits {

        private const val player_login = "q"
        private const val player_password = "q"
    }
}