package sc_tests.ColorRaceTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotations.TestCase
import org.example.core.games.sc_games.ColorRace
import org.example.core.main_functionalities.ActionController
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag

@Tag("Positive")
class ColorRace_positive : BaseTest() {

    private lateinit var colorRace: ColorRace

    @BeforeEach
    fun init() {
        colorRace = currentGame as ColorRace
    }

    @TestCase(SeverityLevel.CRITICAL)
    fun `Should enter the game`() {
        colorRace.start_game()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.CRITICAL)
    fun `Should pay on green`() {
        colorRace.payOn_Green()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.CRITICAL)
    fun `Should pay on blue`() {
        colorRace.payOn_Blue()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.CRITICAL)
    fun `Should pay on purple`() {
        colorRace.payOn_Purple()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.CRITICAL)
    fun `Should pay on red`() {
        colorRace.payOn_Red()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.CRITICAL)
    fun `Should pay on All`() {
        colorRace.payOn_All()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase
    fun `Should turn on music`() {
        colorRace.set_sound_on(true)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase
    fun `Should turn off music`() {
        colorRace.set_sound_on(false)
        assertTrue(ActionController.enter_Result())
    }
}
