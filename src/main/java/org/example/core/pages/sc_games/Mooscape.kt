package org.example.core.pages.sc_games

import org.example.core.functional.*
import org.example.core.functional.ActionController.click_On
import org.example.core.pages.BetBlock

class Mooscape : IGameSC, ICrashGame {

    override var isSound = false
    override val game_info: ElemPos = TODO()

    override val first_block = BetBlock()
    override val second_block: BetBlock =
        BetBlock.BetBlockBuilder()
            .one(first_block.one.forSecondBlock())
            .two(first_block.two.forSecondBlock())
            .three(first_block.three.forSecondBlock())
            .four(first_block.four.forSecondBlock())
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

    override val play_btn = ElemPos(960, 850)

    override val settings_btn = ElemPos(1788, 185)
    override val sound_btn: ElemPos = ElemPos(1412, 185)
    override fun bet() {
        TODO("Not yet implemented")
    }

    override val balance_btn = ElemPos(1679, 185)
    override val history_btn: ElemPos = TODO()
    private val cachier_btn: ElemPos = ElemPos(116, 106)
    private val how_to_play = ElemPos(1518, 185)
    private val block_chain_info = ElemPos(1785, 290)

    override val input_field_coef: ElemPos = TODO()
    override val input_field_bet: ElemPos = TODO()

    override fun start_game() {
        click_On(play_btn)
    }

    override fun get_in_history() {
        TODO("Not yet implemented")
    }

    override fun enter_blockchain() {
        click_On(block_chain_info)
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
        TODO("Not yet implemented")
    }

    fun open_cachier() {
        click_On(cachier_btn)
    }

    override fun open_settings() {
        click_On(settings_btn)
    }

    fun open_how_to_play() {
        click_On(how_to_play)
    }

    fun open_balance() {
        click_On(balance_btn)
    }

    override fun bet_on_block(which_block: BetBlock) {
        TODO("Not yet implemented")
    }

    override fun get_first_block(): BetBlock {
        return first_block
    }

    override fun get_second_block(): BetBlock {
        return second_block
    }
}
