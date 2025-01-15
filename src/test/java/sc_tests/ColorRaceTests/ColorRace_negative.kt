package sc_tests.ColorRaceTests

import BaseTest
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.pages.sc_games.ColorRace
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("Negative")
class ColorRace_negative : BaseTest() {

    @Autowired
    private lateinit var colorRace: ColorRace

    @Test
    fun `Should not pay twice on red`() {
        colorRace.payOn_Red()
        colorRace.payOn_Red()
        assertTrue(ActionController.enter_result())
    }

    @Test
    fun `Should not pay twice on green`() {
        colorRace.payOn_Green()
        colorRace.payOn_Green()
        assertTrue(ActionController.enter_result())
    }

    @Test
    fun `Should not pay twice on blue`() {
        colorRace.payOn_Blue()
        colorRace.payOn_Blue()
        assertTrue(ActionController.enter_result())
    }

    @Test
    fun `Should not pay twice on purple`() {
        colorRace.payOn_Purple()
        colorRace.payOn_Purple()
        assertTrue(ActionController.enter_result())
    }

    @Test
    fun `Should not pay twice on all`() {
        colorRace.payOn_All()
        colorRace.payOn_All()
        assertTrue(ActionController.enter_result())
    }
}
