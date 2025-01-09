package mooscapeTests

import com.codeborne.selenide.Selenide
import org.example.core.enums.Env
import org.example.core.pages.GamesPage
import org.example.core.pages.SprutCloud
import org.example.core.pages.games.Mooscape
import org.example.core.pages.games.Mooscape.BetBlock
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MooscapeTests {

    private lateinit var spC: SprutCloud
    private lateinit var gamesPage: GamesPage
    private lateinit var mooscape: Mooscape

    @BeforeEach
    fun startGame() {
        spC = SprutCloud()
        spC.enterUserName()
        gamesPage = spC.loginInto()
        mooscape = gamesPage.getMooscape_game(Env.ENV02)
    }

    @AfterEach
    fun tearDown() {
        Selenide.closeWebDriver()
    }

    @Test
    fun `start the Game`() {
        mooscape.startGame()
    }

    @Test
    fun `open cachier page`() {
        mooscape.open_cachier()
    }

    @Test
    fun `open settings page`() {
        mooscape.open_settings()
    }

    @Test
    fun `open blockchain info page`() {
        mooscape.open_blockchainInfo()
    }

    @Test
    fun `open how to play page`() {
        mooscape.open_how_to_play()
    }

    @Test
    fun `check hint for balance`() {
        mooscape.open_balance()
    }

    @Test
    fun `turn the sound on`() {
        mooscape.setSoundOn()
    }
}
