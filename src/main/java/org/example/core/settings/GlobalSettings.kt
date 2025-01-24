package org.example.core.settings

import org.example.core.functional.string

//Setting
val passValues = listOf<string>("pass", "Pass", "1")
val failedValues = listOf<string>("fail", "Fail", "0")
val skipValues = listOf<string>("skip", "Skipped", "skipped")

var everyTest_msg: string =
    "Enter: " + passValues.joinToString() + " for success test; " +
            failedValues.joinToString() + " for failure test; or " +
            skipValues.joinToString() + " to skip"
const val cursor: string = ">> "