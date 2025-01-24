package sc_tests.ColorRaceTests

import BaseTest
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.games.sc_games.ColorRace
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag

@Tag("Negative")
class ColorRace_negative : BaseTest() {

    @Test
    fun `Should not pay twice on red`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.payOn_Red()
        colorRace.payOn_Red()
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should not pay twice on green`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.payOn_Green()
        colorRace.payOn_Green()
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should not pay twice on blue`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.payOn_Blue()
        colorRace.payOn_Blue()
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should not pay twice on purple`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.payOn_Purple()
        colorRace.payOn_Purple()
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should not pay twice on all`() {
        var colorRace: ColorRace = game as ColorRace
        colorRace.payOn_All()
        colorRace.payOn_All()
        assertTrue(ActionController.enter_Result())
    }
}
