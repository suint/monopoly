package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class Player {
  
  public int userID;
  public int wallet;
  public boolean inJail;
  public int playerPos;
  
  public int getUserID() {
    return userID;
  }
  
  public void setUserID(int userID) {
    this.userID = userID;
  }
  
  public int getWallet() {
    return wallet;
  }
  
  public void setWallet(int wallet) {
    this.wallet = wallet;
  }
  
  public void addMoney(int i){
    this.wallet = wallet + i;
  }
  
  public boolean isInJail() {
    return inJail;
  }
  
  public void setInJail(boolean inJail) {
    this.inJail = inJail;
  }
  
  public int getPlayerPos() {
    return playerPos;
  }
  
  public void setPlayerPos(int playerPos) {
    this.playerPos = playerPos;
  }
  
  public Player(int userID) {
    this.userID = userID;
    this.wallet = 500;
    this.inJail = false;
    this.playerPos = 0;
  }
  
  //checks whether the loser has lost yet; aka whether wallet==0;
  public boolean lose(){
    boolean a = false;
    if (wallet <= 0){
      a = true;
    }
    return a;
  }
  
  
  public void move(int i){
    playerPos = playerPos + i; //would be random 1-6
  }
  
  //based on player’s location; calls different methods from the corresponding tiles class; updates user
  public void takeActions(Player p){
    this.wallet = wallet + 22;
  }
  
}
