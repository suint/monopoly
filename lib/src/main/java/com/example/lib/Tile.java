package com.example.lib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Created by Kelly on 4/15/2018.
 */

public class Tile {
  //http://allaboutfunandgames.com/wp-content/uploads/2012/02/Monopoly-Board.jpg
  
  private BufferedImage tileFace; //stores picture of tile
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
  
  public BufferedImage getTileFace() {
    return tileFace;
  }
  
  public void setTileFace(BufferedImage img) {
    this.tileFace = tileFace;
  }
  
  protected Tile(String name, int pos, String imgFile) {
    setTileName(name);
    setTilePos(pos);
    try{
      BufferedImage img = ImageIO.read(new File(imgFile));
      setTileFace(img);
    } catch (IOException e) {
    
    }
  }
  
  protected Tile(){
    setTileName("null");
    setTilePos(0);
  }
  
  public void tileAction(){
    System.out.println("this is a tile");
  }
  
}
