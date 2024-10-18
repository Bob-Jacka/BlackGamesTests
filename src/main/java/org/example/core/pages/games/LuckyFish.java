package org.example.core.pages.games;

import org.example.core.pages.ActionController;
import org.openqa.selenium.Point;

public class LuckyFish {

    private final Point play_btn = new Point(959, 750);
    private final Point bet_btn = new Point(957, 870);
    private final Point autobet_btn = new Point(800, 730);
    private final Point autocashout_btn = new Point(900, 730);
    private final Point game_info = new Point(1700, 185);
    private final Point sound_on = new Point(1740, 185);
    private final Point blockchain_info = new Point(1780, 290);
    private final Point game_history = new Point(1780, 230);

    private final Point minus_coef = new Point(1030, 730);
    private final Point plus_coef = new Point(1120, 730);
    private final Point input_field_coef = new Point(1070, 730);

    private final Point minus_bet = new Point(815, 780);
    private final Point plus_bet = new Point(970, 780);
    private final Point input_field_bet = new Point(900, 780);

    private final Point one = new Point(810, 820);
    private final Point two = new Point(870, 820);
    private final Point five = new Point(920, 820);
    private final Point ten = new Point(980, 820);

    private final Point balance = new Point(960, 940);

    private final Point reload_btn = new Point(963, 735);

    public void startGame() {
        ActionController.clickOn(play_btn);
    }

    public void turn_music() {
        ActionController.clickOn(sound_on);
    }

    public void show_game_history() {
        ActionController.clickOn(game_history);
    }

    public void show_blockchain_info() {
        ActionController.clickOn(blockchain_info);
    }

    public void show_gameinfo() {
        ActionController.clickOn(game_info);
    }

    public void bet() {
        ActionController.clickOn(bet_btn);
    }

    public void enable_autocashout() {
        ActionController.clickOn(autocashout_btn);
    }

    public void enable_autobet() {
        ActionController.clickOn(autobet_btn);
    }

    public void change_coef(boolean up, int howMany) {
        if (up) {
            for (int i = 0; i < howMany; i++) {
                ActionController.clickOn(plus_coef);
            }
        } else {
            for (int i = 0; i < howMany; i++) {
                ActionController.clickOn(minus_coef);
            }
        }
    }
}
