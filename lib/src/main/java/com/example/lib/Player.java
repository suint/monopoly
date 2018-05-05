package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class Player {
  
  public int userID;
  public int wallet;
  public boolean inJail;
  public int playerPos;
  public boolean jailCard; //whether user has get out of jail free card
  
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
  
  public void addJailCard() {this.jailCard = true;}
  
  public void useJailCard() {this.jailCard = false;}
  
  public boolean hasJailCard() {return this.jailCard;}
  
  public int getPlayerPos() {
    return playerPos;
  }
  
  public void setPlayerPos(int playerPos) {
    this.playerPos = playerPos;
  }
  
  public Player(int userID) {
    this.userID = userID;
    this.wallet = 80;
    this.inJail = false;
    this.playerPos = 0;
    this.jailCard = false;
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
    int newPos = playerPos + i;
    if (newPos > 10){
      newPos = newPos - 11;
    }
    playerPos = newPos; //would be random 1-6
  }
  
}
