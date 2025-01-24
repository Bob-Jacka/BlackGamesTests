package sc_tests.LuckyFishTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.games.sc_games.LuckyFish
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag

@Tag("Negative")
class LuckyFish_negative : BaseTest() {

    @Test(SeverityLevel.MINOR)
    fun `Should not minus bet sum to zero`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.change_bet(false, 1)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not minus bet sum to -1`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.change_bet(false, 2)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not minus bet sum to -100`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.change_bet(false, 102)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not plus bet sum over 10`() {
        var luckyFish: LuckyFish = game as LuckyFish
        luckyFish.change_bet(true, 20)
        assertTrue(ActionController.enter_Result())
    }
}
