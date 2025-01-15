package org.example.core.entities.gameLists;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.core.enums.Env;
import org.example.core.enums.GameName;
import org.example.core.functional.IGame;
import org.example.core.functional.IGameList;
import org.example.core.functional.IGameSC;
import org.example.core.pages.sc_games.ColorRace;
import org.example.core.pages.sc_games.LuckyFish;
import org.example.core.pages.sc_games.Mooscape;
import org.example.core.pages.sc_games.Pirate;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.example.core.enums.GameId.*;
import static org.example.core.enums.GameName.*;
import static org.example.core.functional.ActionController.wait_For;

@Component
public class GamesPageSprut implements IGameList {

    private final ElementsCollection gameProvider = $$(By.xpath("//select[@name='provider']/option"));
    private final ElementsCollection gameCurrency = $$(By.xpath("//select[@name='currency']/option"));
    private final ElementsCollection gamePlatform = $$(By.xpath("//select[@name='platform' and @id='selectPlatform']"));
    private final ElementsCollection gameList = $$(By.xpath("//div[@id='gameList']/div"));

    private final SelenideElement platforms = $(By.xpath("//select[@name='platform' and @id='selectPlatform']"));
    private final SelenideElement provider = $(By.xpath("//select[@name='provider']"));
    private final SelenideElement currency = $(By.xpath("//select[@name='currency']"));

    @NotNull
    public IGameSC get_colorRace_game(@NotNull Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            wait_For(1);
            gameList.get(COLOR_RACE_ENV2.getId()).find(By.linkText(COLOR_RACE.getName())).click();
            return new ColorRace();
        } else if (env == Env.ENV03) {
            wait_For(1);
            gameList.get(COLOR_RACE_ENV3.getId()).find(By.linkText(COLOR_RACE.getName())).click();
            return new ColorRace();
        } else {
            throw new RuntimeException("error in getting color race game");
        }
    }

    @NotNull
    public IGameSC get_luckyFish_game(@NotNull Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            wait_For(1);
            gameList.get(LUCKY_FISH_ENV2.getId()).find(By.linkText(LUCKY_FISH.getName())).click();
            return new LuckyFish();
        } else if (env == Env.ENV03) {
            changeProvider();
            wait_For(1);
            gameList.get(LUCKY_FISH_ENV3.getId()).find(By.linkText(LUCKY_FISH.getName())).click();
            return new LuckyFish();
        } else {
            throw new RuntimeException("error in getting lucky fish game");
        }
    }

    @NotNull
    public IGameSC get_mooscape_game(@NotNull Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            wait_For(2);
            gameList.get(MOOSCAPE_ENV2.getId()).find(By.linkText(MOOSCAPE.getName())).click();
            return new Mooscape();
        } else if (env == Env.ENV03) {
            changeProvider();
            wait_For(1);
            gameList.get(MOOSCAPE_ENV3.getId()).find(By.linkText(MOOSCAPE.getName())).click();
            return new Mooscape();
        } else {
            throw new RuntimeException("error in getting mooscape game");
        }
    }

    @NotNull
    public IGameSC get_pirate_game(@NotNull Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            wait_For(1);
            gameList.get(PIRATE_ENV2.getId()).find(By.linkText(PIRATE.getName())).click();
            return new Pirate();
        } else if (env == Env.ENV03) {
            changeProvider();
            wait_For(1);
            gameList.get(PIRATE_ENV3.getId()).find(By.linkText(PIRATE.getName())).click();
            return new Pirate();
        } else {
            throw new RuntimeException("error in getting pirate game");
        }
    }

    /*
        Valid statements for method
        @param platformName - desktop or mobile
     */
    public void changePlatform(String platformName) {
        platforms.click();
        switch (platformName) {
            case "desktop":
                gamePlatform.get(0).click();
            case "mobile":
                gamePlatform.get(1).click();
            default:
                throw new RuntimeException("not a platform");
        }
    }

    public void changeProvider() {
        int positionInlist = 1;
        provider.click();
        wait_For(2);
        gameProvider.get(positionInlist).click();
    }

    public void changeCurrency(int currencyPosition) {
        currency.click();
        wait_For(1);
        gameCurrency.get(currencyPosition).click();
    }

    @Override
    public @NotNull IGame get_game(@NotNull GameName gameName) {
        IGame game_to_return = null;
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
        return null;
    }
}
