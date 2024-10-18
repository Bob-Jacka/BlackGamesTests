package PirateTests;

import com.codeborne.selenide.Selenide;
import org.example.core.enums.Env;
import org.example.core.pages.GamesPage;
import org.example.core.pages.SprutCloud;
import org.example.core.pages.games.Pirate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Pirate_positive {

    private static SprutCloud spC;
    private static GamesPage gamesPage;
    private Pirate pirate;

    @BeforeEach
    void startGame() {
        spC = new SprutCloud();
        spC.enterUserName();
        gamesPage = spC.loginInto();
        pirate = gamesPage.getPirate_game(Env.ENV02);
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @Tag("positive")
    void shouldPayOnRed() {
        pirate.payOnRed();
    }

    @Test
    @Tag("positive")
    void shouldPayOnMixed() {
        pirate.payOnMixed();
    }

    @Test
    @Tag("positive")
    void shouldPayOnBlack() {
        pirate.payOnBlack();
    }

    @Test
    @Tag("positive")
    void shouldPayOnAll() {
        pirate.payOnRed();
        pirate.payOnMixed();
        pirate.payOnBlack();
    }

}
