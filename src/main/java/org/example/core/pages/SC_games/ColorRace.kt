package org.example.core.pages.SC_games

import org.example.core.Functional.ActionController.clickOn
import org.openqa.selenium.Point

class ColorRace : Game {

    private var isSound = false

    private val cachier_btn: Point = Point(116, 106)
    private val play_btn: Point = Point(960, 730)
    private val upBet_btn: Point = Point(1032, 863)
    private val lowBet_btn: Point = Point(885, 863)
    private val balance_btn: Point = Point(960, 938)
    private val blockchainInfo_btn: Point = Point(1780, 250)
    private val history_btn: Point = Point(1690, 145)
    private val playAudioEffects_btn: Point = Point(1735, 145)
    private val playMusic_btn: Point = Point(1780, 145)

    private val blueBet: Point = Point(820, 780)
    private val greenBet: Point = Point(920, 780)
    private val purpleBet: Point = Point(1020, 780)
    private val redBet: Point = Point(1120, 780)

    override fun startGame() {
        clickOn(play_btn)
    }

    override fun get_in_history() {
        clickOn(history_btn)
    }

    fun payOn_Blue() {
        clickOn(blueBet)
    }

    fun payOn_Green() {
        clickOn(greenBet)
    }

    fun payOn_Purple() {
        clickOn(purpleBet)
    }

    fun payOn_Red() {
        clickOn(redBet)
    }

    fun payOn_All() {
        clickOn(blueBet)
        clickOn(greenBet)
        clickOn(purpleBet)
        clickOn(redBet)
    }

    fun setAudioEffectsOn() {
        if (!isSound) {
            isSound = true
            clickOn(playAudioEffects_btn)
        } else {
            isSound = false
            clickOn(playAudioEffects_btn)
        }
    }

    override fun setSoundOn() {
        if (!isSound) {
            isSound = true
            clickOn(playMusic_btn)
        } else {
            isSound = false
            clickOn(playMusic_btn)
        }
    }

    override fun change_bet(up: Boolean, howMany: Int) {
        if (up) {
            repeat(howMany) {
                clickOn(upBet_btn)
            }

        } else {
            repeat(howMany) {
                clickOn(lowBet_btn)
            }
        }
    }

    override fun enter_blockchain() {
        clickOn(blockchainInfo_btn)
    }
}
