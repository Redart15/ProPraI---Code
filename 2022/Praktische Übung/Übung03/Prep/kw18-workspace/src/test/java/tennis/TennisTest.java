package tennis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TennisTest {

    private final TennisGame test = new TennisGame("PlayerOne","PlayerTwo");

    // 1
    @DisplayName("Ob Score richtig gesetzt wird")
    @Test
    void test_setter(){
        test.player1Score = 4;
        int test_score = test.player1Score;
        assertThat(test_score).isEqualTo(4);
    }

    // 2
    @DisplayName("Ob Score richtig upgedated wird")
    @Test
    void test_point(){
        test.point("PlayerOne");
        int added_score = test.player1Score;
        assertThat(added_score).isEqualTo(1);
    }

    // 3
    @DisplayName("Ob bei Score 40:40 , \"Deuce\" ausgegeben wird")
    @Test
    void test_deuce(){
        test.player1Score = 4;
        test.player2Score = 4;
        String deuce = test.score();
        assertThat(deuce).isEqualTo("Deuce");
    }

    // 4
    @DisplayName("Ob bei Score 40:0 , \"Game PlayerOne\" ausgegeben wird")
    @Test
    void test_PlayerOneWins(){
        test.player1Score = 4;
        String winPlayerOne = test.score();
        assertThat(winPlayerOne).isEqualTo("Game PlayerOne");
    }

    // 5
    @DisplayName("Ob bei Score 0:40 , \"Game PlayerTwo\" ausgegeben wird")
    @Test
    void test_JackWins(){
        test.player2Score = 4;
        String winJack = test.score();
        assertThat(winJack).isEqualTo("Game PlayerTwo");
    }

    // 6
    @DisplayName("Ob bei Point 5:4, \"Advantage PlayerOne\" ausgegeben wird")
    @Test
    void test_advPlayerOne(){
        test.player1Score = 5;
        test.player2Score = 4;
        String advPlayerOne = test.score();
        assertThat(advPlayerOne).isEqualTo("Advantage PlayerOne");
    }

    // 7
    @DisplayName("Ob bei Point 6:7 , \"Advantage PlayerTwo\" ausgegeben wird")
    @Test
    void test_advJack(){
        test.player1Score = 6;
        test.player2Score = 7;
        String advJack = test.score();
        assertThat(advJack).isEqualTo("Advantage PlayerTwo");
    }

    // 8
    @DisplayName("Ob bei inital Zustand \"Love-All\" ausgegeben wird")
    @Test
    void test_properInit(){
        String love_all = test.score();
        assertThat(love_all).isEqualTo("Love-All");
    }

    // 9
    @DisplayName("Ob bei Score 15:15 \"Fifteen-All\" ausgegeben wird")
    @Test
    void test_fiftenAll(){
        test.player1Score = 1;
        test.player2Score = 1;
        String love_all = test.score();
        assertThat(love_all).isEqualTo("Fifteen-All");
    }

    // 10
    @DisplayName("Ob bei Score 30:15 \"Thirty-Fifteen\" ausgegeben wird")
    @Test
    void test_someScore(){
        test.player1Score = 2;
        test.player2Score = 1;
        String someScore = test.score();
        assertThat(someScore).isEqualTo("Thirty-Fifteen");
    }
}
