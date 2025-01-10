package LuckyFishTests;

import com.codeborne.selenide.Browsers
import org.example.core.Functional.GamesPageSprut
import org.example.core.enums.Env
import org.example.core.enums.Stages
import org.example.core.pages.SC_games.LuckyFish

class LuckyFish_negative : BaseTest(Stages.STABLE, Browsers.CHROME) {

    private val luckyFish: LuckyFish = (gameList as GamesPageSprut).getLuckyFish_game(Env.ENV03) as LuckyFish

}
