package org.example.core.Functional

import org.example.core.Functional.GamesPageSprut
import org.example.core.enums.Env

/*
Interface for current 'sc;' game implementation
 */
interface IGame {

    fun startGame()
    fun get_in_history()
    fun enter_blockchain()
    fun setSoundOn()
    fun change_bet(up: Boolean, howMany: Int)
}

interface ISlot {

    fun startGame()
    fun bet()
    fun getInRules()
    fun change_bet(howMany: Int)
    fun change_speed(howMany: Int)
}

/*
Objects that implement this interface is "gate" to game portal
 */
interface IStageOperator {

    fun loginInto(): GamesPageSprut
    fun enterUserCred()
}

/*
List with current games and action to receive game object
 */
interface IGameList {

    fun getColorRace_game(env: Env): Game
    fun getLuckyFish_game(env: Env): Game
    fun getMooscape_game(env: Env): Game
    fun getPirate_game(env: Env): Game
}