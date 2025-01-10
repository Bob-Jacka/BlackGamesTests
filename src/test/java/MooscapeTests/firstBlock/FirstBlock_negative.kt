package MooscapeTests.firstBlock

import org.example.core.enums.Env
import org.example.core.pages.SC_games.Mooscape
import org.example.core.pages.SC_games.Mooscape.BetBlock
import org.junit.jupiter.api.Test

class FirstBlock_negative : BaseTest() {

    private var mooscape: Mooscape = super.gamesPage.getMooscape_game(Env.ENV02)
    private var fblock: BetBlock = mooscape.getFirstBetBlock()

    @Test
    fun `first block - enter coef by myself 256`() {
        fblock.enterCoef_FBlock("3")
    }

    @Test
    fun `first block - enter coef by myself 1000`() {
        fblock.enterCoef_FBlock("1000")
    }

    @Test
    fun `first block - enter bet by myself 1`() {
        fblock.enterBet_FBlock("1")
    }

    @Test
    fun `first block - enter bet by myself 10`() {
        fblock.enterBet_FBlock("10")
    }

    @Test
    fun `first block - enter bet by myself 100`() {
        fblock.enterBet_FBlock("100")
    }
}