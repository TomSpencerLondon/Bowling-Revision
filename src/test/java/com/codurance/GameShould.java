package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameShould {

  @Test
  void can_score_gutter_game() {
    Game game = new Game();
    game.roll(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    assertEquals(0, game.score());
  }
}
