package org.example.core.functional

import com.codeborne.selenide.Selenide
import lombok.Builder
import org.awaitility.Awaitility
import org.example.core.settings.*
import java.time.Duration
import java.util.*
import javax.swing.JFrame
import kotlin.properties.Delegates

object ActionController {

    /**
     * Performs moving cursor of point position and click on it
     *
     * @param whereToClick represents point with x and y coordinates
     */
    @JvmStatic
    fun click_On(whereToClick: ElemPos) {
        wait_For(2)
        Selenide.webdriver().driver().actions().moveToLocation(whereToClick.getX(), whereToClick.getY()).click()
        Awaitility.await().atLeast(Duration.ofSeconds(1)).atMost(Duration.ofSeconds(2)).ignoreExceptions()
    }

    /**
     * Метод для ожидания событий
     *
     * @param seconds ожидание скольки секунд
     */
    @JvmStatic
    fun wait_For(seconds: long = 1) {
        try {
            Thread.sleep(seconds)
        } catch (e: InterruptedException) {
            print(e.stackTrace)
        }
    }

    /**
     * Метод дл ввода символов с клавиатуры в выделенное поле
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
    fun enter_result(): bool {
        println(everyTest_msg)
        print(cursor)
        val entered: string = Scanner(System.`in`).toString()

        if (entered in passValues) {
            println("test passed")
            return true
        }

        if (entered in failedValues) {
            println("test failure")
            return false
        }

        if (entered in skippedValues) {
            println("skipped")
            return true
        }

        return false
    }
}

/**
 * Функционал для выделения искомого элемента рамкой
 */
@Builder(setterPrefix = "setBound_")
class Frame() : JFrame() {

    private var height: int = 200
    private var width: int = 200
    private lateinit var frameName: string
    private var closeMode: int by Delegates.notNull<int>()

    fun Frame_construct(width: int, height: int, frameName: string, closeMode: int) {
        this.closeMode = closeMode
        this.width = width
        this.height = height
        this.frameName = frameName
        initFrame()
    }

    private fun initFrame() {
        setTitle(frameName)
        setSize(width, height)
        setDefaultCloseOperation(closeMode)
        layout = null
        isVisible = true
    }
}
