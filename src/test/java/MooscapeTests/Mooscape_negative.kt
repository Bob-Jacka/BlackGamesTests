package MooscapeTests

import com.codeborne.selenide.Browsers
import org.example.core.Functional.GamesPageSprut
import org.example.core.enums.Env
import org.example.core.enums.Stages
import org.example.core.pages.SC_games.Mooscape
import org.example.core.pages.SC_games.TestAnnotation

@Tag("negative")
class Mooscape_negative : BaseTest(Stages.STABLE, Browsers.CHROME) {

    private val mooscape: Mooscape = (gameList as GamesPageSprut).getMooscape_game(Env.ENV03) as Mooscape
    private val fblock: BetBlock = mooscape.getFirstBetBlock()
    private val sblock: BetBlock = mooscape.getFirstBetBlock()

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