package org.example.core.functional

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.example.core.settings.*
import org.openqa.selenium.By
import java.util.*

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
     * Метод для ввода результатов тестирования.
     * Проверяется вхождение введенного значения в список (находится в настройках)
     */
    @JvmStatic
    fun enter_Result(): bool {
        println(everyTest_msg)
        print(cursor)
        val entered: string = Scanner(System.`in`).toString()

        if (entered in passValues) {
            println("Test passed")
            return true
        }

        if (entered in failedValues) {
            println("Test failure")
            return false
        }

        if (entered in skipValues) {
            println("Test skipped")
            return true
        }
        return false
    }

    /**
     * Just wrapper function for Selenide $ function
     */
    @JvmStatic
    fun get_element(xpathSelector: string): SelenideElement {
        return Selenide.`$`(By.xpath(xpathSelector))
    }

    /**
     * Just wrapper function for Selenide '$$' function
     */
    @JvmStatic
    fun get_elements(xpathSelector: string): ElementsCollection {
        return Selenide.`$$`(By.xpath(xpathSelector))
    }
}
