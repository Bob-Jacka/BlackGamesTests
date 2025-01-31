package org.example.core.main_functionalities

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverRunner
import org.example.core.settings.*
import org.openqa.selenium.By
import java.awt.AWTException
import java.awt.Robot
import java.awt.event.InputEvent
import java.util.*

/**
 * Main object for handling with actions in this framework.
 */
object ActionController {

    /**
     * Экземпляр бота awt для управления мышкой.
     * @see Robot
     * @see java.awt
     */
    private val roboMouse: Robot = Robot()
    private lateinit var frame: Frame

    /**
     * Performs moving cursor to point position and click on it.
     * Uses python code to move and click on cursor. May be heavy in runtime execution.
     * @param whereToClick Represents point with x and y coordinates.
     * @since 30.01.2025
     * @throws AWTException if incorrect arguments were given to under hood robot object.
     */
    @JvmStatic
    fun click_On(whereToClick: ElemPos) {
        val xCord: int = whereToClick.x
        val yCord: int = whereToClick.y
        try {
            frame = Frame.SingletonStatic.Singleton(xCord, yCord).build()
            roboMouse.mouseMove(xCord, yCord)
            roboMouse.mousePress(InputEvent.BUTTON1_DOWN_MASK)
            roboMouse.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
        } catch (e: AWTException) {
            e.message.print()
            e.stackTrace.printAll()
        }
    }

    /**
     * Performs moving cursor to point position and click on it.
     * Using WebdriverRunner for mouse action.
     * @see WebDriverRunner
     * @param x represents x coordinate.
     * @param y represents y coordinate.
     */
    @JvmStatic
    fun click_On(x: int, y: int) {
        wait_For(0.5)
        WebDriverRunner.driver().actions().moveToLocation(x, y).click().build().perform()
    }

    /**
     * Метод для ожидания событий с использованием остановки потока.
     * @see Thread.sleep
     * @throws InterruptedException
     * @param seconds ожидание количества секунд
     */
    @JvmStatic
    fun wait_For(seconds: long = 1) {
        try {
            Thread.sleep(seconds * 1000)
        } catch (e: InterruptedException) {
            e.message.print()
            e.stackTrace.printAll()
        }
    }

    /**
     * Метод для ожидания событий с использованием остановки потока.
     * @see Thread.sleep
     * @throws InterruptedException
     * @param seconds ожидание скольки секунд, в виде дробного числа.
     */
    @JvmStatic
    fun wait_For(seconds: double = 1.0) {
        try {
            Thread.sleep((seconds * 1000.0).toLong())
        } catch (e: InterruptedException) {
            e.message.print()
            e.stackTrace.printAll()
        }
    }

    /**
     * Метод для ввода символов с клавиатуры в выделенное поле.
     * @throws IllegalArgumentException если введенный символ == null
     */
    @JvmStatic
    fun enter_By_Keyboard(where_to_enter: ElemPos, enteredChars: string) {
        wait_For(1)
        click_On(where_to_enter)
        Selenide.webdriver().driver().actions().sendKeys(enteredChars.toString())
    }

    /**
     * Метод для ввода результатов тестирования.
     * Проверяется вхождение введенного значения в список (находится в настройках)
     * @return Булево значение, отображающее результат.
     */
    @Deprecated("24.01.2025")
    @JvmStatic
    fun enter_Result(): bool {
        println(everyTest_msg)
        var entered: string? = null
        print(cursor)
        entered = Scanner(System.`in`).nextLine()
        var boolVal: bool = false

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
        return boolVal
    }

    /**
     * Just wrapper function for Selenide $ function.
     * @return Selenide element, located via xpath
     */
    @JvmStatic
    fun get_element(xpathSelector: string): SelenideElement {
        return Selenide.`$`(By.xpath(xpathSelector))
    }

    /**
     * Just wrapper function for Selenide '$$' function.
     * @return Collection of Selenide elements, located via xpath.
     */
    @JvmStatic
    fun get_elements(xpathSelector: string): ElementsCollection {
        return Selenide.`$$`(By.xpath(xpathSelector))
    }
}
