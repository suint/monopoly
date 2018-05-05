package com.example.lib;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Game extends JFrame implements ActionListener{
  //https://en.wikibooks.org/wiki/Monopoly/Official_Rules
  
  private Random random = new Random();
  Interaction gameUI;
  private JTextField txtIn;
  private JButton enter;
  private static String s;
  private JLabel lb5, board;
  GridBagConstraints layoutConst = null;
  JTextField textResult;


  public Game(Interaction i){
    this.gameUI = i;
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Monopoly!!!");

    JPanel thePanel = new JPanel();



    textResult = new JTextField("0",20);

    Font font = new Font("Helvetica", Font.PLAIN, 18);

    textResult.setFont(font);


    //just testing images
    String img = "C:\\Users\\Betty\\AndroidStudioProjects\\Monopoly\\lib\\src\\main\\java\\com\\example\\lib\\Capture.PNG";
    board = new JLabel(new ImageIcon(img));
    board.setMinimumSize(new Dimension(400, 300));
    thePanel.add(board);

    //init button
    enter = new JButton("Enter");
   // enter.setBounds(80,150,100,40);
    enter.addActionListener(this);

    lb5 = new JLabel("Enter the Number of Players:");


    add(thePanel);
  }
  
  public void actionPerformed(ActionEvent a){
    s = textResult.getText();
    //lbl.setText(s);
    //startGame(Integer.parseInt(s));
  }
  
  public void startGame(){
    int turn = 0;
    
    gameUI.showIntro();
    int np = 2;
    //game stuff here
   // System.out.println("How many players?");
   // int np = Integer.parseInt(gameUI.getUserInput());
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
      gameUI.getBoard().getGameTiles()[gameUI.getBoard().getGamePlayers().get(turn).getPlayerPos()].tileAction();
      gameUI.getBoard().getGamePlayers().get(turn).addMoney(-20);
      System.out.println("you landed on the pay taxes tile. you lose 20 dollars. now you have " + gameUI.getBoard().getGamePlayers().get(turn).getWallet() + " dollars");
  
      turn++;
    }
    gameUI.showEnd();
  }
  
  public int rollDice() {
    int i = random.nextInt(5) + 1;
    return i;
  }
  
  public static void main (String[] args){
    Game game = new Game(new UI());
    game.startGame();
  }
    /*SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Game(new UI()).setVisible(true);
      }
    });
  }*/
}