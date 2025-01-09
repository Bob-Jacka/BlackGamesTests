package mooscapeTests.secondBlock

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

class SecondBlock_negative {

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
        sblock = mooscape.getFirstBetBlock()
    }

    @AfterEach
    fun tearDown() {
        Selenide.closeWebDriver()
    }

    @Test
    @Tag("negative")
    fun `first block - enter coef by myself 256`() {
        sblock.enterCoef_SBlock("3")
    }

    @Test
    @Tag("negative")
    fun `first block - enter coef by myself 1000`() {
        sblock.enterCoef_SBlock("1000")
    }

    @Test
    @Tag("positive")
    fun `first block - enter bet by myself 1`() {
        sblock.enterBet_SBlock("1")
    }

    @Test
    @Tag("negative")
    fun `first block - enter bet by myself 10`() {
        sblock.enterBet_SBlock("10")
    }

    @Test
    @Tag("negative")
    fun `first block - enter bet by myself 100`() {
        sblock.enterBet_SBlock("100")
    }
}