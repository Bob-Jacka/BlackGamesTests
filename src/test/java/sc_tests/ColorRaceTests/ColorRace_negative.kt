package sc_tests.ColorRaceTests

import BaseTest
import org.example.core.annotations.TestCase
import org.example.core.games.sc_games.ColorRace
import org.example.core.main_functionalities.ActionController
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag

@Tag("Negative")
class ColorRace_negative : BaseTest() {

    private lateinit var colorRace: ColorRace

    @BeforeEach
    fun init() {
        colorRace = currentGame as ColorRace
    }

    @TestCase
    fun `Should not pay twice on red`() {
        colorRace.payOn_Red()
        colorRace.payOn_Red()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase
    fun `Should not pay twice on green`() {
        colorRace.payOn_Green()
        colorRace.payOn_Green()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase
    fun `Should not pay twice on blue`() {
        colorRace.payOn_Blue()
        colorRace.payOn_Blue()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase
    fun `Should not pay twice on purple`() {
        colorRace.payOn_Purple()
        colorRace.payOn_Purple()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase
    fun `Should not pay twice on all`() {
        colorRace.payOn_All()
        colorRace.payOn_All()
        assertTrue(ActionController.enter_Result())
    }
}
