package com.example.lib;
/*
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;*/
import javax.swing.ImageIcon;

/**
 * Created by Kelly on 4/15/2018.
 */

public class Tile {
  //http://allaboutfunandgames.com/wp-content/uploads/2012/02/Monopoly-Board.jpg
  
  private ImageIcon tileFace; //stores picture of tile
  //probably jumping the gun to put images in this version... in fact, take this out
  
  private String tileName;
  
  private int tilePos;
  //tile position is just one number since the tiles are just consecutive
  
  
  public String getTileName() {
    return tileName;
  }
  
  public void setTileName(String tileName) {
    this.tileName = tileName;
  }
  
  public int getTilePos() {
    return tilePos;
  }
  
  public void setTilePos(int tilePos) {
    this.tilePos = tilePos;
  }
  
  public ImageIcon getTileFace() {
    return tileFace;
  }
  
  public void setTileFace(ImageIcon img) {
    this.tileFace = img;
  }
  
  protected Tile(String name, int pos, String imgFile) {
    setTileName(name);
    setTilePos(pos);
    setTileFace(new ImageIcon(imgFile));
    //System.out.println(getTileFace());
  }
  
  protected Tile(){
    setTileName("null");
    setTilePos(0);
  }
  
  public String tileAction(Interaction i){
    System.out.println("this is a tile");
    String s = i.getUserInput();
    return s;
  }
  
}
