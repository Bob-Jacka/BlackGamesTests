package org.example.core.entities.operator

import com.codeborne.selenide.SelenideElement
import org.example.core.annotation.BetOperator
import org.example.core.entities.gameLists.GamesPageFairSpin
import org.example.core.functional.ActionController.get_element
import org.example.core.functional.ActionController.wait_For
import org.example.core.functional.IGameList
import org.example.core.functional.IStageOperator

@BetOperator
class FairSpin : IStageOperator {

    override val user_name_field: SelenideElement = get_element("")
    override val user_password_field: SelenideElement = get_element("")
    override val login_btn: SelenideElement = get_element("") //TODO(Дописать селекторы)
    private val favourite_btn: SelenideElement = get_element("")

    constructor()

    override fun login_into_account(): IGameList {
        enter_user_cred()
        login_btn.click()
        wait_For(1)
        return GamesPageFairSpin()
    }

    /**
     * enters username on fair spin page
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