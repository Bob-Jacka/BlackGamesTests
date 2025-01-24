package org.example.core.games.sc_games

import org.example.core.functional.*
import org.example.core.functional.ActionController.click_On

class Pirate : IGameSC, ICasualGame {

    //TODO заменить нулевые координаты и методы с двумя слэшами

    override var isSound = false

    override val settings_btn: ElemPos = ElemPos(0, 0)
    override val play_btn: ElemPos = ElemPos(960, 870)
    override val downBet_btn = ElemPos(890, 890)
    override val upBet_btn = ElemPos(1030, 890)
    override val balance_btn = ElemPos(960, 950)
    override val history_btn = ElemPos(1800, 230)

    private val all_red = ElemPos(780, 800)
    private val mixed = ElemPos(960, 800)
    private val all_black = ElemPos(1130, 800)

    override val game_info = ElemPos(1710, 190)
    override val sound_btn = ElemPos(1750, 190)
    override val playAudioEffects_btn: ElemPos = ElemPos(0, 0)

    private val blockchaininfo_btn = ElemPos(1800, 280)

    constructor() {
        println("Pirate constructor invoked")
    }

    override fun get_in_history() {
        click_On(history_btn)
    }

    override fun open_settings() {
        //
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
        click_On(play_btn)
    }

    fun show_game_info() {
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
