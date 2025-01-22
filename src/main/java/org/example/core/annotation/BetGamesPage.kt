package org.example.core.annotation

import org.example.core.functional.bool
import org.example.core.functional.string
import org.springframework.stereotype.Component

/**
 * Wrapper annotation for Bet games pages, ex. GamesfairSpin or sprut.cloud.
 * Written for some semantics
 * @see org.example.core.entities.gameLists.GamesPageSprut
 */
@Component
annotation class BetGamesPage(

    val name: string = "",
    val isDeprecated: bool = false,
    val description: string = "",
                             )
