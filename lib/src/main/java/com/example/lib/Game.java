package com.example.lib;

public class Game {
  
  Interaction gameUI;
  
  public Game(Interaction i, Board b){
    this.gameUI = i;
  }
  
  public static void main (String[] args){
    Game game = new Game(new UI(), new Board());
  }
}
