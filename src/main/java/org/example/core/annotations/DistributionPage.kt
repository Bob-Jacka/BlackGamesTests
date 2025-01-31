package org.example.core.annotations

import org.example.core.main_functionalities.bool
import org.example.core.main_functionalities.string
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Wrapper annotation for distribution service, ex. PageDistributionService.
 * Written for some semantics.
 * @see org.example.core.entities.PageDistributionService
 */
@Component
@Scope("singleton")
annotation class DistributionPage(

    val name: string = "",
    val isDeprecated: bool = false,
    val description: string = "",
                                 )
