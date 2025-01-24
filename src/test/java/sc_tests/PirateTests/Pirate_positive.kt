package sc_tests.PirateTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.games.sc_games.Pirate
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag

@Tag("Positive")
class Pirate_positive : BaseTest() {

    private lateinit var pirate: Pirate
    
    @Test(SeverityLevel.MINOR)
    fun `Should pay on Red`() {
        pirate = game as Pirate
        println("Test invoked")
        pirate.payOnRed()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should pay on Mixed`() {
        pirate = game as Pirate
        pirate.payOnMixed()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should pay on Black`() {
        pirate = game as Pirate
        pirate.payOnBlack()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should pay on All`() {
        pirate = game as Pirate
        pirate.payOnRed()
        pirate.payOnMixed()
        pirate.payOnBlack()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should turn on sound`() {
        pirate = game as Pirate
        pirate.set_sound_on(true)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should turn off sound`() {
        pirate = game as Pirate
        pirate.set_sound_on(false)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should show balance`() {
        pirate = game as Pirate
        pirate.show_balance()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should show game information`() {
        pirate = game as Pirate
        pirate.show_game_info()
        assertTrue(ActionController.enter_Result())
    }
}
