package org.example.core.games.sc_games

import org.example.core.main_functionalities.*
import org.example.core.main_functionalities.ActionController.click_On
import org.example.core.main_functionalities.ActionController.wait_For

class Pirate : IGameSC, ICasualGame {

    override var isSound = false

    override val play_btn: ElemPos = ElemPos(960, 680)
    override val downBet_btn = ElemPos(890, 870)
    override val upBet_btn = ElemPos(1030, 870)
    override val balance_btn = ElemPos(960, 930)
    override val history_btn = ElemPos(1800, 210)

    private val all_red = ElemPos(780, 780)
    private val mixed = ElemPos(960, 780)
    private val all_black = ElemPos(1140, 780)

    override val game_info = ElemPos(1710, 165)
    override val sound_btn = ElemPos(1750, 165)
    override val playAudioEffects_btn: ElemPos = ElemPos(1795, 165)
    override val blockchaininfo_btn = ElemPos(1790, 260)

    constructor() {
        println("Pirate constructor invoked")
    }

    override fun enter_in_history() {
        click_On(history_btn)
    }

    override fun enter_blockchain() {
        click_On(blockchaininfo_btn)
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

    fun show_balance() {
        click_On(balance_btn)
    }

    override fun start_game() {
        wait_For(1)
        click_On(play_btn)
    }

    override fun enter_game_info() {
        click_On(game_info)
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

    override fun bet_on_stake(stake_number: int) {
        when (stake_number) {
            0 -> {
                payOnRed()
            }

            1 -> {
                payOnMixed()
            }

            2 -> {
                payOnBlack()
            }
        }
    }

    fun payOnRed() {
        click_On(all_red)
    }

    fun payOnBlack() {
        click_On(all_black)
    }

    fun payOnMixed() {
        click_On(mixed)
    }
}
