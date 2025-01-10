package mooscapeTests.secondBlock

import org.example.core.enums.Env
import org.example.core.pages.SC_games.Mooscape
import org.example.core.pages.SC_games.Mooscape.BetBlock
import org.junit.jupiter.api.Test

class SecondBlock_negative : BaseTest() {

    private var mooscape: Mooscape = gamesPage.getMooscape_game(Env.ENV02)
    private var sblock: BetBlock = mooscape.getFirstBetBlock()

    @Test
    fun `first block - enter coef by myself 256`() {
        sblock.enterCoef_SBlock("3")
    }

    @Test
    fun `first block - enter coef by myself 1000`() {
        sblock.enterCoef_SBlock("1000")
    }

    @Test
    fun `first block - enter bet by myself 1`() {
        sblock.enterBet_SBlock("1")
    }

    @Test
    fun `first block - enter bet by myself 10`() {
        sblock.enterBet_SBlock("10")
    }

    @Test
    fun `first block - enter bet by myself 100`() {
        sblock.enterBet_SBlock("100")
    }
}