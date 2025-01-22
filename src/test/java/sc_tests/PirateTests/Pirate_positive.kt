package sc_tests.PirateTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.functional.bool
import org.example.core.games.sc_games.Pirate
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("Positive")
class Pirate_positive : BaseTest() {

    @Autowired
    private var pirate: Pirate = game as Pirate

    @Test(SeverityLevel.MINOR)
    fun `Should pay on Red`() {
        pirate.payOnRed()
        val res: bool = ActionController.enter_Result()
        assertTrue(res)
    }

    @Test(SeverityLevel.MINOR)
    fun `Should pay on Mixed`() {
        pirate.payOnMixed()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should pay on Black`() {
        pirate.payOnBlack()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should pay on All`() {
        pirate.payOnRed()
        pirate.payOnMixed()
        pirate.payOnBlack()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should turn on sound`() {
        pirate.set_sound_on(true)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should turn off sound`() {
        pirate.set_sound_on(false)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should show balance`() {
        pirate.show_balance()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should show game information`() {
        pirate.show_game_info()
        assertTrue(ActionController.enter_Result())
    }
}
