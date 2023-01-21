package counter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;


public class CounterTest {

    private Counter counter = new Counter();

    @Test
    void testSingleTick() {
        counter.tick();
        assertThat(counter.getCount()).isEqualTo(1);
    }


    @Test
    void testTwoTicks() {
        counter.tick();
        counter.tick();
        assertThat(counter.getCount()).isEqualTo(2);
    }


}
