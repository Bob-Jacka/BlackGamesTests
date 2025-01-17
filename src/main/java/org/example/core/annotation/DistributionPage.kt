package org.example.core.annotation

import org.example.core.functional.bool
import org.example.core.functional.string
import org.springframework.stereotype.Service

/**
 * Wrapper annotation for distribution service, ex. PageDistributionService
 * Written for some semantics
 * @see org.example.core.entities.PageDistributionService
 */
@Service
annotation class DistributionPage(

    val name: string = "",
    val isDeprecated: bool = false,
    val description: string = "",
                                 )
