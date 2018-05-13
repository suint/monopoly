package com.example.lib;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Random;
import javax.swing.*;

public class Game{
  private Interaction gameUI = new UI();
  private Random random = new Random();
  private int player;
  private int turn;
  
  public void startGame2(){
    turn = 0;
    gameUI.addPlayer(new Player(1));
    gameUI.addPlayer(new Player(2));
    System.out.println("game inits");
    initTiles();
  }
  
  /*public void startGame() {
    
    gameUI.showIntro();
    
    
    initTiles();
    
    while (!(gameUI.findEnd())) {
      if (turn >= gameUI.getBoard().getGamePlayers().size()) {
        turn = 0;
      }
      int roll = random.nextInt(5) + 1;
      player = turn + 1;
      System.out.println("player " + player + "'s turn ");
      System.out.println("dice rolling...");
      gameUI.getBoard().getGamePlayers().get(turn).move(roll);
      System.out.println("player " + player + " advanced " + roll + " tiles, landing on tile " + gameUI.getBoard().getGamePlayers().get(turn).getPlayerPos());
      String in = gameUI.getBoard().getGameTiles()[gameUI.getBoard().getGamePlayers().get(turn).getPlayerPos()].tileAction(gameUI, turn);
      if (!(in.equals("tile"))){
        if (in.equals("yes")){
          System.out.println("You now own:");
          //System.out.println(gameUI.getBoard().getGameTiles()[gameUI.getBoard().getGamePlayers().get(turn).getPlayerPos()].getTileName().split("#")[0]);
          
          for (int i = 0; i < gameUI.getBoard().getGameTiles().length; i++){ //find if each tile is owned by current player. check if property tile & if tagged as owned by current player
            if ((gameUI.getBoard().getGameTiles()[i].getClass().equals(new PropertyTile())) &&
                    (Integer.parseInt(gameUI.getBoard().getGameTiles()[i].getTileName().split("#")[1]) == 0)){
              System.out.println(gameUI.getBoard().getGameTiles()[i].getTileName());
            }
          }
        } else if (!(in.equals("no"))){
          System.out.println(useCard(in, turn));
        }
      }
      
      if (gameUI.getBoard().getGameTiles()[gameUI.getBoard().getGamePlayers().get(turn).getPlayerPos()].getClass().equals(new CardTile())){
      
      } else if ()
      
      turn++;
    }
    gameUI.showEnd();
  }*/
  
