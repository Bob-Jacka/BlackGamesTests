package sc_tests.MooscapeTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.games.BetBlock
import org.example.core.games.sc_games.Mooscape
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("positive")
class Mooscape_positive : BaseTest() {

    @Autowired
    private lateinit var mooscape: Mooscape
    private val first_block: BetBlock = mooscape.get_first_block()
    private val second_block: BetBlock = mooscape.get_second_block()

    @Test(SeverityLevel.MINOR)
    fun `First block - auto bet`() {
        first_block.enable_autobet(1)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - auto cash out`() {
        first_block.enable_autocashout(1)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - press bet`() {
        first_block.bet_on_block(1)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - press on pre selects`() {
        first_block.get_first_ps()
        first_block.get_second_ps()
        first_block.get_third_ps()
        first_block.get_fourth_ps()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - change bet`() {
        first_block.change_bet(1, true, 9)
        first_block.change_bet(1, false, 9)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - change coefficient`() {
        first_block.change_coef(1, true, 20)
        first_block.change_coef(1, false, 20)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 1,1`() {
        first_block.enter_coef("1.1")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 20`() {
        first_block.enter_coef("20")
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - auto bet`() {
        second_block.enable_autobet(2)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - auto cash out`() {
        second_block.enable_autocashout(2)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - press bet`() {
        second_block.bet_on_block(2)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - press on pre selects`() {
        second_block.get_first_ps()
        second_block.get_second_ps()
        second_block.get_third_ps()
        second_block.get_fourth_ps()
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - change bet`() {
        second_block.change_bet(2, true, 9)
        second_block.change_bet(2, false, 9)
        assertTrue(ActionController.enter_Result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - change coef`() {
        second_block.change_coef(2, true, 20)
        second_block.change_coef(2, false, 20)
        assertTrue(ActionController.enter_Result())
    }
}
