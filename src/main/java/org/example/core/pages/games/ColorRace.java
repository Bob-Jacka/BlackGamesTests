package org.example.core.pages.games;

import org.example.core.pages.ActionController;
import org.openqa.selenium.Point;

public class ColorRace {

    private final Point cachier_btn = new Point(116, 106);
    private final Point play_btn = new Point(960, 730);
    private final Point upBet_btn = new Point(1032, 863);
    private final Point lowBet_btn = new Point(885, 863);
    private final Point balance_btn = new Point(960, 938);
    private final Point blockchainInfo_btn = new Point(1780, 250);
    private final Point history_btn = new Point(1690, 145);
    private final Point playAudioEffects_btn = new Point(1735, 145);
    private final Point playMusic_btn = new Point(1780, 145);

    private final Point blueBet = new Point(820, 780);
    private final Point greenBet = new Point(920, 780);
    private final Point purpleBet = new Point(1020, 780);
    private final Point redBet = new Point(1120, 780);

    public void startGame() {
        ActionController.clickOn(play_btn);
    }

    public void payOn_Blue() {
        ActionController.clickOn(blueBet);
    }

    public void payOn_Green() {
        ActionController.clickOn(greenBet);
    }

    public void payOn_Purple() {
        ActionController.clickOn(purpleBet);
    }

    public void payOn_Red() {
        ActionController.clickOn(redBet);
    }

    public void payOn_All() {
        ActionController.clickOn(blueBet);
        ActionController.clickOn(greenBet);
        ActionController.clickOn(purpleBet);
        ActionController.clickOn(redBet);
    }

    public void changeBet(boolean up, int howMany) {
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
