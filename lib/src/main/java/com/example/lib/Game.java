package com.example.lib;

public class Game {
  
  Interaction gameUI;
  Board board;
  
  public Game(Interaction i, Board b){
    this.gameUI = i;
    this.board = b;
  }
  
  public static void main (String[] args){
    Game game = new Game(new UI(), new Board());
  }
}
