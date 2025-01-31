package sc_tests.LuckyFishTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotations.TestCase
import org.example.core.games.sc_games.LuckyFish
import org.example.core.main_functionalities.ActionController
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag

@Tag("Negative")
class LuckyFish_negative : BaseTest() {

    private lateinit var luckyFish: LuckyFish

    @BeforeEach
    fun init() {
        luckyFish = currentGame as LuckyFish
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should not minus bet sum to zero`() {
        luckyFish.change_bet(false, 1)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should not minus bet sum to -1`() {
        luckyFish.change_bet(false, 2)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should not minus bet sum to -100`() {
        luckyFish.change_bet(false, 102)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should not plus bet sum over 10`() {
        luckyFish.change_bet(true, 20)
        assertTrue(ActionController.enter_Result())
    }
}
