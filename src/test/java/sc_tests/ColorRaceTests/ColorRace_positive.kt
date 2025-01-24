package sc_tests.ColorRaceTests

import BaseTest
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.games.sc_games.ColorRace
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag

@Tag("Positive")
class ColorRace_positive : BaseTest() {

    @Test
    fun `Should pay on green`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.payOn_Green()
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should pay on blue`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.payOn_Blue()
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should pay on purple`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.payOn_Purple()
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should pay on red`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.payOn_Red()
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should pay on All`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.payOn_All()
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should turn on music`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.set_sound_on(true)
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should turn off music`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.set_sound_on(false)
        assertTrue(ActionController.enter_Result())
    }
}
