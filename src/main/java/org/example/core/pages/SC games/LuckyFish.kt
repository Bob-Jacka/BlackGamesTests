package org.example.core.pages.games;

import org.example.core.pages.ActionController;
import org.openqa.selenium.Point;

public class LuckyFish {

   private var isSound = false

   private val play_btn: Point = Point(959, 750);
   private val bet_btn: Point = Point(957, 870);
   private val autobet_btn: Point = Point(800, 730);
   private val autocashout_btn: Point = Point(900, 730);
   private val game_info: Point = Point(1700, 185);
   private val sound_on: Point = Point(1740, 185);
   private val blockchain_info: Point = Point(1780, 290);
   private val game_history: Point = Point(1780, 230);

   private val minus_coef: Point = Point(1030, 730);
   private val plus_coef: Point = Point(1120, 730);
   private val input_field_coef: Point = Point(1070, 730);

   private val minus_bet: Point = Point(815, 780);
   private val plus_bet: Point = Point(970, 780);
   private val input_field_bet: Point = Point(900, 780);

   private val one: Point = Point(810, 820);
   private val two: Point = Point(870, 820);
   private val five: Point = Point(920, 820);
   private val ten: Point = Point(980, 820);

   private val balance: Point = Point(960, 940);

   private val reload_btn: Point = Point(963, 735);

    public fun startGame() {
        ActionController.clickOn(play_btn);
    }

    public fun turn_music() {
        ActionController.clickOn(sound_on);
    }

    public fun show_game_history() {
        ActionController.clickOn(game_history);
    }

    public fun show_blockchain_info() {
        ActionController.clickOn(blockchain_info);
    }

    public fun show_gameinfo() {
        ActionController.clickOn(game_info);
    }

    public fun bet() {
        ActionController.clickOn(bet_btn);
    }

    public fun enable_autocashout() {
        ActionController.clickOn(autocashout_btn);
    }

    public fun enable_autobet() {
        ActionController.clickOn(autobet_btn);
    }

    public fun change_coef(boolean up, int howMany) {
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
