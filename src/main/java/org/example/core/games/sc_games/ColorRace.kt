package org.example.core.games.sc_games

import org.example.core.main_functionalities.*
import org.example.core.main_functionalities.ActionController.click_On

class ColorRace : IGameSC, ICasualGame {

    override var isSound = false

    override val play_btn: ElemPos = ElemPos(960, 730)
    override val balance_btn: ElemPos = ElemPos(960, 938)
    override val sound_btn: ElemPos = ElemPos(1780, 145)
    override val history_btn: ElemPos = ElemPos(1690, 145)
    override val game_info: ElemPos = ElemPos(1700, 165)
    override val upBet_btn: ElemPos = ElemPos(1032, 863)
    override val downBet_btn: ElemPos = ElemPos(885, 863)
    override val blockchaininfo_btn: ElemPos = ElemPos(1780, 250)

    override val playAudioEffects_btn: ElemPos = ElemPos(1735, 145)

    private val blueBet: ElemPos = ElemPos(820, 780)
    private val greenBet: ElemPos = ElemPos(920, 780)
    private val purpleBet: ElemPos = ElemPos(1020, 780)
    private val redBet: ElemPos = ElemPos(1120, 780)

    override fun start_game() {
        click_On(play_btn)
    }

    override fun enter_in_history() {
        click_On(history_btn)
    }

    override fun bet_on_stake(stake_num: int) {
        when (stake_num) {
            0 -> {
                payOn_Blue()
            }

            1 -> {
                payOn_Green()
            }

            2 -> {
                payOn_Purple()
            }

            3 -> {
                payOn_Red()
            }
        }
    }

    fun payOn_Blue() {
        click_On(blueBet)
    }

    fun payOn_Green() {
        click_On(greenBet)
    }

    fun payOn_Purple() {
        click_On(purpleBet)
    }

    fun payOn_Red() {
        click_On(redBet)
    }

    fun payOn_All() {
        click_On(blueBet)
        click_On(greenBet)
        click_On(purpleBet)
        click_On(redBet)
    }

    fun setAudioEffectsOn() {
        if (!isSound) {
            isSound = true
            click_On(playAudioEffects_btn)
        } else {
            isSound = false
            click_On(playAudioEffects_btn)
        }
    }

    override fun set_sound_on(state: bool) {
        isSound = state
        if (!isSound) {
            isSound = true
            click_On(sound_btn)
        } else {
            isSound = false
            click_On(sound_btn)
        }
    }

    override fun change_bet(up: bool, howMany: int) {
        if (up) {
            repeat(howMany) {
                click_On(upBet_btn)
            }

        } else {
            repeat(howMany) {
                click_On(downBet_btn)
            }
        }
    }

    override fun enter_blockchain() {
        click_On(blockchaininfo_btn)
    }

    override fun enter_game_info() {
        click_On(game_info)
    }
}
