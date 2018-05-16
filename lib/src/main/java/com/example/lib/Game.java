package com.example.lib;
import java.util.Random;

//this class has most of the major game functions and interacts with internal game information via the
//UI object that it holds.

public class Game{
  private Interaction gameUI = new UI();
  private Random random = new Random();
  private int player;
  private int turn;
  
  //starting game functions - initializing players, tiles, turn counter
  public void startGame2(){
    turn = 0;
    player = 0;
    gameUI.addPlayer(new Player(1));
    gameUI.addPlayer(new Player(2));
    initTiles();
  }
  
  //game via console
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
  
  //initializes tile array
  public void initTiles() {
    gameUI.addTile(new Tile("GO", 520, 520, 100), 0);
    gameUI.addTile(new PropertyTile("Mediterranean Avenue", 480, 520, -1, -1, 60), 1);
    gameUI.addTile(new CardTile("Community Chest", 430, 520, CardTile.CardStack.COMMUNITYCHEST, 0), 2);
    gameUI.addTile(new PropertyTile("Baltic Avenue", 380, 520,-1, -1, 60), 3);
    gameUI.addTile(new TaxTile("Income Tax", 330, 520, -200), 4);
    gameUI.addTile(new PropertyTile("Reading Railroad", 280, 520,-1, -1,  200), 5);
    gameUI.addTile(new PropertyTile("Oriental Avenue", 230, 520,-1, -1, 100), 6);
    gameUI.addTile(new CardTile("Chance", 180, 520, CardTile.CardStack.CHANCE, 0), 7);
    gameUI.addTile(new PropertyTile("Vermont Avenue", 130, 520,-1, -1,  100), 8);
    gameUI.addTile(new PropertyTile("Connecticut Avenue", 80, 520, -1, -1,  120), 9);
    gameUI.addTile(new Tile("Jail", 30, 520, 0), 10);
    gameUI.addTile(new PropertyTile("St. Charles Place", 30, 490,-1, -1, 140), 11);
    gameUI.addTile(new PropertyTile("Electric Company", 30, 440, -200), 12);
    gameUI.addTile(new PropertyTile("States Avenue", 30, 390,-1, -1, 140), 13);
    gameUI.addTile(new PropertyTile("Virginia Avenue", 30, 340,-1, -1, 160), 14);
    gameUI.addTile(new PropertyTile("PA Railroad", 30, 290,-1, -1,  200), 15);
    gameUI.addTile(new PropertyTile("St. James Place", 30, 240,-1, -1,  180), 16);
    gameUI.addTile(new CardTile("Community Chest", 30, 190, CardTile.CardStack.COMMUNITYCHEST, 0), 17);
    gameUI.addTile(new PropertyTile("Tennessee Avenue", 30, 140,-1, -1,  180), 18);
    gameUI.addTile(new PropertyTile("NY Avenue", 30, 90,-1, -1,  200), 19);
    gameUI.addTile(new Tile("Free Parking", 30, 40, 0), 20);
    gameUI.addTile(new PropertyTile("KY Avenue", 80, 40,-1, -1,  220), 21);
    gameUI.addTile(new CardTile("Chance", 130, 40, CardTile.CardStack.CHANCE, 0), 22);
    gameUI.addTile(new PropertyTile("IN Avenue", 180, 40,-1, -1,  220), 23);
    gameUI.addTile(new PropertyTile("IL Avenue", 230, 40,-1, -1,  240), 24);
    gameUI.addTile(new PropertyTile("BBO Railroad", 280, 40,-1, -1,  200), 25);
    gameUI.addTile(new PropertyTile("Atlantic Avenue", 330, 40,-1, -1,  260), 26);
    gameUI.addTile(new PropertyTile("Ventnor Avenue", 380, 40,-1, -1,  260), 27);
    gameUI.addTile(new PropertyTile("Water Works", 430, 40,-1, -1,  150), 28);
    gameUI.addTile(new PropertyTile("Marvin Gardens", 480, 40,-1, -1,  280), 29);
    gameUI.addTile(new Tile("Go To Jail", 520, 40, 0), 30);
    gameUI.addTile(new PropertyTile("Pacific Ave", 520, 90,-1, -1,  300), 31);
    gameUI.addTile(new PropertyTile("N Carolina Ave", 520, 140,-1, -1,  300), 32);
    gameUI.addTile(new CardTile("Community Chest", 520, 190, CardTile.CardStack.COMMUNITYCHEST, 0), 33);
    gameUI.addTile(new PropertyTile("Pennsylvania Ave", 520, 240,-1, -1,  320), 34);
    gameUI.addTile(new PropertyTile("Short Line", 520, 290,-1, -1,  200), 35);
    gameUI.addTile(new CardTile("Chance", 520, 340, CardTile.CardStack.CHANCE, 0), 36);
    gameUI.addTile(new PropertyTile("Park Place", 520, 390,-1, -1,  350), 37);
    gameUI.addTile(new TaxTile("Luxury Tax", 520, 440, -100), 38);
    gameUI.addTile(new PropertyTile("Boardwalk", 520, 490,-1, -1,  400), 39);
  }
  
  //find X position of tile by number
  public int posX(int tile){
    return gameUI.getBoard().getGameTiles()[tile].getTilePosx();
  }
  
  //find Y position of tile by number
  public int posY(int tile){
    return gameUI.getBoard().getGameTiles()[tile].getTilePosy();
  }
  
