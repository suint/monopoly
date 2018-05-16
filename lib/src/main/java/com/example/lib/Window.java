package com.example.lib;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by Kelly on 5/10/2018.
 */

class Window extends JFrame implements ActionListener {
  //https://en.wikibooks.org/wiki/Monopoly/Official_Rules
  
  private JTextField txtIn;
  private JScrollPane dialogContainer;
  private JLabel dialog;
  private static String s;
  private Game myGame;
  private JPanel board;
  
  //window initialize when program is run
  public Window(Game g) {
    myGame = g; //initialize game object
    g.startGame2(); //game starting functions
    setSize(616, 740); //size of jframe
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Monopoly!!!");
    
    this.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    c.insets=new Insets(6,6,6,6); //padding

    //Board panel

    //import board image
      board = new JPanel() {
        @Override //rewrite default paintComponent method
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          try {
            String imgPath = new File("").getAbsolutePath();
            imgPath = imgPath + "\\lib\\src\\main\\java\\com\\example\\lib\\monopoly.png"; //get absolute path of board image
            final BufferedImage image = ImageIO.read(new File(imgPath));
            g.drawImage(drawBoard(image), 0, 0, null);
          } catch (IOException e){
            System.out.println(e.getMessage());
          }
        }
      };
      board.setBorder(BorderFactory.createLineBorder(Color.black)); //create borders
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth=4;
      c.fill=GridBagConstraints.BOTH;
      c.weightx=1;
      c.weighty=9.5;

      this.add(board, c);

    //Game info label
    dialog = new JLabel("Welcome to Monopoly. Type answers below. Scroll if text cuts off.");
    dialogContainer = new JScrollPane(dialog);
    dialogContainer.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
    dialogContainer.getHorizontalScrollBar().setPreferredSize (new Dimension(0,0));
    dialogContainer.getVerticalScrollBar().setMinimumSize(new Dimension(0, 0));
    dialogContainer.getVerticalScrollBar().setMinimumSize(new Dimension(0, 0));
    dialogContainer.getVerticalScrollBar().setMaximumSize(new Dimension(0, 0));
    dialogContainer.getVerticalScrollBar().setMaximumSize(new Dimension(0, 0));
    dialogContainer.setBorder(BorderFactory.createLineBorder(Color.black));

    c.gridx=0;
    c.gridy=1;
    c.weightx=1;
    c.weighty=.025;

    this.add(dialogContainer,c);

    //Text input field

    txtIn=new JTextField();
    txtIn.setText("Type commands here. Click enter if no commands are prompted");
    JScrollPane pane=new JScrollPane(txtIn);

    c.gridx=0;
    c.gridy=2;
    c.weightx=.9;
    c.gridwidth=3;
    c.weighty=.025;

    add(pane,c);

    //Enter Button

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
      if (myGame.findEnd() == 1) {
        JOptionPane.showMessageDialog (null, "Player 1 has won. Player 2 went bankrupt", "P2 Win", JOptionPane.INFORMATION_MESSAGE);
      } else if (myGame.findEnd() == 2) {
        JOptionPane.showMessageDialog (null, "Player 2 has won. Player 1 went bankrupt", "P2 Win", JOptionPane.INFORMATION_MESSAGE);
      } else {
    
        //gets input from text field
        s = txtIn.getText();
    
        //deals with input in text field, gets info about current player
        String prevPlayer = myGame.getIn(s);
    
        //advances turn
        myGame.nextTurn();
    
        //sets text in dialog box
        setDialog(prevPlayer + myGame.getInfo());
    
        //check if player lost
    
    
        //reset dialog box
        txtIn.setText("");
    
        //update board panel
        board.repaint();
      }
  }

  //edits default monopoly board to draw player positions
  protected BufferedImage drawBoard(BufferedImage img) {
    myGame.initTiles();
    Graphics2D g2d = img.createGraphics();
    
      //player one
    g2d.setColor(Color.RED);
    int posx1 = myGame.posX(myGame.playerPos(1));
    int posy1 = myGame.posY(myGame.playerPos(1));
    g2d.fill(new Rectangle(posx1, posy1, 20, 20));
  
    //player two
    g2d.setColor(Color.BLUE);
    int posx2 = myGame.posX(myGame.playerPos(2)) + 20;
    int posy2 = myGame.posY(myGame.playerPos(2)) + 20;
    g2d.fill(new Rectangle(posx2, posy2, 20, 20));
  
    g2d.dispose();
    return img;
  }
  
  //changes dialog label text
  public void setDialog(String s){
    dialog.setText(s);
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