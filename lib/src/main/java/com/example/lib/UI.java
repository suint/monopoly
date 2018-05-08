
package com.example.lib;

import java.util.Scanner;

/**
 * Created by Kelly on 4/16/2018.
 */

public class UI implements Interaction{
  
  Scanner sc = new Scanner(System.in);
  Board board = new Board();
  
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
  public boolean findEnd(){
    boolean a = false;
    for (int i = 0; i < board.getGamePlayers().size(); i++){
      if (board.getPlayer(i).lose() == true){
        a = true;
      }
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