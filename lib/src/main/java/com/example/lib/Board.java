package com.example.lib;
import java.util.ArrayList;

/**
 * Created by Kelly on 4/16/2018.
 */

public class Board {
  private Tile[] gameTiles;
  private ArrayList<Player> gamePlayers = new ArrayList<Player>();
  
  public Board(){
    this.gameTiles = new Tile[12]; //maybe change this number
  }
  
  public Tile[] getGameTiles() {
    return gameTiles;
  }
  
  public void setGameTiles(Tile[] gameTiles) {
    this.gameTiles = gameTiles;
  }
  
  public ArrayList<Player> getGamePlayers() {
    return gamePlayers;
  }
  
  public void setGamePlayers(ArrayList<Player> gamePlayers) {
    this.gamePlayers = gamePlayers;
  }
  
  public void addPlayer(Player p){
    gamePlayers.add(p);
  }
  
  public void addTile(Tile t, int x){
    gameTiles[x] = t; //would add tile onto end of list of tiles... not an arraylist since num of tiles is fixed
  }
  
  public Player getPlayer(int j){
    int id = 0;
    for (int i = 0; i < gamePlayers.size(); i++){
      if (gamePlayers.get(i).getUserID() == j){
        id = i;
      }
    }
    return gamePlayers.get(id);
  }
  
}
