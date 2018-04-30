package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class PropertyTile extends Tile {
  private int numHouses;
  private String ownerID;
  private int propertyVal;
  
  public String getOwnerID() {
    return ownerID;
  }
  
  public void setOwnerID(String ownerID) {
    this.ownerID = ownerID;
  }
  
  public int getPropertyVal() {
    return propertyVal;
  }
  
  public void setPropertyVal(int propertyVal) {
    this.propertyVal = propertyVal;
  }
  
  public void buyProperty(String id){
    this.ownerID = id;
  }
  
  public void buyHouse(){
    this.numHouses++;
  }
  
  public double getTileValue(){
    return 0; //finds tile value by calculating based on property price and num houses owned
  }
  
  public void setNumHouses(int num){
    this.numHouses = 0;
  }
  
  public int getNumHouses(){
    return numHouses;
  }
  
  public PropertyTile(String name, int pos, String imgFile, int numHouses, String ownerID, int propertyVal) {
    super(name, pos, imgFile);
    this.numHouses = numHouses;
    this.ownerID = ownerID;
    this.propertyVal = propertyVal;
  }
  
  public PropertyTile(String name, int pos, String imgFile, int p) {
    super(name, pos, imgFile);
    this.numHouses = 0;
    this.ownerID = "";
    this.propertyVal = p;
  }
  
  public void tileAction(){
    System.out.println("this is a property tile!");
  }
  
}
