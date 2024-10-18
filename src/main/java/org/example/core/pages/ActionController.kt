package org.example.core.pages

import com.codeborne.selenide.Selenide
import org.awaitility.Awaitility
import org.openqa.selenium.Point
import java.time.Duration

object ActionController {

    /**
     * Performs moving cursor of point position and click on it
     *
     * @param whereToClick represents point with x and y coordinates
     */
    @JvmStatic
    fun clickOn(whereToClick: Point) {
        waitFor(2)
        Selenide.webdriver().driver().actions().moveToLocation(whereToClick.getX(), whereToClick.getY()).click()
        Awaitility.await().atLeast(Duration.ofSeconds(1)).atMost(Duration.ofSeconds(2)).ignoreExceptions()
    }

    /**
     * Метод для ожидания событий
     *
     * @param seconds ожидание скольки секунд
     */
    @JvmStatic
    fun waitFor(seconds: Long = 0) {
        try {
            Thread.sleep(seconds)
        } catch (e: InterruptedException) {
            print(e.stackTrace)
        }
    }

    @JvmStatic
    fun enterByKeyboard(string: CharSequence) {
        Selenide.webdriver().driver().actions().sendKeys(string.toString())
    }
}
