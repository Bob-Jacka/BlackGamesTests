package org.example.core.pages.SC_games

import org.example.core.Functional.ActionController.clickOn
import org.openqa.selenium.Point

class Pirate : IGame {

    private var isSound = false

    private val play_btn = Point(960, 870)

    private val all_red = Point(780, 800)
    private val mixed = Point(960, 800)
    private val all_black = Point(1130, 800)

    private val minus_bet = Point(890, 890)
    private val plus_bet = Point(1030, 890)

    private val balance = Point(960, 950)

    private val game_info = Point(1710, 190)
    private val sound_btn = Point(1750, 190)
    private val history_btn = Point(1800, 230)
    private val blockchaininfo_btn = Point(1800, 280)

    fun payOnRed() {
        clickOn(all_red)
    }

    fun payOnBlack() {
        clickOn(all_black)
    }

    fun payOnMixed() {
        clickOn(mixed)
    }

    override fun get_in_history() {
        clickOn(history_btn)
    }

    override fun enter_blockchain() {
        clickOn(blockchaininfo_btn)
    }

    override fun change_bet(up: Boolean, howMany: Int) {
        if (up) {
            repeat(howMany) {
                clickOn(plus_bet)
            }
        } else {
            repeat(howMany) {
                clickOn(minus_bet)
            }
        }
    }

    fun show_balance() {
        clickOn(balance)
    }

    override fun startGame() {
        clickOn(play_btn)
    }

    fun show_game_info() {
        clickOn(game_info)
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
}
