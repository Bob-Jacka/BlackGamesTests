package org.example.core.annotation

import io.qameta.allure.SeverityLevel
import org.example.core.functional.bool
import org.example.core.functional.string
import org.junit.jupiter.api.Test

@Retention(AnnotationRetention.RUNTIME) // Аннотация будет доступна в рантайме
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS) // Аннотация может применяться только к классам
@Test
annotation class Test(

    /**
     * Severity of the test
     */
    val severity: SeverityLevel = SeverityLevel.MINOR,

    /**
     *Name of the test
     */
    val name: string = "",

    /**
     *Indicates that test is flaky
     */
    val isFlaky: bool = false,

    /**
     *Tag of the test, positive | negative
     */
    val tag: string = "",

    /**
     *Labels of the test, ex. Performance or Security
     */
    val labels: Array<string> = [],

    /**
     *Description of the test
     */
    val description: string = "",

    /**
     *Owner of the test, ex. <Tester name>
     */
    val owner: string = "",

    /**
     *Epic of the test
     */
    val epic: string = "",

    /**
     *Feature of the test
     */
    val feature: string = "",

    /**
     *Story of the test
     */
    val story: string = "",

    /*
    How to take annotation into function

    fun getData(test: Test) {
        print(test.name) //prints test name
    }
     */
                     )
