package MooscapeTests

import com.codeborne.selenide.Browsers
import org.example.core.Functional.GamesPageSprut
import org.example.core.enums.Env
import org.example.core.enums.Stages
import org.example.core.pages.SC_games.Mooscape
import org.example.core.pages.SC_games.TestAnnotation

@Tag("positive")
class Mooscape_positive : BaseTest(Stages.STABLE, Browsers.CHROME) {

    private val mooscape: Mooscape = (gameList as GamesPageSprut).getMooscape_game(Env.ENV03) as Mooscape
    private val fblock: BetBlock = mooscape.getFirstBetBlock()
    private val sblock: BetBlock = mooscape.getFirstBetBlock()

    @Test
    fun `first block - autobet`() {
        fblock.clickOn(fblock.auto_bet)
    }

    @Test
    fun `first block - autocashout`() {
        fblock.clickOn(fblock.auto_cashout)
    }

    @Test
    fun `first block - press bet`() {
        fblock.clickOn(fblock.bet_btn)
    }

    @Test
    fun `first block - press on pre selects`() {
        fblock.clickOn(fblock.one)
        fblock.clickOn(fblock.two)
        fblock.clickOn(fblock.three)
        fblock.clickOn(fblock.four)
    }

    @Test
    fun `first block - change bet`() {
        fblock.changeBet(true, 9)
        fblock.changeBet(false, 9)
    }

    @Test
    fun `first block - change coef`() {
        fblock.changeCoef(true, 20)
        fblock.changeCoef(false, 20)
    }

    @Test
    fun `first block - enter coef by myself 1,1`() {
        fblock.enterCoef_FBlock("1.1")
    }

    @Test
    fun `first block - enter coef by myself 20`() {
        fblock.enterCoef_FBlock("20")
    }

    @Test
    fun `second block - autobet`() {
        sblock.clickOn(sblock.auto_bet.getFor_secondBlock())
    }

    @Test
    fun `second block - autocashout`() {
        sblock.clickOn(sblock.auto_cashout.getFor_secondBlock())
    }

    @Test
    fun `second block - press bet`() {
        sblock.clickOn(sblock.bet_btn.getFor_secondBlock())
    }

    @Test
    fun `second block - press on pre selects`() {
        sblock.clickOn(sblock.one.getFor_secondBlock())
        sblock.clickOn(sblock.two.getFor_secondBlock())
        sblock.clickOn(sblock.three.getFor_secondBlock())
        sblock.clickOn(sblock.four.getFor_secondBlock())
    }

    @Test
    fun `second block - change bet`() {
        sblock.changeBet(true, 9)
        sblock.changeBet(false, 9)
    }

    @Test
    fun `second block - change coef`() {
        sblock.changeCoef(true, 20)
        sblock.changeCoef(false, 20)
    }
}
