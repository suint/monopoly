package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class PropertyTiles extends Tiles {
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
  
  @Override
  public double getTileValue(){
    return 0; //would override default tile value by calculating based on property price and num houses owned
  }
  
  public void setNumHouses(int num){
    this.numHouses = 0;
  }
  
  public int getNumHouses(){
    return numHouses;
  }
  
  public PropertyTiles(String name, double value, int pos, int numHouses, String ownerID, int propertyVal) {
    super(name, value, pos);
    this.numHouses = numHouses;
    this.ownerID = ownerID;
    this.propertyVal = propertyVal;
  }
  
  public PropertyTiles() {
    this.numHouses = 0;
    this.ownerID = "";
    this.propertyVal = 0;
  }
}
