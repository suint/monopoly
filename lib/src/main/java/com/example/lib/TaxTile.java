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
  
  public TaxTile(String name, int posx, int posy, int t) {
    super(name, posx, posy, t);
  }
  
  public String tileAction(Interaction i, int player){
   return super.tileAction(i, player);

  }
}
