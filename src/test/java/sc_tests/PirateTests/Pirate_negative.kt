package sc_tests.PirateTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.games.sc_games.Pirate
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag

@Tag("Negative")
class Pirate_negative : BaseTest() {

    @Test(SeverityLevel.MINOR)
    fun `Should not play twice on red`() {
        var pirate: Pirate = game as Pirate
        pirate.payOnRed()
        pirate.payOnRed()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not play twice on diff`() {
        var pirate: Pirate = game as Pirate
        pirate.payOnMixed()
        pirate.payOnMixed()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not play twice on black`() {
        var pirate: Pirate = game as Pirate
        pirate.payOnBlack()
        pirate.payOnBlack()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not minus bet sum to zero`() {
        var pirate: Pirate = game as Pirate
        pirate.change_bet(false, 1)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not minus bet sum to -1`() {
        var pirate: Pirate = game as Pirate
        pirate.change_bet(false, 2)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not plus bet sum over 1`() {
        var pirate: Pirate = game as Pirate
        pirate.change_bet(true, 20)
        assertTrue(ActionController.enter_Result())
    }
}
