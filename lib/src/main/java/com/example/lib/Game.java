package com.example.lib;
import java.util.Random;

public class Game {
  //https://en.wikibooks.org/wiki/Monopoly/Official_Rules
  
  Random random = new Random();
  Interaction gameUI;
  
  public Game(Interaction i, Board b){
    this.gameUI = i;
  }
  
  public void startGame(){
    int turn = 0;
    
    gameUI.showIntro();
    //game stuff here
    System.out.println("How many players?");
    int np = Integer.parseInt(gameUI.getUserInput());
    for (int i = 0; i < np; i++){
      gameUI.addPlayer(new Player(i));
    }
    for (int i = 0; i < 40; i++){
      gameUI.addTile(new Tile("a", i, "tile.jpg"));
    }
    
    while (!(gameUI.findEnd())){
      System.out.println("monopoly");
      turn++;
      if (turn >= gameUI.getBoard().getGamePlayers().size()){
        turn = 0;
      }
      System.out.println("player" + turn + "'s turn");
      System.out.println("dice rolling...");
      gameUI.getBoard().getGamePlayers().get(turn).move(rollDice());
      System.out.println("you landed on the pay taxes tile. you lose 20 dollars");
      gameUI.getBoard().getGamePlayers().get(turn).addMoney(-20);
    }
    gameUI.showEnd();
  }
  
  public int rollDice(){
    int i = random.nextInt(5)+1;
    return i;
  }
  
  public static void main (String[] args){
    Game game = new Game(new UI(), new Board());
    game.startGame();
  }
}
