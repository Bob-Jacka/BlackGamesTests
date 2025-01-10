package org.example.core.pages.SC_games

import org.example.core.Functional.GamesPageSprut
import org.example.core.enums.Env

interface Game {

    fun startGame()
    fun get_in_history()
    fun enter_blockchain()
    fun setSoundOn()
    fun change_bet(up: Boolean, howMany: Int)
}

/*
Objects that implement this interface is "gate" to game portal
 */
interface StageOperator {

    fun loginInto(): GamesPageSprut
}

/*
List with current games and action to receive game object
 */
interface GameList {

    fun getColorRace_game(env: Env): Game
    fun getLuckyFish_game(env: Env): Game
    fun getMooscape_game(env: Env): Game
    fun getPirate_game(env: Env): Game
}