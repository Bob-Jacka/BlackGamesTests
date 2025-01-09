package mooscapeTests.firstBlock

import com.codeborne.selenide.Selenide
import org.example.core.enums.Env
import org.example.core.pages.GamesPage
import org.example.core.pages.SprutCloud
import org.example.core.pages.games.Mooscape
import org.example.core.pages.games.Mooscape.BetBlock
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class FirstBlock_positive: BaseTest {

    private lateinit var mooscape: Mooscape = gamesPage.getMooscape_game(Env.ENV02)
    private lateinit var fblock: BetBlock = mooscape.firstBetBlock

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
}