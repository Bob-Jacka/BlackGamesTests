package PirateTests

import com.codeborne.selenide.Browsers
import org.example.core.Functional.GamesPageSprut
import org.example.core.enums.Env
import org.example.core.enums.Stages
import org.example.core.pages.SC_games.Pirate

class Pirate_negative : BaseTest(Stages.STABLE, Browsers.CHROME) {

    private val pirate: Pirate = (gameList as GamesPageSprut).getPirate_game(Env.ENV03) as Pirate
}
