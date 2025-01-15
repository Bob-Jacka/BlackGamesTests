package sc_tests.PirateTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.pages.sc_games.Pirate
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("Negative")
class Pirate_negative : BaseTest() {

    @Autowired
    private lateinit var pirate: Pirate

    @Test(SeverityLevel.MINOR)
    fun `Should not play twice on red`() {
        pirate.payOnRed()
        pirate.payOnRed()
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not play twice on diff`() {
        pirate.payOnMixed()
        pirate.payOnMixed()
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not play twice on black`() {
        pirate.payOnBlack()
        pirate.payOnBlack()
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not minus bet sum to zero`() {
        pirate.change_bet(false, 1)
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not minus bet sum to -1`() {
        pirate.change_bet(false, 2)
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not plus bet sum over 1`() {
        pirate.change_bet(true, 20)
        assertTrue(ActionController.enter_result())
    }
}
