package org.example.core.annotations

import org.example.core.main_functionalities.bool
import org.example.core.main_functionalities.string
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Wrapper annotation for Bet games pages, ex. GamesfairSpin or sprut.cloud.
 * Written for some semantics
 * @see org.example.core.entities.gameLists.GamesPageSprut
 */
@Component
@Scope("singleton")
annotation class BetGamesPage(

    val name: string = "",
    val isDeprecated: bool = false,
    val description: string = "",
                             )
