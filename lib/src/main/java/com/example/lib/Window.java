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

/**
 * Created by Kelly on 5/10/2018.
 */

class Window extends JFrame implements ActionListener {
  //https://en.wikibooks.org/wiki/Monopoly/Official_Rules
  
  private JTextField txtIn;
  private JButton enter;
  private static String s;
  private JLabel dialog;
  private Game myGame;
  
  public Window(Game g) {
    myGame = g;
    g.startGame2();
    setSize(616, 740);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Monopoly!!!");
    
    JPanel inPanel = new JPanel(new GridBagLayout());
    
    GridBagConstraints c = new GridBagConstraints();
    
    txtIn = new JTextField("Enter your responses here.");
    c.gridx = 1;
    c.gridy = 0;
    txtIn.setFont(new Font("Helvetica", Font.PLAIN, 18));
    inPanel.add(txtIn);
    
    //init button
    enter = new JButton("Enter");
    // enter.setBounds(80,150,100,40);
    enter.addActionListener(this);
    c.gridx = 2;
    c.gridy = 0;
    inPanel.add(enter);
    
    JPanel board;
    
    //import board image
    String imgPath = new File("").getAbsolutePath();
    imgPath = imgPath + "\\lib\\src\\main\\java\\com\\example\\lib\\monopoly.png";
    try {
      final BufferedImage image = ImageIO.read(new File(imgPath));
      board = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          g.drawImage(image, 0, 0, null);
        }
      };
      board.setMinimumSize(new Dimension(666, 750));
      c.gridx = 0;
      c.gridy = 1;
      add(board);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    
    dialog = new JLabel("instructions here");
    c.gridx = 0;
    c.gridy = 2;
    add(dialog, BorderLayout.EAST);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 3;
    add(inPanel, BorderLayout.SOUTH);
  }
  
  public void actionPerformed(ActionEvent a) {
    s = txtIn.getText();
    myGame.nextTurn();
    setDialog(myGame.getInfo());
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