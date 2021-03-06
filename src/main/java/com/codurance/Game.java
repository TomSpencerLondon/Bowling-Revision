package com.codurance;

public class Game {

  private static final int START_SCORE = 0;
  private static final int START_POSITION = 0;
  private int score;
  private int currentPosition;


  private int roll = 0;
  private int[] rolls = new int[21];

  public Game() {
    this.score = START_SCORE;
    this.currentPosition = START_POSITION;
  }

  public void roll(int... rolls) {
    for (int toppled : rolls) {
      roll(toppled);
    }
  }

  private void roll(int toppled) {
    rolls[roll++] = toppled;
  }

  public int score() {
    for (int frame = 0; frame < 10; frame++) {
      if (isStrike(currentPosition)) {
        score += 10 + rolls[currentPosition + 1] + rolls[currentPosition + 2];
        currentPosition++;
      } else if (isSpare(currentPosition)) {
        score += 10 + rolls[currentPosition + 2];
        currentPosition += 2;
      } else {
        score += rolls[currentPosition] + rolls[currentPosition + 1];
        currentPosition += 2;
      }
    }
    return score;
  }

  private boolean isSpare(int currentPosition) {
    return rolls[currentPosition] + rolls[currentPosition + 1] == 10;
  }

  private boolean isStrike(int currentPosition) {
    return rolls[currentPosition] == 10;
  }

  public boolean play(String input) {
    if(input.equals("e")){
      return false;
    }

    char[] chars = input.replaceAll("[\\|]", "").toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '-') {
        roll(0);
      }else if(chars[i] == '/'){
        roll(10 - Integer.parseInt(String.valueOf(chars[i - 1])));
      } else if (chars[i] == 'X') {
        roll(10);
      } else {
        roll(Integer.parseInt(String.valueOf(chars[i])));
        Integer.parseInt(String.valueOf(chars[i]));
      }
    }

    return true;
  }
}
