package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class CardTile extends Tile {
  public enum CardStack {
    COMMUNITYCHEST, CHANCE
  } //which type of stack of cards
  
  public String[] cardlist;
  public CardStack type;
  
  //when created generates random list of cards
  
  public CardTile(String name, int pos, String imgFile, CardStack c) {
    super(name, pos, imgFile);
    this.type = c;
    this.cardlist = makeCards();
  }
  
  private String[] makeCards(){
    String[] cards = new String[16];
    if (type == CardStack.CHANCE){
      cards[1] = "";
    }
    
    return cards;
  }
  
  //randomly draws a card, and updates the user based on the card drawn
  public String drawCard(int x) {
    String a = cardlist[x];
    return a;
  }
}
