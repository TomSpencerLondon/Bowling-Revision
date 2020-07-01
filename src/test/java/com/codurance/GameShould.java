package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameShould {

  private Game game;

  @BeforeEach
  void setUp() {
    game = new Game(0);
  }

  @Test
  void can_score_gutter_game() {
    game.roll(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    assertEquals(0, game.score());
  }

  @Test
  void can_score_game_of_ones() {
    game.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    assertEquals(20, game.score());
  }
}
