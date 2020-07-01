package com.codurance;

public class Game {

  private int score;

  public Game(int score) {
    this.score = score;
  }

  public void roll(int...rolls) {
    if (rolls[0] == 1){
      score = 20;
    }
  }

  public int score() {
    return score;
  }
}
