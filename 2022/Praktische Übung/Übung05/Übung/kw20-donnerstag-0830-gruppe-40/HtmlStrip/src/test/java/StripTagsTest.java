import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StripTagsTest {

  @Test
  @DisplayName("Einfaches Entfernen der Tags funktioniert")
  void test_1() {
    String stripped =
        StripTags.removeTags("<p>Das ist ein Text, bei dem <b>alle</b> Tags entfernt wurden.</p>");
    assertThat(stripped).isEqualTo("Das ist ein Text, bei dem alle Tags entfernt wurden.");
  }

  @Test
  @DisplayName("Gequotete Tagsymbole werden ignoriert")
  void test_2() {
    String stripped =
        StripTags.removeTags("""
            <input type="text" value="<Enter Name>">""");
    assertThat(stripped).isEmpty();
  }

  @Test
  @DisplayName("Tags rund um Zitate werden entfernt")
  void test_3() {
    String stripped =
        StripTags.removeTags("""
            <p><it>"If debugging is the process of removing software bugs, then programming must be the process of putting them in."</it> Edsger Dijkstra</p>""");
    assertThat(stripped).isEqualTo("""
       "If debugging is the process of removing software bugs, then programming must be the process of putting them in." Edsger Dijkstra""");
  }

  @Test
  @DisplayName("Tags innerhalb eines Zitats werden entfernt")
  void test_4() {
    String stripped =
        StripTags.removeTags("""
            "<it>Debugging is twice as hard as writing the code in the first place. Therefore, if you write the code as cleverly as possible, you are, by definition, not smart enough to debug it.</it>", Brian Kernighan""");
    assertThat(stripped).isEqualTo("""
       "Debugging is twice as hard as writing the code in the first place. Therefore, if you write the code as cleverly as possible, you are, by definition, not smart enough to debug it.", Brian Kernighan""");
  }




}
