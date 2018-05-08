package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class PropertyTile extends Tile {
  private int numHouses;
  private int ownerID;
  private int tileValue;
  private boolean owned;
  
  public int getOwnerID() {
    return ownerID;
  }
  
  public void setOwnerID(int ownerID) {
    this.ownerID = ownerID;
  }
  
  public int gettileValue() {
    return tileValue;
  }
  
  public void buyProperty(int id){
    this.ownerID = id;
  }
  
  public void buyHouse(){
    this.numHouses++;
  }
  
  public void setNumHouses(int num){
    this.numHouses = 0;
  }
  
  public int getNumHouses(){
    return numHouses;
  }


  public PropertyTile(String name, int posx, int posy, int numHouses, int ownerID, int t) {
    super(name, posx, posy, t);
    this.numHouses = numHouses;
    this.ownerID = ownerID;
  }
  
  public PropertyTile(String name, int posx, int posy, int p) {
    super(name, posx, posy, p);
    this.numHouses = 0;
    this.ownerID = 0;
  }
  
  public String tileAction(Interaction i, int player){
    String s = "";
    PropertyTile x = (PropertyTile)i.getBoard().getGameTiles()[i.getBoard().getGamePlayers().get(player).getPlayerPos()];
    int owned = x.getNumHouses();
    int price = x.getTileValue();
    if(owned==-1) {
      System.out.println("You have landed on a property tile. Would you like to purchase this property that is worth " + price);
      s = i.getUserInput();
      if (s.equals("yes")) {
        x.setOwnerID(i.getBoard().getGamePlayers().get(player).getUserID()+1);
        i.getBoard().getGamePlayers().get(player).addMoney(0 - price);
        x.setNumHouses(0);
      }
    }
    else if(owned==0) {
      if(x.getOwnerID()!=i.getBoard().getGamePlayers().get(player).getUserID())
        i.getBoard().getGamePlayers().get(player).addMoney((int)(0 - price*0.5));
      //fill in else; aka prompt users to build houses or not; optional
    }

    return s;
  }
  
}
