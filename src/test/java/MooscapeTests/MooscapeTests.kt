package MooscapeTests

import com.codeborne.selenide.Browsers
import org.example.core.Functional.GamesPageSprut
import org.example.core.enums.Env
import org.example.core.enums.Stages
import org.example.core.pages.SC_games.Mooscape
import org.junit.jupiter.api.Test

class MooscapeTests : BaseTest(Stages.STABLE, Browsers.CHROME) {

    private val mooscape: Mooscape = (gameList as GamesPageSprut).getMooscape_game(Env.ENV03) as Mooscape

    @Test
    fun `start the Game`() {
        mooscape.startGame()
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
