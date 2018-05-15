package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class TaxTile extends Tile {
  
  public TaxTile(String name, int posx, int posy, int t) {
    super(name, posx, posy, t);
  }
  
  public String tileAction(Interaction i, int player){
    i.getBoard().getPlayer(player).addMoney(this.getTileValue());
    String s = Math.abs(this.getTileValue()) + "";
    return s;
  
  }
}
