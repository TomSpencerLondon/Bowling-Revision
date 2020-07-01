package com.codurance;

public class Game {

  private int score;

  public void roll(int...rolls) {
    score = 0;
  }

  public int score() {
    return score;
  }
}
