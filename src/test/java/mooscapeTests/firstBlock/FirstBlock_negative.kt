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

class FirstBlock_negative {

    private lateinit var spC: SprutCloud
    private lateinit var gamesPage: GamesPage
    private lateinit var mooscape: Mooscape
    private lateinit var fblock: BetBlock

    @BeforeEach
    fun startGame() {
        spC = SprutCloud()
        spC.enterUserName()
        gamesPage = spC.loginInto()
        mooscape = gamesPage.getMooscape_game(Env.ENV02)
        fblock = mooscape.getFirstBetBlock()
    }

    @AfterEach
    fun tearDown() {
        Selenide.closeWebDriver()
    }

    @Test
    @Tag("negative")
    fun `first block - enter coef by myself 256`() {
        fblock.enterCoef_FBlock("3")
    }

    @Test
    @Tag("negative")
    fun `first block - enter coef by myself 1000`() {
        fblock.enterCoef_FBlock("1000")
    }

    @Test
    @Tag("positive")
    fun `first block - enter bet by myself 1`() {
        fblock.enterBet_FBlock("1")
    }

    @Test
    @Tag("negative")
    fun `first block - enter bet by myself 10`() {
        fblock.enterBet_FBlock("10")
    }

    @Test
    @Tag("negative")
    fun `first block - enter bet by myself 100`() {
        fblock.enterBet_FBlock("100")
    }
}