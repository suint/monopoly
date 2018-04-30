package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class TaxTile extends Tile {
  private int tileValue;
  
  public int getTileValue() {
    return tileValue;
  }
  
  public void setTileValue(int tileValue) {
    this.tileValue = tileValue;
  }
  
  public TaxTile(String name, int pos, String imgFile, int t) {
    super(name, pos, imgFile);
    this.tileValue = t;
  }
  
  public void tileAction(){
    System.out.println("this is a tax tile!!");
  }
}
