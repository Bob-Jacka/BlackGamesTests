package org.example.core.pages.Slots

import org.example.core.functional.ActionController.click_On
import org.example.core.functional.ElemPos
import org.example.core.functional.ISlot
import org.example.core.functional.bool
import org.example.core.functional.int

class BaseSlot : ISlot {

    override var isSound: bool = false

    override val play_btn: ElemPos = ElemPos(968, 920)
    override val bet_btn: ElemPos = ElemPos(450, 640)
    override val rules_btn: ElemPos = ElemPos(1490, 959)
    override val change_page_btn: ElemPos = ElemPos(1488, 550)
    override val plus_btn: ElemPos = ElemPos(869, 965)
    override val minus_btn: ElemPos = ElemPos(1065, 965)
    override val change_speed_btn: ElemPos = ElemPos(445, 510)
    override val autoBet_btn: ElemPos = ElemPos(445, 790)
    override val sound_btn: ElemPos = ElemPos(450, 955)
    override val close_rules_btn: ElemPos = change_speed_btn

    override fun start_game() {
        click_On(play_btn)
    }

    override fun bet() {
        click_On(bet_btn)
    }

    override fun get_in_rules() {
        click_On(rules_btn)
    }

    override fun change_bet_plus(howMany: int) {
        repeat(howMany) {
            click_On(plus_btn)
        }
    }

    override fun change_bet_minus(howMany: int) {
        repeat(howMany) {
            click_On(minus_btn)
        }
    }

    override fun change_speed(howMany: int) {
        repeat(howMany) {
            click_On(change_speed_btn)
        }
    }

    override fun auto_bet_on() {
        click_On(autoBet_btn)
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

    override fun close_rules() {
        click_On(close_rules_btn)
    }

    override fun get_bet_btn(): ElemPos {
        return bet_btn
    }

    override fun change_pages_in_rules(howMany: int) {
        repeat(howMany) {
            click_On(change_page_btn)
        }
    }
}
