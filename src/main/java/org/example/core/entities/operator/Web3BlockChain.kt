package org.example.core.entities.operator

import com.codeborne.selenide.SelenideElement
import org.example.core.annotation.BetOperator
import org.example.core.entities.gameLists.GamesPageSprut
import org.example.core.functional.IStageOperator

/**
Site for slots
 */
@BetOperator
class Web3BlockChain : IStageOperator {

    override val user_name_field: SelenideElement? = null
    override val user_password_field: SelenideElement? = null

    override val login_btn: SelenideElement = TODO()

    constructor()

    override fun login_into_account(): GamesPageSprut {
        return TODO("Provide the return value")
    }

    override fun enter_user_cred() {
        return TODO("Provide the return value")
    }
}