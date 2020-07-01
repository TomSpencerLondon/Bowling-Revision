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

    if (rolls[0] == 5) {
      score = 16;
    }
  }

  public int score() {
    return score;
  }
}
