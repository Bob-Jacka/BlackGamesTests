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

class FirstBlock_negative: BaseTest {

    private lateinit var mooscape: Mooscape = gamesPage.getMooscape_game(Env.ENV02)
    private lateinit var fblock: BetBlock = mooscape.getFirstBetBlock()

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