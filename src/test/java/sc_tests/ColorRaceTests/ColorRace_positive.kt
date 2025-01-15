package sc_tests.ColorRaceTests

import BaseTest
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.pages.sc_games.ColorRace
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("Positive")
class ColorRace_positive : BaseTest() {

    @Autowired
    private lateinit var colorRace: ColorRace

    @Test
    fun `Should pay on green`() {
        colorRace.payOn_Green()
        assertTrue(ActionController.enter_result())
    }

    @Test
    fun `Should pay on blue`() {
        colorRace.payOn_Blue()
        assertTrue(ActionController.enter_result())
    }

    @Test
    fun `Should pay on purple`() {
        colorRace.payOn_Purple()
        assertTrue(ActionController.enter_result())
    }

    @Test
    fun `Should pay on red`() {
        colorRace.payOn_Red()
        assertTrue(ActionController.enter_result())
    }

    @Test
    fun `Should pay on All`() {
        colorRace.payOn_All()
        assertTrue(ActionController.enter_result())
    }

    @Test
    fun `Should turn on music`() {
        colorRace.set_sound_on(true)
        assertTrue(ActionController.enter_result())
    }

    @Test
    fun `Should turn off music`() {
        colorRace.set_sound_on(false)
        assertTrue(ActionController.enter_result())
    }
}
