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

public class Pirate_positive: BaseTest {

    private val pirate: Pirate;

    @Test
    void `Should pay on Red`() {
        pirate.payOnRed();
    }

    @Test
    void `Should pay on Mixed`() {
        pirate.payOnMixed();
    }

    @Test
    void `Should pay on Black`() {
        pirate.payOnBlack();
    }

    @Test
    void `Should pay on All`() {
        pirate.payOnRed();
        pirate.payOnMixed();
        pirate.payOnBlack();
    }

}
