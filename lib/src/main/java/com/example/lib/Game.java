package com.example.lib;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Game extends JFrame implements ActionListener {
  //https://en.wikibooks.org/wiki/Monopoly/Official_Rules
  
  private Random random = new Random();
  Interaction gameUI;
  private JTextField txtIn;
  private JButton enter;
  private static String s;
  JTextField textResult;
  private int player = 0;
  
  public Game(Interaction i) {
    this.gameUI = i;
    setSize(666, 750);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Monopoly!!!");
    
    JPanel thePanel = new JPanel();
    textResult = new JTextField("0", 20);
    
    Font font = new Font("Helvetica", Font.PLAIN, 18);
    
    textResult.setFont(font);
    
    JPanel board;
    
    //just testing images
    String imgPath = new File("").getAbsolutePath();
    imgPath = imgPath + "\\lib\\src\\main\\java\\com\\example\\lib\\monopoly.png";
    try {
      final BufferedImage image = ImageIO.read(new File(imgPath));
      board = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          g.drawImage(image, 0, 0, null);
        }
      };
      board.setSize(new Dimension(900, 300));
      add(board);
    } catch (IOException e){
      System.out.println(e.getMessage());
    }
    
    //init button
    enter = new JButton("Enter");
    // enter.setBounds(80,150,100,40);
    enter.addActionListener(this);
    
    JLabel lb = new JLabel("Enter the Number of Players:");
    
  }
  
  public void actionPerformed(ActionEvent a) {
    s = textResult.getText();
    //lbl.setText(s);
    //startGame(Integer.parseInt(s));
  }
  
  public void startGame() {
    int turn = 0;
    
    gameUI.showIntro();
    int np = 2;
    //game stuff here
    // System.out.println("How many players?");
    // int np = Integer.parseInt(gameUI.getUserInput());
    for (int i = 0; i < np; i++) {
      gameUI.addPlayer(new Player(i));
    }
    
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
      /*
      if (gameUI.getBoard().getGameTiles()[gameUI.getBoard().getGamePlayers().get(turn).getPlayerPos()].getClass().equals(new CardTile())){
      
      } else if ()*/
      
      turn++;
    }
    gameUI.showEnd();
  }
  //public LayoutManager initLayout(){}
  
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
    //gameUI.addTile(new PropertyTile("St. Charles Place", ), 0);

  }
  
  public String useCard(String s, int player) {
    //display string in textbox
    String flavorText = "The card reads:";
    switch (s) {
      case "goback3":
        if (gameUI.getBoard().getGamePlayers().get(player).getPlayerPos() >= 3) {
          gameUI.getBoard().getGamePlayers().get(player).move(-3);
        } else {
          gameUI.getBoard().getGamePlayers().get(player).setPlayerPos(0);
        }
        flavorText = flavorText + "\nGo Back 3 Spaces";
        break;
      case "poortax15":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(-15);
        flavorText = flavorText + "\nPay poor tax of $15";
        break;
      case "advtogo":
        gameUI.getBoard().getGamePlayers().get(player).setPlayerPos(0);
        flavorText = flavorText + "\nAdvance to Go (Collect $200)";
        break;
      case "avdtoutil":
        //advance to nearest utility
        //write this later when all tiles are set
        gameUI.getBoard().getGamePlayers().get(player).setPlayerPos(5);
        flavorText = flavorText + "\nAdvance token to nearest Utility. \nIf unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.";
        break;
      case "bankpays50":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(50);
        flavorText = flavorText + "\nBank pays you dividend of $50";
        break;
      case "gotoillav":
        //advance to illinois avenue
        //write when tiles done
        gameUI.getBoard().getGamePlayers().get(player).setPlayerPos(0);
        flavorText = flavorText + "\nAdvance to Illinois Ave—If you pass Go, collect $200";
        break;
      case "gotostc":
        //adv to st. charles place
        gameUI.getBoard().getGamePlayers().get(player).setPlayerPos(0);
        flavorText = flavorText + "\nAdvance to St. Charles Place – If you pass Go, collect $200";
        break;
      case "getoutofjail":
        if (gameUI.getBoard().getGamePlayers().get(player).inJail) {
          gameUI.getBoard().getGamePlayers().get(player).setInJail(false);
        } else {
          gameUI.getBoard().getGamePlayers().get(player).addJailCard();
        }
        flavorText = flavorText + "\nGet Out of Jail Free";
        break;
      case "gotojail":
        if (gameUI.getBoard().getGamePlayers().get(player).hasJailCard()) {
          gameUI.getBoard().getGamePlayers().get(player).useJailCard();
          flavorText = flavorText = "\nGo to jail - do not pass Go, do not collect $200";
        } else {
          gameUI.getBoard().getGamePlayers().get(player).setInJail(true);
          gameUI.getBoard().getGamePlayers().get(player).setPlayerPos(10);
        }
        flavorText = flavorText + "\nGo to Jail–Go directly to Jail–Do not pass Go, do not collect $200";
        break;
      case "makerepairs":
        //pays per house
        //rewrite later
        gameUI.getBoard().getGamePlayers().get(player).addMoney(-20);
        flavorText = flavorText + "\nMake general repairs on all your property–For each house pay $25–For each hotel $100";
        break;
      case "gotoboardwalk":
        //no boardwalk yet...
        flavorText = flavorText + "\nTake a walk on the Boardwalk–Advance token to Boardwalk";
        break;
      case "chairman":
        //pay 50 to each other player
        gameUI.getBoard().getGamePlayers().get(player).addMoney(gameUI.getBoard().getGamePlayers().size() * -50);
        for (int i = 0; i < gameUI.getBoard().getGamePlayers().size(); i++) {
          if (!(i == player))
            gameUI.getBoard().getGamePlayers().get(i).addMoney(50);
        }
        flavorText = flavorText + "\nYou have been elected Chairman of the Board–Pay each player $50";
        break;
      case "building150":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(150);
        flavorText = flavorText + "\nYour building and loan matures—Collect $150";
        break;
      case "crossword100":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(100);
        flavorText = flavorText + "\nYou have won a crossword competition—Collect $100";
        break;
      case "bankerror200":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(200);
        flavorText = flavorText + "\nBank error in your favor—Collect $200";
        break;
      case "dr50":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(-50);
        flavorText = flavorText + "\nDoctor's fee—Pay $50";
        break;
      case "stock50":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(50);
        flavorText = flavorText + "\nFrom sale of stock you get $50";
        break;
      case "operacollect50":
        //collect 50 from each other player
        gameUI.getBoard().getGamePlayers().get(player).addMoney(gameUI.getBoard().getGamePlayers().size() * 50);
        for (int i = 0; i < gameUI.getBoard().getGamePlayers().size(); i++) {
          if (!(i == player))
            gameUI.getBoard().getGamePlayers().get(i).addMoney(-50);
        }
        flavorText = flavorText + "\nGrand Opera Night—Collect $50 from every player for opening night seats";
        break;
      case "holiday100":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(100);
        flavorText = flavorText + "\nHoliday Fund matures—Receive $100";
        break;
      case "refund20":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(20);
        flavorText = flavorText + "\nIncome tax refund–Collect $20";
        break;
      case "bday10":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(10);
        flavorText = flavorText + "\nIt is your birthday—Collect $10";
        break;
      case "hosp100":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(-100);
        flavorText = flavorText + "\nPay hospital fees of $100";
        break;
      case "school150":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(-150);
        flavorText = flavorText + "\nPay school fees of $150";
        break;
      case "inherit100":
        gameUI.getBoard().getGamePlayers().get(player).addMoney(100);
        flavorText = flavorText + "\nYou inherit $100";
        break;
      case "repairs40-115":
        //pays per house
        //rewrite later
        gameUI.getBoard().getGamePlayers().get(player).addMoney(-20);
        flavorText = flavorText + "\nYou are assessed for street repairs–$40 per house–$115 per hotel";
        break;
    }
    return flavorText;
  }
  
  public static void main(String[] args) {
    //Game game = new Game(new UI());
    //game.startGame();
    SwingUtilities.invokeLater(new Runnable() {
        @Override
      public void run() {
                new Game(new UI()).setVisible(true);
              }
    });
  }
}