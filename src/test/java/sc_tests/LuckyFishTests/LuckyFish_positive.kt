package sc_tests.LuckyFishTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.games.sc_games.LuckyFish
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Tag

@Tag("Positive")
class LuckyFish_positive : BaseTest() {

    @Test(SeverityLevel.MINOR)
    fun `Should pick 0,1`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.get_first_ps()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should pick 0,2`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.get_second_ps()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should pick 0,5`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.get_third_ps()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should pick 1`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.get_fourth_ps()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    @Order(1)
    fun `Should turn on sound`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.set_sound_on(true)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    @Order(2)
    fun `Should turn off sound`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.set_sound_on(false)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should get in history`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.get_in_history()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should get in game information`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.show_gameinfo()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.CRITICAL)
    fun `Should bet`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.get_first_block().bet_on_block(1)
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should enable auto bet`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.enable_autobet(1)
        assertTrue(ActionController.enter_Result())
    }

    @Test
    fun `Should enable auto cash out`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.enable_autocashout(1)
        assertTrue(ActionController.enter_Result())
    }
}
