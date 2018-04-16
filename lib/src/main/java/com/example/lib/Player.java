package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class Player {
  
  public int userID;
  public int wallet;
  public boolean inJail;
  public int playerPos;
  
  public Player(int userID) {
    this.userID = userID;
    this.wallet = 0;
    this.inJail = false;
    this.playerPos = 0;
  }
  
  //checks whether the loser has lost yet; aka whether wallet==0;
  public boolean lose(Player p){
    return false;
  }
  
  //calls the random number generator and also updates player’s current location
  public void rollDice(){
    playerPos++; //would be random 1-6
  }
  
  //based on player’s location; calls different methods from the corresponding tiles class; updates user
  public void takeActions(Player p){
    this.wallet = wallet + 22;
  }
}
