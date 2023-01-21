package tennis;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TennisTest {

  TennisGame game = new TennisGame("Alfred", "Bruce");

  @Test
  @DisplayName("Anfänglichen Gleichstand testen")
  void test_1() {
    assertThat(game.score()).isEqualTo("Love-All");
  }

  @Test
  @DisplayName("Player 1 kann Punkte machen")
  void test_2() {
    game.point("Alfred");
    game.point("Alfred");
    assertThat(game.player1Score).isEqualTo(2);
  }

  @Test
  @DisplayName("Player 2 kann Punkte machen")
  void test_3() {
    game.point("Bruce");
    game.point("Bruce");
    assertThat(game.player2Score).isEqualTo(2);
  }

  @Test
  @DisplayName("Deuce wird angesagt")
  void test_4() {
    game.player1Score = 7;
    game.player2Score = 7;
    assertThat(game.score()).isEqualTo("Deuce");
  }

  @Test
  @DisplayName("Vorteil Player 1 wird angesagt")
  void test_5() {
    game.player1Score = 5;
    game.player2Score = 4;
    assertThat(game.score()).isEqualTo("Advantage Alfred");
  }

  @Test
  @DisplayName("Vorteil Player 2 wird angesagt")
  void test_6() {
    game.player1Score = 4;
    game.player2Score = 5;
    assertThat(game.score()).isEqualTo("Advantage Bruce");
  }

  @Test
  @DisplayName("Sieg für Player 1")
  void test_7() {
    game.player1Score = 8;
    game.player2Score = 6;
    assertThat(game.score()).isEqualTo("Game Alfred");
  }

  @Test
  @DisplayName("Sieg für Player 2")
  void test_8() {
    game.player1Score = 4;
    game.player2Score = 6;
    assertThat(game.score()).isEqualTo("Game Bruce");
  }

  @Test
  @DisplayName("Fifteen-Love wird angesagt")
  void test_9() {
    game.player1Score = 1;
    assertThat(game.score()).isEqualTo("Fifteen-Love");
  }

  @Test
  @DisplayName("Thirty-Love wird angesagt")
  void test_10() {
    game.player1Score = 2;
    assertThat(game.score()).isEqualTo("Thirty-Love");
  }
  @Test
  @DisplayName("Fourty-Love wird angesagt")
  void test_11() {
    game.player1Score = 3;
    assertThat(game.score()).isEqualTo("Fourty-Love");
  }

  @Test
  @DisplayName("Love-Fourty wird angesagt")
  void test_12() {
    game.player2Score = 3;
    assertThat(game.score()).isEqualTo("Love-Fourty");
  }




}
