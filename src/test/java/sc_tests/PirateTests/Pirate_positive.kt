package sc_tests.PirateTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotations.TestCase
import org.example.core.games.sc_games.Pirate
import org.example.core.main_functionalities.ActionController
import org.example.core.main_functionalities.ActionController.wait_For
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag

@Tag("Positive")
class Pirate_positive : BaseTest() {

    private lateinit var pirate: Pirate

    @BeforeEach
    fun init() {
        pirate = currentGame as Pirate
    }

    @TestCase(SeverityLevel.CRITICAL)
    fun `Should enter the game`() {
        pirate.start_game()
        wait_For(100_00)
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should pay on Red`() {
        pirate.payOnRed()
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should pay on Mixed`() {
        pirate.payOnMixed()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should pay on Black`() {
        pirate.payOnBlack()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should pay on All`() {
        pirate.payOnRed()
        pirate.payOnMixed()
        pirate.payOnBlack()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should turn on sound`() {
        pirate.set_sound_on(true)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should turn off sound`() {
        pirate.set_sound_on(false)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should show balance`() {
        pirate.show_balance()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should show game information`() {
        pirate.enter_game_info()
        assertTrue(ActionController.enter_Result())
    }
}
