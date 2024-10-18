package org.example.core.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.core.enums.Env;
import org.example.core.pages.games.ColorRace;
import org.example.core.pages.games.LuckyFish;
import org.example.core.pages.games.Mooscape;
import org.example.core.pages.games.Pirate;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.example.core.enums.GameId.*;
import static org.example.core.enums.GameName.*;
import static org.example.core.pages.ActionController.waitFor;

public class GamesPage {

    private final ElementsCollection gameProvider = $$(By.xpath("//select[@name='provider']/option"));
    private final ElementsCollection gameCurrency = $$(By.xpath("//select[@name='currency']/option"));
    private final ElementsCollection gamePlatform = $$(By.xpath("//select[@name='platform' and @id='selectPlatform']"));
    private final ElementsCollection gameList = $$(By.xpath("//div[@id='gameList']/div"));

    private final SelenideElement platforms = $(By.xpath("//select[@name='platform' and @id='selectPlatform']"));
    private final SelenideElement provider = $(By.xpath("//select[@name='provider']"));
    private final SelenideElement currency = $(By.xpath("//select[@name='currency']"));

    public ColorRace getColorRace_game(Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            waitFor(1);
            gameList.get(COLOR_RACE_ENV2.getId()).find(By.linkText(COLOR_RACE.getName())).click();
            return new ColorRace();
        } else if (env == Env.ENV03) {
            waitFor(1);
            gameList.get(COLOR_RACE_ENV3.getId()).find(By.linkText(COLOR_RACE.getName())).click();
            return new ColorRace();
        } else {
            throw new RuntimeException();
        }
    }

    public LuckyFish getLuckyFish_game(Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            waitFor(1);
            gameList.get(LUCKY_FISH_ENV2.getId()).find(By.linkText(LUCKY_FISH.getName())).click();
            return new LuckyFish();
        } else if (env == Env.ENV03) {
            changeProvider();
            waitFor(1);
            gameList.get(LUCKY_FISH_ENV3.getId()).find(By.linkText(LUCKY_FISH.getName())).click();
            return new LuckyFish();
        } else {
            throw new RuntimeException();
        }
    }

    public Mooscape getMooscape_game(Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            waitFor(2);
            gameList.get(MOOSCAPE_ENV2.getId()).find(By.linkText(MOOSCAPE.getName())).click();
            return new Mooscape();
        } else if (env == Env.ENV03) {
            changeProvider();
            waitFor(1);
            gameList.get(MOOSCAPE_ENV3.getId()).find(By.linkText(MOOSCAPE.getName())).click();
            return new Mooscape();
        } else {
            throw new RuntimeException();
        }
    }

    public Pirate getPirate_game(Env env) {
        if (env == Env.ENV02) {
            changeProvider();
            waitFor(1);
            gameList.get(PIRATE_ENV2.getId()).find(By.linkText(PIRATE.getName())).click();
            return new Pirate();
        } else if (env == Env.ENV03) {
            changeProvider();
            waitFor(1);
            gameList.get(PIRATE_ENV3.getId()).find(By.linkText(PIRATE.getName())).click();
            return new Pirate();
        } else {
            throw new RuntimeException();
        }
    }

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
        waitFor(2);
        gameProvider.get(positionInlist).click();
    }

    public void changeCurrency(int currencyPosition) {
        currency.click();
        waitFor(1);
        gameCurrency.get(currencyPosition).click();
    }
}
