package org.example.core.annotations

import org.example.core.main_functionalities.bool
import org.example.core.main_functionalities.string
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Wrapper annotation for Bet operators, ex. fairSpin or sprut.cloud
 */
@Component
@Scope("singleton")
annotation class BetOperator(

    val name: string = "",
    val isDeprecated: bool = false,
    val description: string = "",
                            )
