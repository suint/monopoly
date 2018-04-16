package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class CardTiles extends Tiles {
  public Card[] cardlist;
  
  //when created generates random list of cards
  
  
  public CardTiles(String name, double value, int pos, Card[] cardlist) {
    super(name, value, pos);
    this.cardlist = cardlist;
  }
  
  //randomly draws a card, and update the user based on the card drawn
  public void drawCard(int x) {}
}
