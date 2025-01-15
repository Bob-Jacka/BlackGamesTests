package org.example.core.settings

import org.example.core.functional.string

val passValues = listOf<string>("pass", "Pass", "1")
val failedValues = listOf<string>()
val skippedValues = listOf<string>()

const val everyTest_msg: string =
    "Enter |pass, Pass or 1| for success test, |fail, Fail or 0| for failure test or skip to skip"
const val cursor: string = ">> "