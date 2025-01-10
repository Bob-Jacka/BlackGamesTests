package PirateTests

import com.codeborne.selenide.Browsers
import org.example.core.Functional.GamesPageSprut
import org.example.core.enums.Env
import org.example.core.enums.Stages
import org.example.core.pages.SC_games.Pirate
import org.example.core.pages.SC_games.Test

class Pirate_positive : BaseTest(Stages.STABLE, Browsers.CHROME) {

    private val pirate: Pirate = (gameList as GamesPageSprut).getPirate_game(Env.ENV03) as Pirate

    @Test
    fun `Should pay on Red`() {
        pirate.payOnRed()
    }

    @Test
    fun `Should pay on Mixed`() {
        pirate.payOnMixed()
    }

    @Test
    fun `Should pay on Black`() {
        pirate.payOnBlack()
    }

    @Test
    fun `Should pay on All`() {
        pirate.payOnRed()
        pirate.payOnMixed()
        pirate.payOnBlack()
    }
}
