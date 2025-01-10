package org.example.core.pages.SC_games

import org.example.core.Functional.ActionController.clickOn
import org.openqa.selenium.Point

class LuckyFish : Game {

    private var isSound = false

    private val play_btn: Point = Point(959, 750)
    private val bet_btn: Point = Point(957, 870)
    private val autobet_btn: Point = Point(800, 730)
    private val autocashout_btn: Point = Point(900, 730)
    private val game_info: Point = Point(1700, 185)
    private val sound_btn: Point = Point(1740, 185)
    private val blockchain_info: Point = Point(1780, 290)
    private val game_history: Point = Point(1780, 230)

    private val minus_coef: Point = Point(1030, 730)
    private val plus_coef: Point = Point(1120, 730)
    private val input_field_coef: Point = Point(1070, 730)

    private val minus_bet: Point = Point(815, 780)
    private val plus_bet: Point = Point(970, 780)
    private val input_field_bet: Point = Point(900, 780)

    //preselects
    private val one: Point = Point(810, 820)
    private val two: Point = Point(870, 820)
    private val five: Point = Point(920, 820)
    private val ten: Point = Point(980, 820)

    private val balance: Point = Point(960, 940)

    private val reload_btn: Point = Point(963, 735)

    override fun startGame() {
        clickOn(play_btn)
    }

    override fun get_in_history() {
        clickOn(game_history)
    }

    override fun enter_blockchain() {
        clickOn(blockchain_info)
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

    fun show_gameinfo() {
        clickOn(game_info)
    }

    fun bet() {
        clickOn(bet_btn)
    }

    fun enable_autocashout() {
        clickOn(autocashout_btn)
    }

    fun enable_autobet() {
        clickOn(autobet_btn)
    }

    fun change_coef(up: Boolean, howMany: Int) {
        if (up) {
            repeat(howMany) {
                clickOn(plus_coef)
            }
        } else {
            repeat(howMany) {
                clickOn(minus_coef)
            }
        }
    }
}
