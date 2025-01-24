package org.example.core.entities.operator

import com.codeborne.selenide.SelenideElement
import org.example.core.annotation.BetOperator
import org.example.core.entities.gameLists.GamesPageSprut
import org.example.core.functional.ActionController.get_element
import org.example.core.functional.IGameList
import org.example.core.functional.IStageOperator
import org.springframework.context.annotation.Primary

/**
 * Страница входа в оператор 'Sprut cloud'
 */
@BetOperator
@Primary
class SprutCloud : IStageOperator {

    override val user_name_field: SelenideElement = get_element("//input[@type='text' and @name='username']")
    override val user_password_field: SelenideElement? = null
    override val login_btn = get_element("//input[@type='submit']")

    constructor() {
        println("Sprut cloud operator constructor invoked")
    }

    override fun login_into_account(): IGameList {
        user_name_field.sendKeys(player)
        login_btn.click()
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