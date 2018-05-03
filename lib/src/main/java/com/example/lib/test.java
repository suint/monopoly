package com.example.lib;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Kelly on 4/30/2018.
 */

public class test extends Frame implements WindowListener,ActionListener{
  TextField text = new TextField(20);
  Button b;
  private int numClicks = 0;
  
  
  public void actionPerformed(ActionEvent e){
    numClicks++;
    text.setText("Button clicked " + numClicks + " times!");
  }
  
  public static void main(String[] args){
    test myWindow = new test("A window");
    myWindow.setSize(400,400);
    myWindow.setVisible(true);
  }
  
  public test(String title){
    super(title);
    setLayout(new FlowLayout());
    addWindowListener(this);
    b = new Button("Click me!");
    b.addActionListener(this);
    add(b);
    add(text);
  }
  
  public void windowClosing(WindowEvent e){
    dispose();
    System.exit(0);
  }
  
  public void windowOpened(WindowEvent e) {}
  public void windowActivated(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}
  public void windowClosed(WindowEvent e) {}
}
