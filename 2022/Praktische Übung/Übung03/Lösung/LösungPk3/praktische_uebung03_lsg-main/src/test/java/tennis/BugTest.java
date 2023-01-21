package tennis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BugTest {

  @Test
  @DisplayName("Bug Spiel mit gleichen Playernamen wird abgelehnt")
  void test_bug1() {
    // Obwohl das vermutlich tasächlich gut möglich wäre ...
    assertThrows(IllegalArgumentException.class,
        () -> new TennisGame("Flash", "Flash"));
  }

  @Test
  @DisplayName("Bug Spiel soll immer den gleichen Score anzeigen, nachdem es gewonnen wurde")
  void test_bug2() {
    TennisGame game = new TennisGame("Alfred", "Bruce");
    game.player1Score = 3;
    game.player2Score = 4;
    game.point("Bruce"); // Sieg für Bruce
    game.point("Alfred"); // Immer noch Sieg für Bruce
    assertThat(game.score()).isEqualTo("Game Bruce");
  }

  @Test
  @DisplayName("Bug Vorteil Player 1 wird angesagt")
  void test_5() {
    TennisGame game = new TennisGame("Alfred", "Bruce");
    game.player1Score = 4;
    game.player2Score = 3;
    assertThat(game.score()).isEqualTo("Advantage Alfred");
  }

  @Test
  @DisplayName("Bug Vorteil Player 2 wird angesagt")
  void test_6() {
    TennisGame game = new TennisGame("Alfred", "Bruce");
    game.player1Score = 3;
    game.player2Score = 4;
    assertThat(game.score()).isEqualTo("Advantage Bruce");
  }



}
