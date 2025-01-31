package sc_tests.MooscapeTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotations.TestCase
import org.example.core.games.BetBlock
import org.example.core.games.sc_games.Mooscape
import org.example.core.main_functionalities.ActionController
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag

@Tag("positive")
class Mooscape_positive : BaseTest() {

    private lateinit var mooscape: Mooscape

    @BeforeEach
    fun init() {
        mooscape = currentGame as Mooscape
    }

    @TestCase(SeverityLevel.CRITICAL)
    fun `Should enter the game`() {
        mooscape.start_game()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - auto bet`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enable_autobet(1)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - auto cash out`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enable_autocashout(1)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - press bet`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.bet_on_block(1)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - press on pre selects`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.get_first_ps()
        first_block.get_second_ps()
        first_block.get_third_ps()
        first_block.get_fourth_ps()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - change bet`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.change_bet(1, true, 9)
        first_block.change_bet(1, false, 9)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - change coefficient`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.change_coef(1, true, 20)
        first_block.change_coef(1, false, 20)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 1,1`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_coef("1.1")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 20`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_coef("20")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - auto bet`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enable_autobet(2)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - auto cash out`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enable_autocashout(2)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - press bet`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.bet_on_block(2)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - press on pre selects`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.get_first_ps()
        second_block.get_second_ps()
        second_block.get_third_ps()
        second_block.get_fourth_ps()
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - change bet`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.change_bet(2, true, 9)
        second_block.change_bet(2, false, 9)
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - change coef`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.change_coef(2, true, 20)
        second_block.change_coef(2, false, 20)
        assertTrue(ActionController.enter_Result())
    }
}
