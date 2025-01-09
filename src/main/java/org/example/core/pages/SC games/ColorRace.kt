package org.example.core.pages.games;

import org.example.core.pages.ActionController;
import org.openqa.selenium.Point;

public class ColorRace {

    private val cachier_btn: Point =  Point(116, 106);
    private val play_btn: Point =  Point(960, 730);
    private val upBet_btn: Point =  Point(1032, 863);
    private val lowBet_btn: Point =  Point(885, 863);
    private val balance_btn: Point =  Point(960, 938);
    private val blockchainInfo_btn: Point =  Point(1780, 250);
    private val history_btn: Point =  Point(1690, 145);
    private val playAudioEffects_btn: Point =  Point(1735, 145);
    private val playMusic_btn: Point =  Point(1780, 145);

    private val blueBet: Point =  Point(820, 780);
    private val greenBet: Point =  Point(920, 780);
    private val purpleBet: Point =  Point(1020, 780);
    private val redBet: Point =  Point(1120, 780);

    public fun startGame() {
        ActionController.clickOn(play_btn);
    }

    public fun payOn_Blue() {
        ActionController.clickOn(blueBet);
    }

    public fun payOn_Green() {
        ActionController.clickOn(greenBet);
    }

    public fun payOn_Purple() {
        ActionController.clickOn(purpleBet);
    }

    public fun payOn_Red() {
        ActionController.clickOn(redBet);
    }

    public fun payOn_All() {
        ActionController.clickOn(blueBet);
        ActionController.clickOn(greenBet);
        ActionController.clickOn(purpleBet);
        ActionController.clickOn(redBet);
    }

    public fun changeBet(boolean up, int howMany) {
        if (up) {
            for (int i = 0; i < howMany; i++) {
                ActionController.clickOn(upBet_btn);
            }

        } else {
            for (int i = 0; i < howMany; i++) {
                ActionController.clickOn(lowBet_btn);
            }
        }
    }
}
