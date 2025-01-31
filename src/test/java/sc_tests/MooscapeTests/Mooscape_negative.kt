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

@Tag("negative")
class Mooscape_negative : BaseTest() {

    private lateinit var mooscape: Mooscape

    @BeforeEach
    fun init() {
        mooscape = currentGame as Mooscape
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 256`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_coef("3")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 1000`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_coef("1000")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - enter bet by myself 1`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_bet("1")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - enter bet by myself 10`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_bet("10")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `First block - enter bet by myself 100`() {
        val first_block: BetBlock = mooscape.get_first_block()
        first_block.enter_bet("100")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - enter coefficient by myself 256`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enter_coef("3")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - enter coefficient by myself 1000`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enter_coef("1000")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - enter bet by myself 1`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enter_bet("1")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - enter bet by myself 10`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enter_bet("10")
        assertTrue(ActionController.enter_Result())
    }

    @TestCase(SeverityLevel.MINOR)
    fun `Second block - enter bet by myself 100`() {
        val second_block: BetBlock = mooscape.get_second_block()
        second_block.enter_bet("100")
        assertTrue(ActionController.enter_Result())
    }
}