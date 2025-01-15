package sc_tests.MooscapeTests

import BaseTest
import io.qameta.allure.SeverityLevel
import org.example.core.annotation.Test
import org.example.core.functional.ActionController
import org.example.core.pages.BetBlock
import org.example.core.pages.sc_games.Mooscape
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired

@Tag("negative")
class Mooscape_negative : BaseTest() {

    @Autowired
    private lateinit var mooscape: Mooscape
    private val first_block: BetBlock = mooscape.get_first_block()
    private val second_block: BetBlock = mooscape.get_second_block()

    @Test(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 256`() {
        first_block.enter_coef("3")
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter coefficient by myself 1000`() {
        first_block.enter_coef("1000")
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter bet by myself 1`() {
        first_block.enter_bet("1")
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter bet by myself 10`() {
        first_block.enter_bet("10")
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `First block - enter bet by myself 100`() {
        first_block.enter_bet("100")
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - enter coefficient by myself 256`() {
        second_block.enter_coef("3")
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - enter coefficient by myself 1000`() {
        second_block.enter_coef("1000")
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - enter bet by myself 1`() {
        second_block.enter_bet("1")
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - enter bet by myself 10`() {
        second_block.enter_bet("10")
        assertTrue(ActionController.enter_result())
    }

    @Test(SeverityLevel.MINOR)
    fun `Second block - enter bet by myself 100`() {
        second_block.enter_bet("100")
        assertTrue(ActionController.enter_result())
    }
}