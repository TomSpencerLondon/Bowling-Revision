package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameShould {

  private Game game;

  @BeforeEach
  void setUp() {
    game = new Game();
  }

  @Test
  void can_score_gutter_game() {
    game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
    assertEquals(0, game.score());
  }

  @Test
  void can_score_game_of_ones() {
    game.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    assertEquals(20, game.score());
  }

  @Test
  void can_score_spare_followed_by_three() {
    game.roll(5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    assertEquals(16, game.score());
  }

  @Test
  void can_score_strike_followed_by_three_then_three() {
    game.roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
    assertEquals(22, game.score());
  }

  @Test
  void can_score_perfect_game() {
    game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
    assertEquals(300, game.score());
  }

  @ParameterizedTest
  @CsvSource(value = {
      "--|--|--|--|--|--|--|--|--|--||, 0",
      "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||, 90",
      "11|11|11|11|11|11|11|11|11|11||, 20",
      "X|33|--|--|--|--|--|--|--|--||, 22",
      "X|X|X|X|X|X|X|X|X|X|X|X||, 300",
      "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5, 150",
      "X|7/|9-|X|-8|8/|-6|X|X|X||81, 167"
  })
  void can_score_from_string(String input, Integer result) {
    game.play(input);
    assertEquals(result, game.score());
  }
}
