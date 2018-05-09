package com.example.lib;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Kelly on 4/30/2018.
 */

/*public class test extends Frame implements WindowListener,ActionListener{
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
*/
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ass {
  
  public static void main(String[] args) throws IOException {
    JFrame frame = buildFrame();
    final BufferedImage image;
    try {
      String imgPath = new File("").getAbsolutePath();
      imgPath = imgPath + "\\lib\\src\\main\\java\\com\\example\\lib\\monopoly.png";
      image = ImageIO.read(new File(imgPath));
      /*newimage = new BufferedImage(500,
              500, image.getType());*/
      //newimage =  Thumbnails.of(image).size(500, 500).asBufferedImage();
      
      JPanel pane = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          g.drawImage(image, 0, 0, null);
        }
      };
      
      
      frame.add(pane);
      frame.setVisible(true);
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
    // final BufferedImage newimage = new BufferedImage(200,
    //200, image.getType());
    
  }
  
  
  private static JFrame buildFrame() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    return frame;
  }
  
  
}