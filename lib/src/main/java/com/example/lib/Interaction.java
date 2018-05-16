package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public interface Interaction {
  /*most of these functions became more or less obsolete after we started to use swing graphics */
  //rewrites board to match current state of game
  void updateUI(Tile[] tiles, Player[] players);
  //shows instructions
  void showIntro();
  //allows user to say yes, no etc. to decisions like buying property
  String getUserInput();
  //adds player to player arraylist in board class
  void addPlayer(Player p);
  //adds tile to tile array in board
  void addTile(Tile t, int a);
  void initializeBoard(Board b);
  //finds if either player lost
  int findEnd();
  void showEnd();
  //returns board class
  Board getBoard();
}
