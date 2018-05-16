
package com.example.lib;

import java.util.Scanner;

/**
 * Created by Kelly on 4/16/2018.
 */

public class UI implements Interaction{
  
  Scanner sc  = new Scanner(System.in);
  private Board board = new Board();
  
  @Override
  public void updateUI(Tile[] tiles, Player[] players) {
    System.out.println("board");
  }
  
  @Override
  public void showIntro() {
    System.out.println("How 2 Play:");
    System.out.println("[info here]");
  }
  
  @Override
  public String getUserInput() {
    String s = sc.next()+sc.nextLine();
    return s;
  }
  
  @Override
  public void addPlayer(Player p){
    board.addPlayer(p);
  }
  
  @Override
  public void addTile(Tile t, int a){
    board.addTile(t, a);
  }
  
  @Override
  public void initializeBoard(Board b){
    this.board = b;
  }
  
  @Override
  public int findEnd() {
    int a = 0;
    if (board.getPlayer(1).lose()) {
      a = 2;
    } else if (board.getPlayer(2).lose()) {
      a = 1;
    }
    return a;
  }
  
  @Override
  public void showEnd() {
    System.out.println("someone won and the other ones lost");
  }
  
  @Override
  public Board getBoard(){
    return board;
  }
  
}