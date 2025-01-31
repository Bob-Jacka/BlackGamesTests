package org.example.core.annotations

import io.qameta.allure.SeverityLevel
import org.example.core.main_functionalities.bool
import org.example.core.main_functionalities.string
import org.junit.jupiter.api.Test

/**
 * Base annotation for tests in 'test' directory.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Test
annotation class TestCase(

    /**
     * Severity of the test.
     */
    val severity: SeverityLevel = SeverityLevel.MINOR,

    /**
     *Name of the test.
     */
    val name: string = "",

    /**
     * Indicates that test is flaky.
     */
    val isFlaky: bool = false,

    /**
     * Tag of the test, positive | negative.
     */
    val tag: string = "",

    /**
     * Labels of the test, ex. Performance or Security.
     */
    val labels: Array<string> = [],

    /**
     * Description of the test.
     */
    val description: string = "",

    /**
     * Owner of the test, ex. <Tester name>.
     */
    val owner: string = "",

    /**
     * Epic of the test.
     */
    val epic: string = "",

    /**
     * Feature of the test.
     */
    val feature: string = "",

    /**
     * Story of the test.
     */
    val story: string = "",

    )
