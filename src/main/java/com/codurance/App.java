package com.codurance;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    System.out.println("Welcome to Brighton bowling!");
    Scanner scanner = new Scanner(System.in);
    Game game = new Game();
    boolean result;
    do  {
      System.out.println("Put in your scores (press e to exit): ");
      String input = scanner.nextLine();
      result = game.play(input);
      if(result){
        System.out.println(game.score());
        game = new Game();
      }
    }while(result);
  }
}
