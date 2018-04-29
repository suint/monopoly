package com.example.lib;
import java.util.Random;

public class Game {
  //https://en.wikibooks.org/wiki/Monopoly/Official_Rules
  
  Random random = new Random();
  Interaction gameUI;
  
  public Game(Interaction i){
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
    
            //tile adding - FIRST 11 TILES ONLY
            //http://allaboutfunandgames.com/wp-content/uploads/2012/02/Monopoly-Board.jpg
    gameUI.addTile(new Tile("GO", 0, "tile.jpg"), 0);
    gameUI.addTile(new PropertyTile("Mediterranean Avenue", 1, "tile.jpg", 60), 1);
    gameUI.addTile(new CardTile("Community Chest", 2, "tile.jpg", CardTile.CardStack.COMMUNITYCHEST), 2);
    gameUI.addTile(new PropertyTile("Baltic Avenue", 3, "tile.jpg", 60), 3);
    gameUI.addTile(new TaxTile("Income Tax", 4, "tile.jpg", 200), 4); //original tile is $200 or 10%
    gameUI.addTile(new PropertyTile("Reading Railroad", 5, "tile.jpg", 200), 5);
    gameUI.addTile(new PropertyTile("Oriental Avenue", 6, "tile.jpg", 100), 6);
    gameUI.addTile(new CardTile("Chance", 7, "tile.jpg", CardTile.CardStack.CHANCE), 7);
    gameUI.addTile(new PropertyTile("Vermont Avenue", 8, "tile.jpg", 100), 8);
    gameUI.addTile(new PropertyTile("Connecticut Avenue", 9, "tile.jpg", 120), 9);
    gameUI.addTile(new Tile("Jail", 10, "tile.jpg"), 10);
    
    while (!(gameUI.findEnd())){
      if (turn >= gameUI.getBoard().getGamePlayers().size()){
        turn = 0;
      }
      System.out.println("player " + turn + "'s turn ");
      System.out.println("dice rolling...");
      int roll = rollDice();
      int player = turn+1;
      gameUI.getBoard().getGamePlayers().get(turn).move(roll);
      System.out.println("player " + player + " advanced " + roll + " tiles, landing on tile " + gameUI.getBoard().getGamePlayers().get(turn).getPlayerPos());
      gameUI.getBoard().getGamePlayers().get(turn).addMoney(-20);
      System.out.println("you landed on the pay taxes tile. you lose 20 dollars. now you have " + gameUI.getBoard().getGamePlayers().get(turn).getWallet() + " dollars");
  
      turn++;
    }
    gameUI.showEnd();
  }
  
  public int rollDice(){
    int i = random.nextInt(5)+1;
    return i;
  }
  
  public static void main (String[] args){
    Game game = new Game(new UI());
    game.startGame();
  }
}