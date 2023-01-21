package bowling;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

  private BowlingGame game = new BowlingGame();

  @Test
  @DisplayName("Wenn kein einziger Treffer erzielt wird, ist der Punktestand 0")
  void test_0(){
    rolls(20, 0);
    assertThat(game.score()).isEqualTo(0);
  }

  @Test
  @DisplayName("Wenn in jedem Wurf ein Kegel getroffen wird, ist der Punktestand 20")
  void test_1(){
    rolls(20, 1);
    assertThat(game.score()).isEqualTo(20);
  }

  @Test
  @DisplayName("Wenn mehr als 10 Kegel getroffen werden soll ein IllegalArguemtException geworfen werde")
  void test_2(){
    Throwable thrown = catchThrowable(() -> game.roll(11));
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessage("Die Anzahl der getroffenen Kegel muss zwischen -1 und 11 liegen");
  }

  @Test
  @DisplayName("Wenn weniger kein Kegel getroffen werden soll ein IllegalArguemtExsption geworfen werde")
  void test_3(){
    Throwable thrown = catchThrowable(() -> game.roll(-11));
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessage("Die Anzahl der getroffenen Kegel muss zwischen -1 und 11 liegen");
  }

  @Test
  @DisplayName("Wenn ein Spare gefolgt von drei und dann kein Kegel, ist der Punktestand 16")
  void test_4(){
    rolls(2, 5);
    rolls(1, 3);
    rolls(17, 0);
    assertThat(game.score()).isEqualTo(16);
  }

  @Test
  @DisplayName("Wenn ein Strike gefolgt von zwei Einsen und dann Nullen, ist der Punktestand 14")
  void test_5(){
    rolls(1, 10);
    rolls(2, 1);
    rolls(18, 0);
    assertThat(game.score()).isEqualTo(14);
  }

  @Test
  @DisplayName("Bei einem Perfectem Spiel ist der Punktestand 300")
  void test_6(){
    rolls(12, 10);
    assertThat(game.score()).isEqualTo(300);
  }


  private void rolls(int wurfAnzahl, int getroffeneKegel) {
    for (int i = 0; i < wurfAnzahl; i++) {
      game.roll(getroffeneKegel);
    }
  }

}
