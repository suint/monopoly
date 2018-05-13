package com.example.lib;

import java.util.Random;

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
  
  public CardTile(String name, int posx, int posy, CardStack c, int v) {
    super(name, posx, posy, v);
    this.type = c;
    this.cardList = makeCards();
  }
  
  public CardTile(){
    super("a", 0,0,1);
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

  public String tileAction(Interaction i, int player) {
    int roll = new Random().nextInt(14) ;
    String s = cardList[roll];
    if (this.type == CardStack.CHANCE) {
      s += "#C";
    } else if (this.type == CardStack.COMMUNITYCHEST) {
      s +="#CC";
    }
    return s;
  }
}
