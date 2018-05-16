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
  //position for players on that tile
  private int tilePosx;
  private int tilePosy;
  //varies depending on type of tile
  private int tileValue;
  //id of player owning
  private int ownerID;
  //whether it's been bought, false if not property tile
  private boolean ownable;
  
  public int getOwnerID() {
    return ownerID;
  }
  
  public void setOwnerID(int ownerID) {
    this.ownerID = ownerID;
  }
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
  
  public void setOwnable(boolean o){this.ownable = o;}
  
  public boolean getOwnable(){return ownable;}
  
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
    this.ownable = false;
    this.ownerID = 0;
  }
  
  protected Tile(){
    this.tileName = "null";
    setTilePos(0, 0, 0);
    this.ownerID = 0;
  }
  
  public String tileAction(Interaction i, int player){
    String s = "You have landed on " + tileName + ".";
    
    //go to jail tile
    if(i.getBoard().getGameTiles()[i.getBoard().getPlayer(player).getPlayerPos()].getTileName().equals("Go To Jail")
            &&  i.getBoard().getPlayer(player).hasJailCard()==false) {
      i.getBoard().getPlayer(player).setInJail(true);
      i.getBoard().getPlayer(player).setPlayerPos(10);
    } else {
      int price = this.tileValue;
      i.getBoard().getGamePlayers().get(player).addMoney(price);
    }
    return s;
  }
  
}