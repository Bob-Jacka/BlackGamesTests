package org.example.core.pages.SC_games

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.annotation.AnnotationRetention

@Retention(AnnotationRetention.RUNTIME) // Аннотация будет доступна в рантайме
@Target(AnnotationTarget.FUNCTION) // Аннотация может применяться только к классам
@Test
@DisplayName()
annotation class Test {

}
