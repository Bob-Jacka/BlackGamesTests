package sc_tests.PirateTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotations.TestCase
import org.example.core.games.sc_games.Pirate
import org.example.core.main_functionalities.ActionController
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag

@Tag("Negative")
class Pirate_negative : BaseTest() {

    private lateinit var pirate: Pirate

    @BeforeEach
    fun init() {
        pirate = currentGame as Pirate
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should not play twice on red`() {
        pirate = currentGame as Pirate
        pirate.payOnRed()
        pirate.payOnRed()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should not play twice on diff`() {
        pirate = currentGame as Pirate
        pirate.payOnMixed()
        pirate.payOnMixed()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should not play twice on black`() {
        pirate = currentGame as Pirate
        pirate.payOnBlack()
        pirate.payOnBlack()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should not minus bet sum to zero`() {
        pirate = currentGame as Pirate
        pirate.change_bet(false, 1)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should not minus bet sum to -1`() {
        pirate = currentGame as Pirate
        pirate.change_bet(false, 2)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should not plus bet sum over 1`() {
        pirate = currentGame as Pirate
        pirate.change_bet(true, 20)
        assertTrue(ActionController.enter_Result())
    }
}
