package com.example.lib;

public class Game {
  //https://en.wikibooks.org/wiki/Monopoly/Official_Rules
  
  Interaction gameUI;
  
  public Game(Interaction i, Board b){
    this.gameUI = i;
  }
  
  public void startGame(){
    gameUI.showIntro();
    //game stuff here
    
  }
  
  public static void main (String[] args){
    Game game = new Game(new UI(), new Board());
    game.startGame();
  }
}
