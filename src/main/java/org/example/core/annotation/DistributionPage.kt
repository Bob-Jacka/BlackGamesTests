package org.example.core.annotation

import org.example.core.functional.bool
import org.example.core.functional.string
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Wrapper annotation for distribution service, ex. PageDistributionService
 * Written for some semantics
 * @see org.example.core.entities.PageDistributionService
 */
@Component
@Scope("singleton")
annotation class DistributionPage(

    val name: string = "",
    val isDeprecated: bool = false,
    val description: string = "",
                                 )
