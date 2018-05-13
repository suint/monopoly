package com.example.lib;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Created by Kelly on 5/10/2018.
 */

class Window extends JFrame implements ActionListener {
  //https://en.wikibooks.org/wiki/Monopoly/Official_Rules
  
  private JTextField txtIn;
  private JLabel dialog;
  private static String s;
  private Game myGame;
  private JPanel board;
  
  public Window(Game g) {
    myGame = g;
    g.startGame2();
    setSize(616, 740);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Monopoly!!!");
    
    /*JPanel inPanel = new JPanel(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();
    
    txtIn = new JTextField("Enter your responses here.");
    c.gridx = 1;
    c.gridy = 1;
    txtIn.setFont(new Font("Helvetica", Font.PLAIN, 18));
    inPanel.add(txtIn);
    
    //init button
    enter = new JButton("Enter");
    // enter.setBounds(80,150,100,40);
    enter.addActionListener(this);
    c.gridx = 2;
    c.gridy = 1;
    inPanel.add(enter);*/
    this.setLayout(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();

    c.insets=new Insets(6,6,6,6);

    //Panel

    //import board image
      board = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          try {
            String imgPath = new File("").getAbsolutePath();
            imgPath = imgPath + "\\lib\\src\\main\\java\\com\\example\\lib\\monopoly.png";
            final BufferedImage image = ImageIO.read(new File(imgPath));
            g.drawImage(drawBoard(image), 0, 0, null);
          } catch (IOException e){
            System.out.println(e.getMessage());
          }
        }
      };
      board.setBorder(BorderFactory.createLineBorder(Color.black));
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth=4;
      c.fill=GridBagConstraints.BOTH;
      c.weightx=1;
      c.weighty=9.5;

      this.add(board, c);
    



    //Label

    dialog = new JLabel("Instructions here");
    dialog.setBorder(BorderFactory.createLineBorder(Color.black));

    c.gridx=0;
    c.gridy=1;
    c.weightx=1;
    c.weighty=.025;

    this.add(dialog,c);

    //Text

    txtIn=new JTextField();
    txtIn.setText("text in");
    JScrollPane pane=new JScrollPane(txtIn);

    c.gridx=0;
    c.gridy=2;
    c.weightx=.9;
    c.gridwidth=3;
    c.weighty=.025;

    add(pane,c);

    //Button

    JButton button=new JButton("Enter");
    button.addActionListener(this);

    c.gridx=3;
    c.gridy=2;
    c.gridwidth=1;
    c.weightx=.1;
    c.weighty=.025;
    c.fill=GridBagConstraints.NONE;

    add(button,c);

  }
  
  public void actionPerformed(ActionEvent a) {
    s = txtIn.getText();
    myGame.nextTurn();
    setDialog(myGame.getInfo());
    board.repaint();
  }

  protected BufferedImage drawBoard(BufferedImage img) {
    myGame.initTiles();
    Graphics2D g2d = img.createGraphics();
    
    g2d.setColor(Color.RED);
    g2d.fill(new Ellipse2D.Float(620, 620, 40, 40));
    
    /*g2d.setColor(Color.WHITE);
    Rectangle info = new Rectangle(200,175, 100,50);
    g2d.fill(info);
    */
    g2d.setColor(Color.BLACK);
    Font font1 = new Font("Sans Serif", Font.PLAIN, 20);
    g2d.setFont(font1);
    String tempString = "Turn: " + myGame.getTurn();
    FontRenderContext frc = g2d.getFontRenderContext();
    g2d.drawString(tempString, 200, 200);
    g2d.dispose();/*
    turn = 0;
    myGame.gameUI.addPlayer(new Player(1));
    gameUI.addPlayer(new Player(2));
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
      setDialog(in);
      posx = gameUI.getBoard().getGameTiles()[gameUI.getBoard().getGamePlayers().get(player).getPlayerPos()].getTilePosx();
      posy = gameUI.getBoard().getGameTiles()[gameUI.getBoard().getGamePlayers().get(player).getPlayerPos()].getTilePosy();
      //g2d.fill(new Ellipse2D.Float(0, 0, 40, 40));
      //g2d.dispose();
    
      turn++;
    }*/
    return img;
  }
  
  public void setDialog(String s){
    dialog.setText(s);
  }
  
  public String getDialog(){
    return dialog.getText();
  }
  
  public static void main(String[] args) {
    //Game game = new Game(new UI());
    //game.startGame();
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Window(new Game()).setVisible(true);
      }
    });
  }
}