package ColorRaceTests;

import com.codeborne.selenide.Selenide;
import org.example.core.enums.Env;
import org.example.core.pages.GamesPage;
import org.example.core.pages.SprutCloud;
import org.example.core.pages.games.ColorRace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ColorRace_positive: BaseTest {

    private val colorRace: ColorRace = gamesPage.getColorRace_game(Env.ENV02);;

}
