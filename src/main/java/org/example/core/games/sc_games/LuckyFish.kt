package org.example.core.games.sc_games

import org.example.core.functional.*
import org.example.core.functional.ActionController.click_On
import org.example.core.games.BetBlock

class LuckyFish : IGameSC, ICrashGame, IEAuto, IEPreselects {

    //TODO заменить все todo и нулевые позиции и методы со слэшами

    override var isSound = false

    override val play_btn: ElemPos = ElemPos(959, 750)
    override val history_btn: ElemPos = ElemPos(1780, 230)
    override val first_block: BetBlock = TODO()
    override val second_block: BetBlock = TODO("Возможно будет реализовано позже, но пока в игре только один блок")

    override val balance_btn: ElemPos = ElemPos(960, 940)
    override val settings_btn: ElemPos = ElemPos(0, 0)
    override val sound_btn: ElemPos = ElemPos(1740, 185)

    private val bet_btn: ElemPos = ElemPos(957, 870)
    override val autobet_btn: ElemPos = ElemPos(800, 730)
    override val autocashout_btn: ElemPos = ElemPos(900, 730)
    override val game_info: ElemPos = ElemPos(1700, 185)

    private val blockchain_info: ElemPos = ElemPos(1780, 290)

    private val minus_coef: ElemPos = ElemPos(1030, 730)
    private val plus_coef: ElemPos = ElemPos(1120, 730)
    override val input_field_coef: ElemPos = ElemPos(1070, 730)

    private val minus_bet: ElemPos = ElemPos(815, 780)
    private val plus_bet: ElemPos = ElemPos(970, 780)
    override val input_field_bet: ElemPos = ElemPos(900, 780)

    //Preselects
    override val one: ElemPos = ElemPos(810, 820)
    override val two: ElemPos = ElemPos(870, 820)
    override val three: ElemPos = ElemPos(920, 820)
    override val four: ElemPos = ElemPos(980, 820)

    private val reload_btn: ElemPos = ElemPos(963, 735)

    override fun start_game() {
        click_On(play_btn)
    }

    override fun get_in_history() {
        click_On(history_btn)
    }

    override fun open_settings() {
        //
    }

    override fun enter_blockchain() {
        click_On(blockchain_info)
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
                click_On(plus_bet)
            }
        } else {
            repeat(howMany) {
                click_On(minus_bet)
            }
        }
    }

    fun show_gameinfo() {
        click_On(game_info)
    }

    override fun enable_autobet(which_block: int, elemPos: ElemPos?) {
        when (which_block) {
            1 -> click_On(autobet_btn)
            2 -> click_On(autobet_btn.forSecondBlock())
        }
    }

    override fun enable_autocashout(which_block: int, elemPos: ElemPos?) {
        when (which_block) {
            1 -> click_On(autocashout_btn)
            2 -> click_On(autocashout_btn.forSecondBlock())
        }
    }

    fun change_coef(up: bool, howMany: int) {
        if (up) {
            repeat(howMany) {
                click_On(plus_coef)
            }
        } else {
            repeat(howMany) {
                click_On(minus_coef)
            }
        }
    }

    override fun get_first_ps() {
        click_On(one)
    }

    override fun get_second_ps() {
        click_On(two)
    }

    override fun get_third_ps() {
        click_On(three)
    }

    override fun get_fourth_ps() {
        click_On(four)
    }

    override fun get_first_block(): BetBlock {
        return first_block
    }

    override fun get_second_block(): BetBlock {
        return second_block
    }

    fun bet() {
        click_On(bet_btn)
    }
}
