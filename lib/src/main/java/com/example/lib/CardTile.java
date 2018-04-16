package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class CardTile extends Tile {
  public Card[] cardlist;
  
  //when created generates random list of cards
  
  public CardTile(String name, int pos, String imgFile) {
    super(name, pos, imgFile);
    this.cardlist = makeCards();
  }
  
  private Card[] makeCards(){
    Card[] cards = new Card[10];
    for (int i = 0; i < 10; i++){
      cards[i] = new Card();
    }
    return cards;
  }
  
  //randomly draws a card, and updates the user based on the card drawn
  public void drawCard(int x) {
  
  }
}
