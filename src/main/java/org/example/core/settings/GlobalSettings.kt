package org.example.core.settings

import org.example.core.main_functionalities.bool
import org.example.core.main_functionalities.string
import org.springframework.beans.factory.annotation.Value

/*
You can edit settings by changing lists below.
 */

//Setting.

/**
 * Значение данной переменной показывает, будет ли использоваться определение результата теста нейронной сетью или ручное.
 * False - ручной режим определения результата теста.
 * True - автоматизированное определение результата теста.
 * @see application.properties - файл в директории resources.
 */
@Value("\${app.is_neuro_driven}")
var is_neuro_driven: bool = false

val passValues = listOf<string>("pass", "Pass", "1")
val failedValues = listOf<string>("fail", "Fail", "0")
val skipValues = listOf<string>("skip", "Skipped", "skipped")

var everyTest_msg: string =
    "Enter: " + passValues.joinToString() + " for success test; " +
            failedValues.joinToString() + " for failure test; or " +
            skipValues.joinToString() + " to skip"

/**
 * Cursor string before user input.
 */
const val cursor: string = ">> "