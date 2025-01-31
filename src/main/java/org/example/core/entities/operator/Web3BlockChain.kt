package org.example.core.entities.operator

import com.codeborne.selenide.SelenideElement
import org.example.core.annotations.BetOperator
import org.example.core.entities.gameLists.GamesPageSprut
import org.example.core.main_functionalities.ActionController.get_element
import org.example.core.main_functionalities.IStageOperator

/**
Site for slots
 */
@BetOperator
class Web3BlockChain : IStageOperator {

    //TODO добавить локаторы

    override val user_name_field: SelenideElement? = get_element("")
    override val user_password_field: SelenideElement? = get_element("")

    override val login_btn: SelenideElement = get_element("")

    constructor()

    override fun login_into_account(): GamesPageSprut {
        return TODO("Provide the return value")
    }

    override fun enter_user_cred() {
        return TODO("Provide the return value")
    }
}