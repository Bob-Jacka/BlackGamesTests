package org.example.core.annotations

import org.aspectj.lang.annotation.Aspect
import org.example.core.main_functionalities.string
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Annotation for aspects.
 * @since 31.01.2025
 */
@Aspect
@Component
@Scope("singleton")
annotation class ControllerAspect(

    val name: string = "",
    val since: string = "",
    val description: string = "",
                                 )
