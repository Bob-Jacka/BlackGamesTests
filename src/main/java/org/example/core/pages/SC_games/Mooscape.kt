package org.example.core.pages.SC_games

import org.example.core.Functional.ActionController
import org.example.core.Functional.ActionController.clickOn
import org.example.core.Functional.ActionController.enterByKeyboard
import org.example.core.Functional.getFor_secondBlock
import org.example.core.pages.SC_games.Mooscape.BetBlock
import org.openqa.selenium.Point

class Mooscape : IGame {

    private var isSound = false

    private val block = BetBlock()
    private val cachier_btn = Point(116, 106)
    private val play_btn = Point(960, 850)
    private val block_chain_info = Point(1785, 290)

    private val settings_btn = Point(1788, 185)
    private val sound_btn = Point(1412, 185)
    private val how_to_play = Point(1518, 185)
    private val balance = Point(1679, 185)
        //TODO добавить историю

    /**
     * first bet block of mooscape game
     * if you want second block, get first block elem and transform it with
     *
     * @see getFor_secondBlock
     */
    class BetBlock {

        val bet_btn: Point = Point(861, 855)
        val auto_bet: Point = Point(625, 795)
        val auto_cashout: Point = Point(720, 795)
        val minus_bet_btn: Point = Point(631, 840)
        val plus_bet_btn: Point = Point(750, 840)
        val bet_input_field: Point = Point(700, 840)

        val minus_coef_btn: Point = Point(840, 795)
        val plus_coef_btn: Point = Point(930, 795)
        val coef_input_field: Point = Point(885, 795)

        //preselects
        val one: Point = Point(630, 875)
        val two: Point = Point(670, 875)
        val three: Point = Point(710, 875)
        val four: Point = Point(750, 875)

        fun clickOn(elem: Point) {
            ActionController.clickOn(elem)
        }

        fun change_bet(up: Boolean, howMany: Int) {
            if (up) {
                repeat(howMany) {
                    ActionController.clickOn(plus_bet_btn)
                }
            } else {
                repeat(howMany) {
                    ActionController.clickOn(minus_bet_btn)
                }
            }
        }

        fun changeCoef(up: Boolean, howMany: Int) {
            if (up) {
                repeat(howMany) {
                    ActionController.clickOn(plus_coef_btn)
                }
            } else {
                repeat(howMany) {
                    ActionController.clickOn(minus_coef_btn)
                }
            }
        }

        fun enterCoef_FBlock(str: String) {
            ActionController.clickOn(coef_input_field)
            enterByKeyboard(str)
        }

        fun enterCoef_SBlock(str: String) {
            ActionController.clickOn(coef_input_field.getFor_secondBlock())
            enterByKeyboard(str)
        }

        fun enterBet_FBlock(str: String) {
            ActionController.clickOn(bet_input_field)
            enterByKeyboard(str)
        }

        fun enterBet_SBlock(str: String) {
            ActionController.clickOn(bet_input_field.getFor_secondBlock())
            enterByKeyboard(str)
        }
    }

    override fun startGame() {
        clickOn(play_btn)
    }

    override fun get_in_history() {
        TODO("Not yet implemented")
    }

    override fun enter_blockchain() {
        clickOn(block_chain_info)
    }

    override fun setSoundOn() {
        if (!isSound) {
            isSound = true
            clickOn(sound_btn)
        } else {
            isSound = false
            clickOn(sound_btn)
        }
    }

    override fun change_bet(up: Boolean, howMany: Int) {
        TODO("Not yet implemented")
    }

    fun open_cachier() {
        clickOn(cachier_btn)
    }

    fun open_settings() {
        clickOn(settings_btn)
    }

    fun open_how_to_play() {
        clickOn(how_to_play)
    }

    fun open_balance() {
        clickOn(balance)
    }

    fun getFirstBetBlock(): BetBlock {
        return block
    }
}
