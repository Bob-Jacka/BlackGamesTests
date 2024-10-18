package LuckyFishTests;

import com.codeborne.selenide.Selenide;
import org.example.core.enums.Env;
import org.example.core.pages.GamesPage;
import org.example.core.pages.SprutCloud;
import org.example.core.pages.games.LuckyFish;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class LuckyFish_negative {

    private SprutCloud spC;
    private GamesPage gamesPage;
    private LuckyFish luckyFish;

    @BeforeEach
    void startGame() {
        spC = new SprutCloud();
        spC.enterUserName();
        gamesPage = spC.loginInto();
        luckyFish = gamesPage.getLuckyFish_game(Env.ENV02);
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

}
