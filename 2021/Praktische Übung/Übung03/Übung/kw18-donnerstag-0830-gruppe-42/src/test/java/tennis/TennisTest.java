package tennis;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TennisTest {
    private static TennisGame game(){
        TennisGame game = new TennisGame("p1", "p2");
        return game;
    }

    @DisplayName("Point Test p1: erhoeht die Punkte")
    @Test
    void test_point1(){
        TennisGame game = game();
        game.point("p1");
        assertThat(game.player1Score).isEqualTo(1);
    }
    @DisplayName("Point Test p2: erhoeht die Punkte")
    @Test
    void test_point2(){
        TennisGame game = game();
        game.point("p2");
        assertThat(game.player2Score).isEqualTo(1);
    }

    @DisplayName("Deuce richtige Ausgabe")
    @Test
    void test_Deuce(){
        TennisGame game = game();
        game.player1Score = 4;
        game.player2Score = 4;
        String score = game.score();
        assertThat(score).isEqualTo("Deuce");

    }

    @Test
    @DisplayName("Player1 gewinnt")
    void test_p1_wins(){
        TennisGame game = game();
        game.player1Score = 4;
        game.player2Score = 2;
        String score = game.score();
        assertThat(score).isEqualTo("Game" + " p1");

    }

    @Test
    @DisplayName("Player2 gewinnt")
    void test_p2_wins(){
        TennisGame game = game();
        game.player1Score = 2;
        game.player2Score = 4;
        String score = game.score();
        assertThat(score).isEqualTo("Game" + " p2");

    }

    @Test
    @DisplayName("Player1 Advantage")
    void test_p1_advantage(){
        TennisGame game = game();
        game.player1Score = 5;
        game.player2Score = 4;
        String score = game.score();
        assertThat(score).isEqualTo("Advantage" + " p1");

    }

    @Test
    @DisplayName("Player2 Advantage")
    void test_p2_advantage(){
        TennisGame game = game();
        game.player1Score = 5;
        game.player2Score = 6;
        String score = game.score();
        assertThat(score).isEqualTo("Advantage" + " p2");

    }

    @Test
    @DisplayName("Test Love-All")
    void test_loveAll(){
        TennisGame game = game();
        String score = game.score();
        assertThat(score).isEqualTo("Love-All");
    }

    @Test
    @DisplayName("Test Thirty-Fifteen")
    void test_someScore(){
        TennisGame game = game();
        game.player1Score = 2;
        game.player2Score = 1;
        String score = game.score();
        assertThat(score).isEqualTo("Thirty-Fifteen");
    }

    @Test
    @DisplayName("Test Fourty-All")
    void test_someotherScore(){
        TennisGame game = game();
        game.player1Score = 3;
        game.player2Score = 3;
        String score = game.score();
        assertThat(score).isEqualTo("Fourty-All");
    }

    @Test
    @DisplayName("Gleiche Spieler")
    void test_samePlayer(){
        Throwable thrown = catchThrowable(() -> new TennisGame("p1", "p1"));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessage("Gleiche Spieler");
    }

    @Test
    @DisplayName("Spiel endet")
    void game_end(){
        TennisGame game = game();
        game.player1Score = 5;
        game.player2Score = 4;
        game.point("p1");
        game.point("p1");
        game.point("p2");
        assertThat(game.player1Score).isEqualTo(6);
        assertThat(game.player2Score).isEqualTo(4);
    }
}