  public void initTiles() {
    //tile adding - FIRST 11 TILES ONLY
    //http://allaboutfunandgames.com/wp-content/uploads/2012/02/Monopoly-Board.jpg
    gameUI.addTile(new Tile("GO", 0, 0, 100), 0);
    gameUI.addTile(new PropertyTile("Mediterranean Avenue", 1, 0, -1, -1, 60), 1);
    gameUI.addTile(new CardTile("Community Chest", 2, 0, CardTile.CardStack.COMMUNITYCHEST, 0), 2);
    gameUI.addTile(new PropertyTile("Baltic Avenue", 3, 0,-1, -1, 60), 3);
    gameUI.addTile(new TaxTile("Income Tax", 4, 0, -200), 4); //original tile is $200 or 10%
    gameUI.addTile(new PropertyTile("Reading Railroad", 5, 0,-1, -1,  200), 5);
    gameUI.addTile(new PropertyTile("Oriental Avenue", 6, 0,-1, -1, 100), 6);
    gameUI.addTile(new CardTile("Chance", 7, 0, CardTile.CardStack.CHANCE, 0), 7);
    gameUI.addTile(new PropertyTile("Vermont Avenue", 8, 0,-1, -1,  100), 8);
    gameUI.addTile(new PropertyTile("Connecticut Avenue", 9, 0, -1, -1,  120), 9);
    gameUI.addTile(new Tile("Jail", 10, 0, 0), 10);
    gameUI.addTile(new PropertyTile("St.Charles Place", 30, 490,-1, -1, 120), 11);
    gameUI.addTile(new TaxTile("Electric Company", 30, 440, -200), 12);
    gameUI.addTile(new PropertyTile("States Avenue", 30, 390,-1, -1, 120), 13);
    gameUI.addTile(new PropertyTile("Viriginia Avenue", 30, 340,-1, -1, 120), 14);
    gameUI.addTile(new PropertyTile("MOA Railroad", 30, 290,-1, -1,  200), 15);
    gameUI.addTile(new PropertyTile("St. James Avenue", 30, 240,-1, -1,  180), 16);
    gameUI.addTile(new CardTile("Community Chest", 30, 190, CardTile.CardStack.COMMUNITYCHEST, 0), 17);
    gameUI.addTile(new PropertyTile("Tenesse Avenue", 30, 140,-1, -1,  200), 18);
    gameUI.addTile(new PropertyTile("New York Avenue", 30, 90,-1, -1,  200), 19);
    gameUI.addTile(new Tile("Free Parking", 30, 40, 0), 20);
    gameUI.addTile(new PropertyTile("PA Avenue", 80, 40,-1, -1,  220), 21);
    gameUI.addTile(new CardTile("Chance", 130, 40, CardTile.CardStack.CHANCE, 0), 22);
    gameUI.addTile(new PropertyTile("PA Avenue", 180, 40,-1, -1,  220), 23);
    gameUI.addTile(new PropertyTile("PA Avenue", 230, 40,-1, -1,  220), 24);
    gameUI.addTile(new PropertyTile("BBO Railroad", 280, 40,-1, -1,  200), 25);
    gameUI.addTile(new PropertyTile("Atlantic Avenue", 330, 40,-1, -1,  300), 26);
    gameUI.addTile(new PropertyTile("Vienna Avenue", 380, 40,-1, -1,  320), 27);
    gameUI.addTile(new PropertyTile("Water Company", 430, 40,-1, -1,  200), 28);
    gameUI.addTile(new PropertyTile("Massachusettes Avenue", 480, 40,-1, -1,  360), 29);
    gameUI.addTile(new Tile("Go To Jail", 520, 40, 0), 30);
    gameUI.addTile(new PropertyTile("South Carolina Ave", 520, 90,-1, -1,  300), 31);
    gameUI.addTile(new PropertyTile("N Carolina Ave", 520, 140,-1, -1,  300), 32);
    gameUI.addTile(new CardTile("Community Chest", 520, 190, CardTile.CardStack.COMMUNITYCHEST, 0), 33);
    gameUI.addTile(new PropertyTile("Empire Palace", 520, 240,-1, -1,  380), 34);
    gameUI.addTile(new PropertyTile("Short Line", 520, 290,-1, -1,  200), 35);
    gameUI.addTile(new CardTile("Chance", 520, 340, CardTile.CardStack.CHANCE, 0), 36);
    gameUI.addTile(new PropertyTile("Park Place", 520, 390,-1, -1,  280), 37);
    gameUI.addTile(new TaxTile("Luxury Tax", 520, 440, -100), 38);
    gameUI.addTile(new PropertyTile("Broadway", 520, 490,-1, -1,  380), 39);
    //gameUI.addTile(new PropertyTile("St. Charles Place"), 0);

  }
  
  public int Posx(int playerid){
    return gameUI.getBoard().getGameTiles()[gameUI.getBoard().getPlayer(playerid).getPlayerPos()].getTilePosx();
  }
  
  public int Posy(int playerid){
    return gameUI.getBoard().getGameTiles()[gameUI.getBoard().getPlayer(playerid).getPlayerPos()].getTilePosy();
  }
  
  //advances turn
  public void nextTurn(){
    turn++;
    player = (turn%2) + 1;
    int roll = random.nextInt(5) + 1;
    gameUI.getBoard().getPlayer(player).move(roll);
  }
  
