package com.example.lib;

import javax.smartcardio.Card;

/**
 * Created by Kelly on 4/16/2018.
 */

public class CardTile extends Tile {
  public enum CardStack {
    COMMUNITYCHEST, CHANCE
  } //which type of stack of cards
  
  public String[] cardList;
  public CardStack type;
  
  //when created generates random list of cards
  
  public CardTile(String name, int pos, String imgFile, CardStack c) {
    super(name, pos, imgFile);
    this.type = c;
    this.cardList = makeCards();
  }
  
  private String[] makeCards(){
    String[] cards = new String[14];
    if (type == CardStack.CHANCE){
      cards[1] = "goback3";
      cards[2] = "poortax15";
      cards[3] = "advtogo";
      cards[4] = "avdtoutil";
      cards[5] = "bankpays50";
      cards[6] = "gotoillav";
      cards[7] = "gotostc";
      cards[8] = "getoutofjail";
      cards[9] = "gotojail";
      cards[10] = "makerepairs";
      cards[11] = "gotoboardwalk";
      cards[12] = "chairman";
      cards[13] = "building150";
      cards[14] = "crossword100";
    } else if (type == CardStack.COMMUNITYCHEST){
      cards[1] = "advtogo";
      cards[2] = "bankerror200";
      cards[3] = "dr50";
      cards[4] = "stock50";
      cards[5] = "getoutofjail";
      cards[6] = "gotojail";
      cards[7] = "operacollect50";
      cards[8] = "holiday100";
      cards[9] = "refund20";
      cards[10] = "bday10";
      cards[11] = "hosp100";
      cards[12] = "school150";
      cards[13] = "inherit100";
      cards[14] = "repairs40-115";
    }
    
    return cards;
  }
  
  //randomly draws a card, and updates the user based on the card drawn
  public String drawCard(int x) {
    String a = cardList[x];
    return a;
  }
}
