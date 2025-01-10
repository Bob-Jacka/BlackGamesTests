package ColorRaceTests;

import com.codeborne.selenide.Browsers
import org.example.core.Functional.GamesPageSprut
import org.example.core.enums.Env
import org.example.core.enums.Stages
import org.example.core.pages.SC_games.ColorRace

class ColorRace_negative : BaseTest(Stages.STABLE, Browsers.CHROME) {

    private val colorRace: ColorRace = (gameList as GamesPageSprut).getColorRace_game(Env.ENV03) as ColorRace

}
