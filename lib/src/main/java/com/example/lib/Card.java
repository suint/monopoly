package com.example.lib;

/**
 * Created by Kelly on 4/16/2018.
 */

public class Card {
  public String cardName;
  
  //since the card's effect is based on the name, it can do a lot of different things ex send current player to jail
  //name is randomized when card is created
  public Card(){
    this.cardName = "sdfgsdf";
  }
  //https://monopolyguide.com/traditional/monopoly-list-of-chance-cards-main-version/
  //https://monopolyguide.com/traditional/monopoly-list-of-community-chest-cards-main-version/
  
  public void useCard(String name){
    if (name == "event"){
      System.out.println("an event occurred");
    }
  }
}
