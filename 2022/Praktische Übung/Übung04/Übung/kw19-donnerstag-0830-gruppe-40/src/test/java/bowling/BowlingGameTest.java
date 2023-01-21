package bowling;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.InstanceOfAssertFactories.THROWABLE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

  @Test
  @DisplayName("Wenn kein einziger Treffer erzielt wird, ist der Punktestand 0")
  void test_0(){
    BowlingGame game = new BowlingGame();
    game.roll(0,20);
    assertThat(game.score()).isEqualTo(0);
  }

  @Test
  @DisplayName("Rolle 20 x 4 erwarte Punktestand 80")
  void test_1(){
    BowlingGame game = new BowlingGame();
    game.roll(4,20);
    assertThat(game.score()).isEqualTo(80);
  }

  @Test
  @DisplayName("3 x 5 und 2 rollen. Erwarte 22")
  void test_3(){
    BowlingGame game = new BowlingGame();
    game.roll(5,3);
    game.roll(2);
    assertThat(game.score()).isEqualTo(22);
  }


  @Test
  @DisplayName("4 x 5 und 2 rollen. Erwarte 29")
  void test_4(){
    BowlingGame game = new BowlingGame();
    game.roll(5,4);
    game.roll(2);
    assertThat(game.score()).isEqualTo(29);
  }

  @Test
  @DisplayName("Strike gefolgt von 2 x 4 und Ergebnis soll 26 sein")
  void test_6(){
    BowlingGame game = new BowlingGame();
    game.roll(10);
    game.roll(4,2);
    assertThat(game.score()).isEqualTo(26);
  }
  @Test
  @DisplayName("werfe 22 *2 erwarte 40 punkte")
  void test_7(){
    BowlingGame game = new BowlingGame();
    game.roll(2,22);
    assertThat(game.score()).isEqualTo(40);
  }
@Test
  @DisplayName("perfect game")
  void test_8(){
    BowlingGame game = new BowlingGame();
    game.roll(10,12);
    assertThat(game.score()).isEqualTo(300);
  }

  @Test
  @DisplayName("Illegale Eingabe Negative Zahlen")
  void test_9(){
    BowlingGame game = new BowlingGame();
    Throwable thrown = catchThrowable(() ->game.roll(-1));
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessage("Üngültige Wurf");
  }

  @Test
  @DisplayName("Illegale Eingabe größer 10 Zahlen")
  void test_10(){
    BowlingGame game = new BowlingGame();
    Throwable thrown = catchThrowable(() ->game.roll(11));
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessage("Üngültige Wurf");
  }

  @Test
  @DisplayName("Ein Frame hat nicht mehr als 10 pins")
  void test_11(){
    BowlingGame game = new BowlingGame();
    Throwable thrown = catchThrowable(() ->game.roll(6, 2));
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessage("Man kann nicht mehr als 10 Pins per Frame umwerfen");
  }

}