  public int getTurn(){
    return turn;
  }
  
  //returns information about current player
  public String getInfo(){
    int playerPos = gameUI.getBoard().getPlayer(player).getPlayerPos();
    String s = "Player " + player + " advanced to the tile " + gameUI.getBoard().getGameTiles()[playerPos].getTileName() + ". ";
    if (gameUI.getBoard().getGameTiles()[playerPos] instanceof CardTile){
      String cardID = gameUI.getBoard().getGameTiles()[gameUI.getBoard().getPlayer(player).getPlayerPos()].tileAction(gameUI, player).split("#")[0];
      String cardType = gameUI.getBoard().getGameTiles()[gameUI.getBoard().getPlayer(player).getPlayerPos()].tileAction(gameUI, player).split("#")[1];
      s += useCard(cardID, player, cardType);
    } else if (gameUI.getBoard().getGameTiles()[playerPos] instanceof PropertyTile){
      s += " Would you like to purchase this tile? Type \"y\" if yes, \"n\" if no.";
    } else if (gameUI.getBoard().getGameTiles()[playerPos] instanceof TaxTile){
      String tax = gameUI.getBoard().getGameTiles()[playerPos].tileAction(gameUI, player);
      s += " You have been taxed " + tax;
      gameUI.getBoard().getPlayer(player).addMoney(Integer.parseInt(tax));
    }
    return s;
  }
  
  
  public String useCard(String s, int player, String type) {
    //display string in textbox
    String flavorText = "";
    if (type.equals("CC")) {
      flavorText += "You have drawn a community chest card. It reads: ";
    } else if (type.equals("C")) {
      flavorText += "You have drawn a chance card. It reads: ";
    }
    switch (s) {
      case "goback3":
        if (gameUI.getBoard().getPlayer(player).getPlayerPos() >= 3) {
          gameUI.getBoard().getPlayer(player).move(-3);
        } else {
          gameUI.getBoard().getPlayer(player).setPlayerPos(0);
        }
        flavorText = flavorText + "\nGo Back 3 Spaces";
        break;
      case "poortax15":
        gameUI.getBoard().getPlayer(player).addMoney(-15);
        flavorText = flavorText + "\nPay poor tax of $15";
        break;
      case "advtogo":
        gameUI.getBoard().getPlayer(player).setPlayerPos(0);
        flavorText = flavorText + "\nAdvance to Go (Collect $200)";
        break;
      case "avdtoutil":
        //advance to nearest utility
        //write this later when all tiles are set
        gameUI.getBoard().getPlayer(player).setPlayerPos(5);
        flavorText = flavorText + "\nAdvance token to nearest Utility. \nIf unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.";
        break;
      case "bankpays50":
        gameUI.getBoard().getPlayer(player).addMoney(50);
        flavorText = flavorText + "\nBank pays you dividend of $50";
        break;
      case "gotoillav":
        //advance to illinois avenue
        //write when tiles done
        gameUI.getBoard().getPlayer(player).setPlayerPos(0);
        flavorText = flavorText + "\nAdvance to Illinois Ave—If you pass Go, collect $200";
        break;
      case "gotostc":
        //adv to st. charles place
        gameUI.getBoard().getPlayer(player).setPlayerPos(0);
        flavorText = flavorText + "\nAdvance to St. Charles Place – If you pass Go, collect $200";
        break;
      case "getoutofjail":
        if (gameUI.getBoard().getPlayer(player).inJail) {
          gameUI.getBoard().getPlayer(player).setInJail(false);
        } else {
          gameUI.getBoard().getPlayer(player).addJailCard();
        }
        flavorText = flavorText + "\nGet Out of Jail Free";
        break;
      case "gotojail":
        if (gameUI.getBoard().getPlayer(player).hasJailCard()) {
          gameUI.getBoard().getPlayer(player).useJailCard();
          flavorText = flavorText = "\nGo to jail - do not pass Go, do not collect $200";
        } else {
          gameUI.getBoard().getPlayer(player).setInJail(true);
          gameUI.getBoard().getPlayer(player).setPlayerPos(10);
        }
        flavorText = flavorText + "\nGo to Jail–Go directly to Jail–Do not pass Go, do not collect $200";
        break;
      case "makerepairs":
        //pays per house
        //rewrite later
        gameUI.getBoard().getPlayer(player).addMoney(-20);
        flavorText = flavorText + "\nMake general repairs on all your property–For each house pay $25–For each hotel $100";
        break;
      case "gotoboardwalk":
        //no boardwalk yet...
        flavorText = flavorText + "\nTake a walk on the Boardwalk–Advance token to Boardwalk";
        break;
      case "chairman":
        //pay 50 to each other player
        gameUI.getBoard().getPlayer(player).addMoney(gameUI.getBoard().getGamePlayers().size() * -50);
        for (int i = 0; i < gameUI.getBoard().getGamePlayers().size(); i++) {
          if (!(i == player))
            gameUI.getBoard().getPlayer(i).addMoney(50);
        }
        flavorText = flavorText + "\nYou have been elected Chairman of the Board–Pay each player $50";
        break;
      case "building150":
        gameUI.getBoard().getPlayer(player).addMoney(150);
        flavorText = flavorText + "\nYour building and loan matures—Collect $150";
        break;
      case "crossword100":
        gameUI.getBoard().getPlayer(player).addMoney(100);
        flavorText = flavorText + "\nYou have won a crossword competition—Collect $100";
        break;
      case "bankerror200":
        gameUI.getBoard().getPlayer(player).addMoney(200);
        flavorText = flavorText + "\nBank error in your favor—Collect $200";
        break;
      case "dr50":
        gameUI.getBoard().getPlayer(player).addMoney(-50);
        flavorText = flavorText + "\nDoctor's fee—Pay $50";
        break;
      case "stock50":
        gameUI.getBoard().getPlayer(player).addMoney(50);
        flavorText = flavorText + "\nFrom sale of stock you get $50";
        break;
      case "operacollect50":
        //collect 50 from each other player
        gameUI.getBoard().getPlayer(player).addMoney(gameUI.getBoard().getGamePlayers().size() * 50);
        for (int i = 0; i < gameUI.getBoard().getGamePlayers().size(); i++) {
          if (!(i == player))
            gameUI.getBoard().getPlayer(i).addMoney(-50);
        }
        flavorText = flavorText + "\nGrand Opera Night—Collect $50 from every player for opening night seats";
        break;
      case "holiday100":
        gameUI.getBoard().getPlayer(player).addMoney(100);
        flavorText = flavorText + "\nHoliday Fund matures—Receive $100";
        break;
      case "refund20":
        gameUI.getBoard().getPlayer(player).addMoney(20);
        flavorText = flavorText + "\nIncome tax refund–Collect $20";
        break;
      case "bday10":
        gameUI.getBoard().getPlayer(player).addMoney(10);
        flavorText = flavorText + "\nIt is your birthday—Collect $10";
        break;
      case "hosp100":
        gameUI.getBoard().getPlayer(player).addMoney(-100);
        flavorText = flavorText + "\nPay hospital fees of $100";
        break;
      case "school150":
        gameUI.getBoard().getPlayer(player).addMoney(-150);
        flavorText = flavorText + "\nPay school fees of $150";
        break;
      case "inherit100":
        gameUI.getBoard().getPlayer(player).addMoney(100);
        flavorText = flavorText + "\nYou inherit $100";
        break;
      case "repairs40-115":
        //pays per house
        //rewrite later
        gameUI.getBoard().getPlayer(player).addMoney(-20);
        flavorText = flavorText + "\nYou are assessed for street repairs–$40 per house–$115 per hotel";
        break;
    }
    return flavorText;
  }
}