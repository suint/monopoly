package com.example.lib;
import java.util.Scanner;

/**
 * Created by Kelly on 4/16/2018.
 */

public class UI implements Interaction {
  
  Scanner sc = new Scanner(System.in);
  
  @Override
  public void updateUI(Tiles[] tiles, Player[] players) {
    System.out.println("board");
  }
  
  @Override
  public void showIntro() {
    System.out.println("How 2 Play:");
    System.out.println("[info here]");
  }
  
  @Override
  public String getUserInput() {
    return sc.next();
  }
  
  @Override
  public int rollDice() {
    return 2; //
  }
  
  @Override
  public void showEnd() {
    System.out.println("someone won and the other ones lost");
  }
}
