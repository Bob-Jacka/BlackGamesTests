package org.example.core.pages.sc_games

import org.example.core.functional.ActionController.click_On
import org.example.core.functional.ElemPos
import org.example.core.functional.IGameSC
import org.example.core.functional.bool
import org.example.core.functional.int

class ColorRace : IGameSC {

    override var isSound = false
    override val settings_btn: ElemPos = TODO()
    override val play_btn: ElemPos = ElemPos(960, 730)
    override val balance_btn: ElemPos = ElemPos(960, 938)
    override val sound_btn: ElemPos = ElemPos(1780, 145)

    override val history_btn: ElemPos = ElemPos(1690, 145)

    override val game_info: ElemPos = TODO()

    private val upBet_btn: ElemPos = ElemPos(1032, 863)
    private val lowBet_btn: ElemPos = ElemPos(885, 863)
    private val blockchainInfo_btn: ElemPos = ElemPos(1780, 250)

    private val playAudioEffects_btn: ElemPos = ElemPos(1735, 145)

    private val blueBet: ElemPos = ElemPos(820, 780)
    private val greenBet: ElemPos = ElemPos(920, 780)
    private val purpleBet: ElemPos = ElemPos(1020, 780)
    private val redBet: ElemPos = ElemPos(1120, 780)

    override fun start_game() {
        click_On(play_btn)
    }

    override fun get_in_history() {
        click_On(history_btn)
    }

    override fun open_settings() {
        TODO("Not yet implemented")
    }

    override fun bet() {
        TODO("Not yet implemented")
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
                click_On(lowBet_btn)
            }
        }
    }

    override fun enter_blockchain() {
        click_On(blockchainInfo_btn)
    }
}
