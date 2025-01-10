package mooscapeTests.secondBlock

import com.codeborne.selenide.Selenide
import org.example.core.Functional.Operator.SprutCloud
import org.example.core.Functional.getFor_secondBlock
import org.example.core.enums.Env
import org.example.core.pages.GamesPage
import org.example.core.pages.SC_games.Mooscape
import org.example.core.pages.SC_games.Mooscape.BetBlock
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class SecondBlock_positive {

    private lateinit var spC: SprutCloud
    private lateinit var gamesPage: GamesPage
    private lateinit var mooscape: Mooscape
    private lateinit var sblock: BetBlock

    @BeforeEach
    fun startGame() {
        spC = SprutCloud()
        spC.enterUserName()
        gamesPage = spC.loginInto()
        mooscape = gamesPage.getMooscape_game(Env.ENV02)
        sblock = mooscape.firstBetBlock
    }

    @AfterEach
    fun tearDown() {
        Selenide.closeWebDriver()
    }

    @Test
    @Tag("positive")
    fun `second block - autobet`() {
        sblock.clickOn(sblock.auto_bet.getFor_secondBlock())
    }

    @Test
    @Tag("positive")
    fun `second block - autocashout`() {
        sblock.clickOn(sblock.auto_cashout.getFor_secondBlock())
    }

    @Test
    @Tag("positive")
    fun `second block - press bet`() {
        sblock.clickOn(sblock.bet_btn.getFor_secondBlock())
    }

    @Test
    @Tag("positive")
    fun `second block - press on pre selects`() {
        sblock.clickOn(sblock.one.getFor_secondBlock())
        sblock.clickOn(sblock.two.getFor_secondBlock())
        sblock.clickOn(sblock.three.getFor_secondBlock())
        sblock.clickOn(sblock.four.getFor_secondBlock())
    }

    @Test
    @Tag("positive")
    fun `second block - change bet`() {
        sblock.changeBet(true, 9)
        sblock.changeBet(false, 9)
    }

    @Test
    @Tag("positive")
    fun `second block - change coef`() {
        sblock.changeCoef(true, 20)
        sblock.changeCoef(false, 20)
    }
}