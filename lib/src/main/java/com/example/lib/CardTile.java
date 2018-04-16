package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class CardTile extends Tile {
  public Card[] cardlist;
  
  //when created generates random list of cards
  
  
  public CardTile(String name, int pos, String imgFile, Card[] cardlist) {
    super(name, pos, imgFile);
    this.cardlist = cardlist;
  }
  
  //randomly draws a card, and update the user based on the card drawn
  public void drawCard(int x) {}
}
