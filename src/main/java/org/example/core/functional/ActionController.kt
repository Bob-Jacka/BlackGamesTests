package org.example.core.functional

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.example.core.settings.*
import org.openqa.selenium.By
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import java.util.concurrent.TimeUnit

object ActionController {

    /**
     * Performs moving cursor of point position and click on it
     *
     * @param whereToClick represents point with x and y coordinates
     */
    @JvmStatic
    fun click_On(whereToClick: ElemPos) {
        Selenide.webdriver().driver().actions().moveToLocation(whereToClick.getX(), whereToClick.getY()).click()
    }

    /**
     * Метод для ожидания событий
     *
     * @param seconds ожидание скольки секунд
     */
    @JvmStatic
    fun wait_For(seconds: long = 1) {
        try {
            Thread.sleep(seconds * 1000)
        } catch (e: InterruptedException) {
            print(e.stackTrace)
        }
    }

    /**
     * Метод для ввода символов с клавиатуры в выделенное поле
     */
    @JvmStatic
    fun enter_By_Keyboard(where_to_enter: ElemPos, enteredChars: string) {
        click_On(where_to_enter)
        Selenide.webdriver().driver().actions().sendKeys(enteredChars.toString())
    }

    /**
     * Native function
     */
//    external fun openTerminal(): Boolean

    /**
     * Метод для ввода результатов тестирования.
     * Проверяется вхождение введенного значения в список (находится в настройках)
     * @return Булево значение, отображающее результат
     */
    @Deprecated("24.01.2025")
    @JvmStatic
    fun enter_Result(): bool {
        println(everyTest_msg)
        var entered: string? = null
        entered = Scanner(System.`in`).toString()
        var boolVal: bool = false
        print(cursor)

        if (entered in passValues) {
            println("Test passed")
            boolVal = true
        }

        if (entered in failedValues) {
            println("Test failure")
            boolVal = false
        }

        if (entered in skipValues) {
            println("Test skipped")
            boolVal = true
        }
//        openTerminal()
        return boolVal
    }

    /**
     * Just wrapper function for Selenide $ function
     * @return Selenide element, located via xpath
     */
    @JvmStatic
    fun get_element(xpathSelector: string): SelenideElement {
        return Selenide.`$`(By.xpath(xpathSelector))
    }

    /**
     * Just wrapper function for Selenide '$$' function
     * @return Collection of Selenide elements, located via xpath
     */
    @JvmStatic
    fun get_elements(xpathSelector: string): ElementsCollection {
        return Selenide.`$$`(By.xpath(xpathSelector))
    }

    /**
     * Static method to open terminal window.
     * Not addicted to system type
     * @return String from terminal
     */
    @Deprecated("На windows не работает")
    @JvmStatic
    fun get_terminal(): string? {
        val test: string? = runCommand(null)
        return test ?: "NULL"
    }

    @Deprecated("На windows не работает")
    @JvmStatic
    @Throws(Exception::class)
    fun runCommand(command: string?): string {
        val isWindows = System.getProperty("os.name").lowercase(Locale.getDefault()).startsWith("windows")
        println("Command: $command")
        val commands: Array<string?>?

        if (isWindows) {
            commands = arrayOf<string?>("start C:\\Windows\\system32\\cmd.exe")
        } else {
            commands = arrayOf<string?>("sh", "-c")
        }

        val process = Runtime.getRuntime().exec(commands, null)

        val outputStream = process.outputStream
        val inputStream = process.inputStream
        val errorStream = process.errorStream

        val returned = outputStream.toString()
        printStream(inputStream)
        printStream(errorStream)

        val isFinished = process.waitFor(30, TimeUnit.SECONDS)
        outputStream.flush()
        outputStream.close()

        if (!isFinished) {
            process.destroyForcibly()
        }
        return returned
    }

    @Deprecated("На windows не работает")
    @JvmStatic
    @Throws(IOException::class)
    private fun printStream(inputStream: InputStream) {
        BufferedReader(InputStreamReader(inputStream)).use { bufferedReader ->
            var line: String?
            while ((bufferedReader.readLine().also { line = it }) != null) {
                println(line)
            }
        }
    }
}
