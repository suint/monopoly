package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public interface Interaction {
  //rewrites board to match current state of game
  void updateUI(Tile[] tiles, Player[] players);
  //shows instructions
  void showIntro();
  //allows user to say yes, no etc. to decisions like buying property
  String getUserInput();
  //shows ending screen - rankings etc.
  void showEnd();
  void addPlayer(Player p);
  void addTile(Tile t, int a);
  void initializeBoard(Board b);
  boolean findEnd();
  Board getBoard();
}
