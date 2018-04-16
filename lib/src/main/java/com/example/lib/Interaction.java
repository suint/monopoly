package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public interface Interaction {
  //rewrites board to match current state of game
  void updateUI(Tiles[] tiles, Player[] players);
  void showIntro();
  String getUserInput();
  int rollDice();
  //calls the random number generator and also updates player’s current location
  void showEnd();
}
