package com.example.lib;

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
      cards[0] = "goback3";
      cards[1] = "poortax15";
      cards[2] = "advtogo";
      cards[3] = "avdtoutil";
      cards[4] = "bankpays50";
      cards[5] = "gotoillav";
      cards[6] = "gotostc";
      cards[7] = "getoutofjail";
      cards[8] = "gotojail";
      cards[9] = "makerepairs";
      cards[10] = "gotoboardwalk";
      cards[11] = "chairman";
      cards[12] = "building150";
      cards[13] = "crossword100";
    } else if (type == CardStack.COMMUNITYCHEST){
      cards[0] = "advtogo";
      cards[1] = "bankerror200";
      cards[2] = "dr50";
      cards[3] = "stock50";
      cards[4] = "getoutofjail";
      cards[5] = "gotojail";
      cards[6] = "operacollect50";
      cards[7] = "holiday100";
      cards[8] = "refund20";
      cards[9] = "bday10";
      cards[10] = "hosp100";
      cards[11] = "school150";
      cards[12] = "inherit100";
      cards[13] = "repairs40-115";
    }
    
    return cards;
  }
  
  //randomly draws a card, and updates the user based on the card drawn
  public String drawCard(int x) {
    String a = cardList[x];
    return a;
  }
  
  public void tileAction(){
    System.out.println("this is a card tile");
  }
}
