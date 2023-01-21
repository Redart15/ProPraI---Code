package lotto;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  void test_assertions(){
    List<Integer> lottoZahlen = Ziehungsgeraet.lottoZahlenZiehen();
    assertThat(lottoZahlen).isNotNull();
    // Schreiben Sie hier Ihre Assertions
  }

}
