package sc_tests.MooscapeTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.games.BetBlock
import org.example.core.games.sc_games.Mooscape
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag

@Tag("negative")
class Mooscape_negative : BaseTest() {

    @Test(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 256`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_coef("3")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 1000`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_coef("1000")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter bet by myself 1`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_bet("1")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter bet by myself 10`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_bet("10")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter bet by myself 100`() {
        var mooscape: Mooscape = game as Mooscape
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_bet("100")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - enter coefficient by myself 256`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enter_coef("3")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - enter coefficient by myself 1000`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enter_coef("1000")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - enter bet by myself 1`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enter_bet("1")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - enter bet by myself 10`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enter_bet("10")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - enter bet by myself 100`() {
        var mooscape: Mooscape = game as Mooscape
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enter_bet("100")
        assertTrue(ActionController.enter_Result())
    }
}