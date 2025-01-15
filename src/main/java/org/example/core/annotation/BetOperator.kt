package org.example.core.annotation

import org.example.core.functional.bool
import org.example.core.functional.string
import org.springframework.stereotype.Component

/**
 * Wrapper annotation for Bet operators, ex. fairSpin or sprut.cloud
 */
@Component
annotation class BetOperator(

    val name: string = "",
    val isDepricated: bool = false,
    val description: string = "",
                            )