  //find position of player by player ID
  public int playerPos(int playerID){
    return gameUI.getBoard().getPlayer(playerID).getPlayerPos();
  }
  
  //allow window to access whether game has ended
  public int findEnd(){
    return gameUI.findEnd();  }
  
  //advances turn, moves players forward based on dice roll
  public void nextTurn(){
    player = (turn%2) + 1;
    turn++;
    if (!(gameUI.getBoard().getPlayer(player).isInJail())) {
      int roll = random.nextInt(5) + 1;
      gameUI.getBoard().getPlayer(player).move(roll);
    }
  }
  
  //get information based on text input
  public String getIn(String s){
    String n = "";
    int currentTile = gameUI.getBoard().getPlayer(player).getPlayerPos();
    if (gameUI.getBoard().getGameTiles()[currentTile] instanceof PropertyTile){
      if (s.equals("y") && gameUI.getBoard().getGameTiles()[currentTile].getOwnerID() == 0){
        gameUI.getBoard().getGameTiles()[currentTile].tileAction(gameUI, player);
        int cost = -1 * gameUI.getBoard().getGameTiles()[currentTile].getTileValue();
        gameUI.getBoard().getPlayer(player).addMoney(cost);
        n = gameUI.getBoard().getGameTiles()[currentTile].getTileName() + " was bought by player " + player + ". ";
      }
    }
    if (player == 0){
      n += "Player 1 now has " + gameUI.getBoard().getPlayer(player).getWallet() + " dollars. ";
    } else {
      n += "Player " + player + " now has " + gameUI.getBoard().getPlayer(player).getWallet() + " dollars. ";
    }
    return n;
  }
  
  //returns information about current player
  public String getInfo(){
    int playerPos = gameUI.getBoard().getPlayer(player).getPlayerPos();
    
    //new position
    String s = "Player " + player + " advanced to the tile " + gameUI.getBoard().getGameTiles()[playerPos].getTileName() + ". ";
    
    if (gameUI.getBoard().getGameTiles()[playerPos] instanceof CardTile){
      //if player lands on card tile, display card info
      String cardID = gameUI.getBoard().getGameTiles()[gameUI.getBoard().getPlayer(player).getPlayerPos()].tileAction(gameUI, player).split("#")[0];
      String cardType = gameUI.getBoard().getGameTiles()[gameUI.getBoard().getPlayer(player).getPlayerPos()].tileAction(gameUI, player).split("#")[1];
      s += useCard(cardID, player, cardType);
    } else if (gameUI.getBoard().getGameTiles()[playerPos] instanceof PropertyTile){
      if (gameUI.getBoard().getGameTiles()[playerPos].getOwnerID() == 0) {
        //give option to buy tile if not owned
        s += " Would you like to purchase this tile for " + gameUI.getBoard().getGameTiles()[playerPos].getTileValue() + " dollars? Type \"y\" if yes, \"n\" if no.";
      } else if (gameUI.getBoard().getGameTiles()[playerPos].getOwnerID() == player){
        //if own property do nothing
        s += " You admire your property.";
      } else {
        //pay rent to owner if owned by other player
        s += " This property is owned by " + gameUI.getBoard().getGameTiles()[playerPos].getOwnerID() +
                ". You pay " + getRent(playerPos) + " dollars.";
      }
    } else if (gameUI.getBoard().getGameTiles()[playerPos] instanceof TaxTile){
      //pay tax
      String tax = gameUI.getBoard().getGameTiles()[playerPos].tileAction(gameUI, player);
      s += " You have been taxed " + tax;
      gameUI.getBoard().getPlayer(player).addMoney(Integer.parseInt(tax));
    } else {
      if (gameUI.getBoard().getGameTiles()[playerPos].getTileName().equals("GO")){
        //go tile
        s += " You receive 200 dollars.";
        gameUI.getBoard().getPlayer(player).addMoney(200);
      } else if (gameUI.getBoard().getGameTiles()[playerPos].getTileName().equals("Jail")){
        //jail tile
        if (gameUI.getBoard().getPlayer(player).isInJail()){
          s += " You feel sorry for yourself.";
        } else {
          s += " You say hi to the jailbirds.";
        }
      } else if (gameUI.getBoard().getGameTiles()[playerPos].getTileName().equals("Free Parking")){
        s += " You enjoy the freedom of the parking.";
      } else if (gameUI.getBoard().getGameTiles()[playerPos].getTileName().equals("Go To Jail")){
        gameUI.getBoard().getGameTiles()[playerPos].tileAction(gameUI, player);
        s += " You go to jail.";
      }
    }
    return s;
  }
  
  //retrieve amount of rent to be paid on property
  public int getRent(int tile){
    int i = Integer.parseInt(gameUI.getBoard().getGameTiles()[tile].tileAction(gameUI, player));
    return i;
  }
  
  //implements all cards
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
        gameUI.getBoard().getPlayer(player).setPlayerPos(28);
        flavorText = flavorText + "\nAdvance token to Water Works. \nIf unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.";
        
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
        int pay = 0;
        for (int i = 0; i < 41; i++){
          if (gameUI.getBoard().getGameTiles()[i].getOwnerID() == player){
            pay += 50;
          }
        }
        gameUI.getBoard().getPlayer(player).addMoney(-1 * pay);
        flavorText = flavorText + "\nMake general repairs on all your property–For each owned property pay $50.";
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
        flavorText = flavorText + "\nGrand Opera Night—Collect $50 from the other player for opening night seats";
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