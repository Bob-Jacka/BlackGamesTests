package sc_tests.LuckyFishTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotations.TestCase
import org.example.core.games.sc_games.LuckyFish
import org.example.core.main_functionalities.ActionController
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Tag

@Tag("Positive")
class LuckyFish_positive : BaseTest() {

    private lateinit var luckyFish: LuckyFish

    @BeforeEach
    fun init() {
        luckyFish = currentGame as LuckyFish
    }

    @TestCase(SeverityLevel.CRITICAL)
    fun `Should enter the game`() {
        luckyFish.start_game()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should pick 0,1`() {
        luckyFish.get_first_ps()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should pick 0,2`() {
        luckyFish.get_second_ps()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should pick 0,5`() {
        luckyFish.get_third_ps()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should pick 1`() {
        luckyFish.get_fourth_ps()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    @Order(1)
    fun `Should turn on sound`() {
        luckyFish.set_sound_on(true)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    @Order(2)
    fun `Should turn off sound`() {
        luckyFish.set_sound_on(false)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should get in history`() {
        luckyFish.enter_in_history()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Should get in game information`() {
        luckyFish.enter_game_info()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.CRITICAL)
    fun `Should bet`() {
        luckyFish.get_first_block().bet_on_block(1)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase
    fun `Should enable auto bet`() {
        luckyFish.enable_autobet(1)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase
    fun `Should enable auto cash out`() {
        luckyFish.enable_autocashout(1)
        assertTrue(ActionController.enter_Result())
    }
}
