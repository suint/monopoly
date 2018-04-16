package com.example.lib;

/**
 * Created by Kelly on 4/15/2018.
 */

public class Tiles {
  
  private String tileName;
  
  private double tileValue;
  //tile value is either a multiplier or a set value... if it's 1.x it's a multiplier, if it's a high number it's a set value
  private int tilePos;
  //tile position is just one number since the tiles are just consecutive
  
  
  public String getTileName() {
    return tileName;
  }
  
  public void setTileName(String tileName) {
    this.tileName = tileName;
  }
  
  public double getTileValue() {
    return tileValue;
  }
  
  public void setTileValue(double tileValue) {
    this.tileValue = tileValue;
  }
  
  public int getTilePos() {
    return tilePos;
  }
  
  public void setTilePos(int tilePos) {
    this.tilePos = tilePos;
  }
  
  protected Tiles(String name, double value, int pos) {
    setTileName(name);
    setTileValue(value);
    setTilePos(pos);
  }
  
  protected Tiles(){
    setTileName("null");
    setTileValue(0);
    setTilePos(0);
  }
  
}
