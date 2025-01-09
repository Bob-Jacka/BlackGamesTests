package LuckyFishTests;

import com.codeborne.selenide.Selenide;
import org.example.core.enums.Env;
import org.example.core.pages.GamesPage;
import org.example.core.pages.SprutCloud;
import org.example.core.pages.games.LuckyFish;

@TestData()
public class LuckyFish_negative: BaseTest {

    private val luckyFish: LuckyFish = luckyFish = gamesPage.getLuckyFish_game(Env.ENV02);

}
