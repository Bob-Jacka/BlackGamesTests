package ColorRaceTests;

import com.codeborne.selenide.Selenide;
import org.example.core.enums.Env;
import org.example.core.pages.GamesPage;
import org.example.core.pages.SprutCloud;
import org.example.core.pages.games.ColorRace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ColorRace_negative {

    private static SprutCloud spC;
    private static GamesPage gamesPage;
    private ColorRace colorRace;

    @BeforeEach
    void startGame() {
        spC = new SprutCloud();
        spC.enterUserName();
        gamesPage = spC.loginInto();
        colorRace = gamesPage.getColorRace_game(Env.ENV02);
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

}
