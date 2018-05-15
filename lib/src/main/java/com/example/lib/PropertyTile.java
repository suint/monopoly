package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class PropertyTile extends Tile {
  private int numHouses;
  
  public int getNumHouses(){
    return numHouses;
  }

  public PropertyTile(){
    numHouses = 0;
    this.setOwnable(true);
  }
  
  public PropertyTile(String name, int posx, int posy, int numHouses, int id, int t) {
    super(name, posx, posy, t);
    this.numHouses = numHouses;
    this.setOwnable(true);
  }
  
  public PropertyTile(String name, int posx, int posy, int p) {
    super(name, posx, posy, p);
    this.numHouses = 0;
    this.setOwnable(true);
  }
  
  public String tileAction(Interaction i, int player){
    //essentially "buy" function
    //when used in getRent, returns rent on tile
    String s = "";
    int otherPlayer = 0;
    if (player == 1) {
      otherPlayer = 2;
    } else if (player == 2) {
      otherPlayer = 1;
    }
    
    if (this.getOwnable()) {
      this.numHouses++;
      this.setOwnerID(player);
      this.setOwnable(false);
    } //once bought cannot change hands
    
    int rent = 0;
    String tileName = i.getBoard().getGameTiles()[i.getBoard().getPlayer(player).getPlayerPos()].getTileName();
    switch (tileName) {
      case "Mediterranean Avenue":
      case "Baltic Avenue":
        if (i.getBoard().getGameTiles()[1].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[3].getOwnerID() == otherPlayer) { //check for monopoly
          rent = 40;
        } else {
          rent = 20;
        }
        break;
      case "Reading Railroad":
      case "Short Line":
        int numRR = 0;
        for (int j = 5; j < 46; j += 10) {
          if (i.getBoard().getGameTiles()[j].getOwnerID() == otherPlayer) {
            numRR++;
          }
        }
        switch (numRR) {
          case 1:
            rent = 25;
            break;
          case 2:
            rent = 50;
            break;
          case 3:
            rent = 100;
            break;
          case 4:
            rent = 200;
            break;
        }
        break;
      case "Oriental Avenue":
      case "Vermont Avenue":
      case "Connecticut Avenue":
        if (i.getBoard().getGameTiles()[6].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[8].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[9].getOwnerID() == otherPlayer) {
          rent = 80;
        } else {
          rent = 40;
        }
        break;
      case "St. Charles Place":
      case "States Avenue":
      case "Virginia Avenue":
        if (i.getBoard().getGameTiles()[11].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[13].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[14].getOwnerID() == otherPlayer) {
          rent = 100;
        } else {
          rent = 50;
        }
        break;
      case "St. James Place":
      case "Tennessee Avenue":
      case "NY Avenue":
        if (i.getBoard().getGameTiles()[16].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[18].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[19].getOwnerID() == otherPlayer) {
          rent = 150;
        } else {
          rent = 75;
        }
        break;
      case "KY Avenue":
      case "IN Avenue":
      case "IL Avenue":
        if (i.getBoard().getGameTiles()[21].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[23].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[24].getOwnerID() == otherPlayer) {
          rent = 200;
        } else {
          rent = 100;
        }
        break;
      case "Atlantic Avenue":
      case "Ventnor Avenue":
      case "Marvin Gardens":
        if (i.getBoard().getGameTiles()[26].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[27].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[29].getOwnerID() == otherPlayer) {
          rent = 220;
        } else {
          rent = 110;
        }
        break;
      case "Pacific Ave":
      case "N Carolina Ave":
      case "Pennsylvania Ave":
        if (i.getBoard().getGameTiles()[31].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[32].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[34].getOwnerID() == otherPlayer) {
          rent = 280;
        } else {
          rent = 140;
        }
        break;
      case "Park Place":
      case "Boardwalk":
        if (i.getBoard().getGameTiles()[37].getOwnerID() == otherPlayer && i.getBoard().getGameTiles()[39].getOwnerID() == otherPlayer) {
          rent = 400;
        } else {
          rent = 200;
        }
        break;
    }
        
    
    s += rent;
    return s;
    
    /*
    String s = "no";
    String a = "";
    PropertyTile x = (PropertyTile)i.getBoard().getGameTiles()[i.getBoard().getGamePlayers().get(player).getPlayerPos()];
    int owned = x.getNumHouses();
    int price = x.getTileValue();
    if (owned == -1) {
      System.out.println("You have landed on a property tile. Would you like to purchase this property that is worth " + price);
      s = i.getUserInput();
      if (s.equals("yes")) {
        x.setOwnerID(i.getBoard().getGamePlayers().get(player).getUserID());
        i.getBoard().getGamePlayers().get(player).addMoney(0 - price);
        x.addHouse();
      } else if (s.equals("no")) {
      
      }
    } else if (owned == 0) {
      if(x.getOwnerID()!=i.getBoard().getGamePlayers().get(player).getUserID())
        i.getBoard().getGamePlayers().get(player).addMoney((int)(0 - price*0.5));
      //fill in else; aka prompt users to build houses or not; optional
    }

    return a;*/
  }
  
}
