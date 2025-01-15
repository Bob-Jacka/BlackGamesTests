package sc_tests.LuckyFishTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.pages.sc_games.LuckyFish
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("Negative")
class LuckyFish_negative : BaseTest() {

    @Autowired
    private lateinit var luckyFish: LuckyFish

    @Test(SeverityLevel.MINOR)
    fun `Should not minus bet sum to zero`() {
        luckyFish.change_bet(false, 1)
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not minus bet sum to -1`() {
        luckyFish.change_bet(false, 2)
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not minus bet sum to -100`() {
        luckyFish.change_bet(false, 102)
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Should not plus bet sum over 10`() {
        luckyFish.change_bet(true, 20)
        assertTrue(ActionController.enter_result())
    }
}
