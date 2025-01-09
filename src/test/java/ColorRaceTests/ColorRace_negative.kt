package ColorRaceTests;

import com.codeborne.selenide.Selenide;
import org.example.core.enums.Env;
import org.example.core.pages.GamesPage;
import org.example.core.pages.games.ColorRace;

public class ColorRace_negative: BaseTest {

    private val colorRace: ColorRace = gamesPage.getColorRace_game(Env.ENV02);

}
