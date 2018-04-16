package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public interface Interaction {
  void updateUI(Tiles[] tiles, Player[] players);
  void showIntro();
  void getUserInput();
  void rollDice();
  void showEnd();
}
