package org.example.core.entities.gameLists;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.core.annotation.BetGamesPage;
import org.example.core.enums.Env;
import org.example.core.enums.GameName;
import org.example.core.functional.IGame;
import org.example.core.functional.IGameList;
import org.example.core.functional.IGameSC;
import org.example.core.games.sc_games.ColorRace;
import org.example.core.games.sc_games.LuckyFish;
import org.example.core.games.sc_games.Mooscape;
import org.example.core.games.sc_games.Pirate;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Point;
import org.springframework.context.annotation.Primary;

import static org.example.core.enums.GameId.*;
import static org.example.core.functional.ActionController.*;

/**
 * Page with games
 * Annotated with @Primary to let spring boot know which bean is main in category
 */
@Primary
@BetGamesPage
public class GamesPageSprut implements IGameList {

    private final ElementsCollection gameProvider_field = get_elements("//select[@name='provider']/option");
    private final ElementsCollection gameCurrency_field = get_elements("//select[@name='currency']/option");
    private final ElementsCollection gamePlatform_field = get_elements("//select[@name='platform' and @id='selectPlatform']");
    private final ElementsCollection gameList = get_elements("//div[@id='gameList']/div");

    private final SelenideElement platforms = get_element("//select[@name='platform' and @id='selectPlatform']");
    private final SelenideElement provider = get_element("//select[@name='provider']");
    private final SelenideElement currency = get_element("//select[@name='currency']");

    public GamesPageSprut() {

    }

    @NotNull
    private IGameSC get_colorRace_game(@NotNull Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            gameList.get(COLOR_RACE_ENV2.getId()).$("b").click();
            return new ColorRace();
        } else if (env == Env.ENV03) {
            gameList.get(COLOR_RACE_ENV3.getId()).$("b").click();
            return new ColorRace();
        } else {
            throw new RuntimeException("Error in getting color race game");
        }
    }

    @NotNull
    private IGameSC get_luckyFish_game(@NotNull Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            gameList.get(LUCKY_FISH_ENV2.getId()).$("b").click();
            return new LuckyFish();
        } else if (env == Env.ENV03) {
            changeProvider();
            gameList.get(LUCKY_FISH_ENV3.getId()).$("b").click();
            return new LuckyFish();
        } else {
            throw new RuntimeException("Error in getting lucky fish game");
        }
    }

    @NotNull
    private IGameSC get_mooscape_game(@NotNull Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            gameList.get(MOOSCAPE_ENV2.getId()).$("b").click();
            return new Mooscape();
        } else if (env == Env.ENV03) {
            changeProvider();
            gameList.get(MOOSCAPE_ENV3.getId()).$("b").click();
            return new Mooscape();
        } else {
            throw new RuntimeException("Error in getting mooscape game");
        }
    }

    @NotNull
    private IGameSC get_pirate_game(@NotNull Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            gameList.get(PIRATE_ENV2.getId()).$("b").click();
            return new Pirate();
        } else if (env == Env.ENV03) {
            changeProvider();
            gameList.get(PIRATE_ENV3.getId()).$("b").click();
            return new Pirate();
        } else {
            throw new RuntimeException("error in getting pirate game");
        }
    }

    /**
     * Valid statements for method
     *
     * @param platformName - desktop or mobile
     */
    public void changePlatform(String platformName) {
        platforms.click();
        switch (platformName) {
            case "desktop":
                gamePlatform_field.get(0).click();
            case "mobile":
                gamePlatform_field.get(1).click();
            default:
                throw new RuntimeException("Not a platform");
        }
    }

    public void changeProvider() {
        int positionInList = 1;
        provider.click();
        gameProvider_field.get(positionInList).click();
        click_On(new Point(100, 100));
    }

    public void changeCurrency(int currencyPosition) {
        currency.click();
        gameCurrency_field.get(currencyPosition).click();
    }

    @Override
    public @NotNull IGame get_game(@NotNull String game) {
        IGame game_to_return = null;
        GameName gameName = GameName.reverse_getting(game);
        switch (gameName) {
            case COLOR_RACE -> game_to_return = get_colorRace_game(Env.ENV03);
            case PIRATE -> game_to_return = get_pirate_game(Env.ENV03);
            case MOOSCAPE -> game_to_return = get_mooscape_game(Env.ENV03);
            case LUCKY_FISH -> game_to_return = get_luckyFish_game(Env.ENV03);
        }
        return game_to_return;
    }

    @Override
    public @NotNull ElementsCollection getGameList() {
        return gameList;
    }
}
