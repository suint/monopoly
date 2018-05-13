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
  private JScrollPane dialogContainer;
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
  
    dialog = new JLabel("Welcome to Monopoly. Type answers below. Scroll if text cuts off. Type \"help\" to see extra commands.");
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

    //Text

    txtIn=new JTextField();
    txtIn.setText("Type commands here.");
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
    
    //player one
    g2d.setColor(Color.RED);
    int posx1 = myGame.Posx(1);
    int posy1 = myGame.Posy(1);
    g2d.fill(new Rectangle(posx1, posy1, 20, 20));
    
    //player two
    g2d.setColor(Color.BLUE);
    int posx2 = myGame.Posx(2)+20;
    int posy2 = myGame.Posy(2)+20;
    g2d.fill(new Rectangle(posx2, posy2, 20, 20));
    
    g2d.dispose();
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