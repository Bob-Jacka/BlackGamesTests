package org.example.core.games.sc_games

import org.example.core.games.BetBlock
import org.example.core.main_functionalities.*
import org.example.core.main_functionalities.ActionController.click_On

class Mooscape : IGameSC, ICrashGame {

    override var isSound = false

    override val game_info: ElemPos = ElemPos(-400, 160)

    override val first_block = BetBlock()
    override val second_block: BetBlock =
        BetBlock.BetBlockBuilder()
            .one(first_block.one_elem.forSecondBlock())
            .two(first_block.two_elem.forSecondBlock())
            .three(first_block.three_elem.forSecondBlock())
            .four(first_block.four_elem.forSecondBlock())
            .bet_btn(first_block._bet_btn.forSecondBlock())
            .autobet_btn(first_block.autobet_btn.forSecondBlock())
            .autocashout_btn(first_block.autocashout_btn.forSecondBlock())
            .minus_bet_btn(first_block.minus_bet_btn.forSecondBlock())
            .plus_bet_btn(first_block.plus_bet_btn.forSecondBlock())
            .plus_coef_btn(first_block._plus_coef_btn.forSecondBlock())
            .minus_coef_btn(first_block._minus_coef_btn.forSecondBlock())
            .coef_input_field(first_block._coef_input_field.forSecondBlock())
            .bet_input_field(first_block.bet_input_field.forSecondBlock())
            .build()

    override val play_btn = ElemPos(960, 670)
    override val settings_btn = ElemPos(1788, 185)
    override val sound_btn: ElemPos = ElemPos(1412, 185)
    override val balance_btn = ElemPos(1679, 185)
    override val history_btn: ElemPos = ElemPos(-134, 210)
    private val how_to_play = ElemPos(1518, 185)
    override val blockchaininfo_btn = ElemPos(1785, 290)

    override val input_field_coef: ElemPos = ElemPos(-1027, 775)
    override val input_field_bet: ElemPos = ElemPos(-1228, 820)

    override fun start_game() {
        click_On(play_btn)
    }

    override fun enter_in_history() {
        click_On(history_btn)
    }

    override fun enter_blockchain() {
        click_On(blockchaininfo_btn)
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

    override fun change_bet(up: bool, howMany: int) {
        if (up) {
            repeat(howMany) {
                click_On(first_block.plus_bet_btn)
            }
        } else {
            repeat(howMany) {
                click_On(first_block.minus_bet_btn)
            }
        }
    }

    override fun enter_settings() {
        click_On(settings_btn)
    }

    fun open_how_to_play() {
        click_On(how_to_play)
    }

    fun open_balance() {
        click_On(balance_btn)
    }

    override fun get_first_block(): BetBlock {
        return first_block
    }

    override fun get_second_block(): BetBlock {
        return second_block
    }

    override fun enter_settings_btn(): ElemPos {
        return settings_btn
    }
}
