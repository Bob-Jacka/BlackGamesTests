package org.example.core.functional

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement
import org.example.core.games.BetBlock

/*
 RULES:

 All methods in this file should be with underscores
 All interfaces names should start with 'I'

 Start letter interface identifiers
 'I' for interface (for specifying new game types)
 'E' for extension (Add new functions, but not type)
*/

/**
 * Global interface for games ex. Slots or SC
 */
interface IGame {

    var isSound: bool
    val play_btn: ElemPos
    val sound_btn: ElemPos

    /**
     * Every game has 'start game' function and nevermind if it slots or sc game
     */
    fun start_game()

    /**
     * Every game has 'turn on sound' function and nevermind if it slots or sc game
     */
    fun set_sound_on(state: bool)
}

/**
Interface for slot games, ex. viva la pizza, bang bang saloon
 */
interface ISlot : IGame {

    val bet_btn: ElemPos
    val rules_btn: ElemPos
    val plus_btn: ElemPos
    val minus_btn: ElemPos
    val change_speed_btn: ElemPos
    val change_page_btn: ElemPos
    val autoBet_btn: ElemPos
    val close_rules_btn: ElemPos

    fun get_in_rules()
    fun auto_bet_on()
    fun change_bet_plus(howMany: int)
    fun change_bet_minus(howMany: int)
    fun change_speed(howMany: int)
    fun change_pages_in_rules(howMany: int)
    fun close_rules()
    fun get_bet_btn(): ElemPos
}

/**
Interface with possibility to enable auto bet or auto cash out
 */
interface IEAuto {

    val autocashout_btn: ElemPos
    val autobet_btn: ElemPos

    /**
     * @sample
     * override fun enable_autobet(which_block: int, elemPos: ElemPos?) {
     *           when (which_block) {
     *              1 -> click_On(auto_bet_btn)
     *              2 -> click_On(auto_bet_btn.getFor_secondBlock())
     *          }
     *      }
     */
    fun enable_autobet(which_block: int, elemPos: ElemPos? = null)

    /**
     * @sample
     * override fun enable_autocashout(which_block: int, elemPos: ElemPos?) {
     *          when (which_block) {
     *              1 -> click_On(auto_cashout_btn)
     *              2 -> click_On(auto_cashout_btn.getFor_secondBlock())
     *          }
     *       }
     */
    fun enable_autocashout(which_block: int, elemPos: ElemPos? = null)
}

/**
Interface for games with preselects available
'ps' at the of the name means preselect
 */
interface IEPreselects {

    val one: ElemPos
    val two: ElemPos
    val three: ElemPos
    val four: ElemPos

    fun get_first_ps()
    fun get_second_ps()
    fun get_third_ps()
    fun get_fourth_ps()
}

/**
Interface for current crash game implementation
 */
interface ICrashGame {

    val first_block: BetBlock
    val second_block: BetBlock
    val input_field_coef: ElemPos
    val input_field_bet: ElemPos

    fun get_first_block(): BetBlock
    fun get_second_block(): BetBlock
}

/**
 * Interface for current casual game implementation
 */
interface ICasualGame {

    val playAudioEffects_btn: ElemPos
    val upBet_btn: ElemPos
    val downBet_btn: ElemPos

    /**
    Stake num from left to right.
    ex. in Pirate game there are 3 stakes, left is all_red on has num 0 (depending on realization)
     */
    fun bet_on_stake(stake_number: int)
}

/**
Interface for current 'sc' game implementation
 */
interface IGameSC : IGame {

    val history_btn: ElemPos
    val balance_btn: ElemPos
    val settings_btn: ElemPos
    val game_info: ElemPos

    fun get_in_history()
    fun open_settings()
    fun enter_blockchain()
    fun change_bet(up: bool, howMany: int)
}

/**
Objects that implement this interface are "gate" to game portal
 */
interface IStageOperator {

    val user_name_field: SelenideElement?
    val user_password_field: SelenideElement?
    val login_btn: SelenideElement

    fun login_into_account(): IGameList
    fun enter_user_cred()
}

/**
List with current games and action to receive game object
 */
interface IGameList {

    val gameList: ElementsCollection

    /**
     * Method for getting game by GameName enum value
     * @param gameName - enum value for game
     * @sample
     * IGame game_to_return = null;
     *         switch (game) {
     *             case COLOR_RACE -> game_to_return = get_colorRace_game();
     *             case PIRATE -> game_to_return = get_pirate_game();
     *             case MOOSCAPE -> game_to_return = get_mooscape_game();
     *             case LUCKY_FISH -> game_to_return = get_luckyFish_game();
     *         }
     *         return game_to_return;
     */
    fun get_game(gameName: string): IGame
}

/**
 * Interface for bet block for crash games
 */
interface IEBetBlock {

    val bet_btn: ElemPos
    val plus_bet: ElemPos
    val minus_bet: ElemPos
    val bet_input_field: ElemPos
    val plus_bet_btn: ElemPos
    val minus_bet_btn: ElemPos

    fun change_coef(which_block: int, up: bool, howMany: int)
    fun bet_on_block(which_block: int)
    fun get_bet_btn(): ElemPos
    fun get_minus_coef_btn(): ElemPos
    fun get_plus_coef_btn(): ElemPos
    fun get_coef_input_field(): ElemPos
}