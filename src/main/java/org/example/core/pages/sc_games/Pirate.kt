package org.example.core.pages.sc_games

import org.example.core.functional.ActionController.click_On
import org.example.core.functional.ElemPos
import org.example.core.functional.IGameSC
import org.example.core.functional.bool
import org.example.core.functional.int

class Pirate : IGameSC {

    override var isSound = false

    override val settings_btn: ElemPos = TODO()
    override val play_btn: ElemPos = ElemPos(960, 870)
    private val minus_bet = ElemPos(890, 890)
    private val plus_bet = ElemPos(1030, 890)
    override val balance_btn = ElemPos(960, 950)
    override val history_btn = ElemPos(1800, 230)

    private val all_red = ElemPos(780, 800)
    private val mixed = ElemPos(960, 800)
    private val all_black = ElemPos(1130, 800)

    override val game_info = ElemPos(1710, 190)
    override val sound_btn = ElemPos(1750, 190)

    private val blockchaininfo_btn = ElemPos(1800, 280)

    fun payOnRed() {
        click_On(all_red)
    }

    fun payOnBlack() {
        click_On(all_black)
    }

    fun payOnMixed() {
        click_On(mixed)
    }

    override fun get_in_history() {
        click_On(history_btn)
    }

    override fun open_settings() {
        TODO("Not yet implemented")
    }

    override fun enter_blockchain() {
        click_On(blockchaininfo_btn)
    }

    override fun change_bet(up: bool, howMany: int) {
        if (up) {
            repeat(howMany) {
                click_On(plus_bet)
            }
        } else {
            repeat(howMany) {
                click_On(minus_bet)
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

    override fun bet() {
        TODO("Not yet implemented")
    }
}
