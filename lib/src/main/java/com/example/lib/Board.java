package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class Board {
  private Tile[] gameTiles;
  private Player[] gamePlayers;
  
  public Tile[] getGameTiles() {
    return gameTiles;
  }
  
  public void setGameTiles(Tile[] gameTiles) {
    this.gameTiles = gameTiles;
  }
  
  public Player[] getGamePlayers() {
    return gamePlayers;
  }
  
  public void setGamePlayers(Player[] gamePlayers) {
    this.gamePlayers = gamePlayers;
  }
  
}
