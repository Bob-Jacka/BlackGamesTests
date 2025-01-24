package sc_tests.MooscapeTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.games.BetBlock
import org.example.core.games.sc_games.Mooscape
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag

@Tag("positive")
class Mooscape_positive : BaseTest() {

    @Test(SeverityLevel.MINOR)
    fun `First block - auto bet`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enable_autobet(1)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - auto cash out`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enable_autocashout(1)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - press bet`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.bet_on_block(1)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - press on pre selects`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.get_first_ps()
        first_block.get_second_ps()
        first_block.get_third_ps()
        first_block.get_fourth_ps()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - change bet`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.change_bet(1, true, 9)
        first_block.change_bet(1, false, 9)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - change coefficient`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.change_coef(1, true, 20)
        first_block.change_coef(1, false, 20)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 1,1`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_coef("1.1")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 20`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_coef("20")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - auto bet`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enable_autobet(2)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - auto cash out`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enable_autocashout(2)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - press bet`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.bet_on_block(2)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - press on pre selects`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.get_first_ps()
        second_block.get_second_ps()
        second_block.get_third_ps()
        second_block.get_fourth_ps()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - change bet`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.change_bet(2, true, 9)
        second_block.change_bet(2, false, 9)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - change coef`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.change_coef(2, true, 20)
        second_block.change_coef(2, false, 20)
        assertTrue(ActionController.enter_Result())
    }
}
