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
  
  private String tileName;
  
  private int tilePosx;
  private int tilePosy;
  private int tileValue;
  //tile position is just one number since the tiles are just consecutive
  
  
  public String getTileName() {
    return tileName;
  }
  
  public void setTileName(String tileName) {
    this.tileName = tileName;
  }
  
  public int getTilePosx() {
    return tilePosx;
  }

  public int getTilePosy() {
    return tilePosy;
  }

  public int getTileValue() {
    return tileValue;
  }

  public void setTileValue(int tileValue) {
    this.tileValue = tileValue;
  }
  
  public void setTilePos(int tilePosx, int tilePosy, int v) {
    this.tilePosx = tilePosx;
    this.tilePosy = tilePosy;
    this.tileValue = v;
  }
  
  protected Tile(String name, int posx, int posy, int v) {
    this.tileName = name;
    this.tilePosx = posx;
    this.tilePosy = posy;
    this.tileValue = v;

    //System.out.println(getTileFace());
  }
  
  protected Tile(){
    setTileName("null");
    setTilePos(0, 0, 0);
  }

  public String tileAction(Interaction i, int player){
    System.out.println("You have landed on " + tileName + ".");
    int price = this.tileValue;
    i.getBoard().getGamePlayers().get(player).addMoney(price);
    String s = "tile";
    return s;
  }
  
}