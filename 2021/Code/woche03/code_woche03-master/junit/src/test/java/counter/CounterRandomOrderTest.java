package counter;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Random.class)
public class CounterRandomOrderTest {

    private Counter counter = new Counter();

    @Test
    void testSingleTick() {
        counter.tick();
        assertThat(counter.getCount()).isEqualTo(1);
    }

    @Test
    void testThreeTicks() {
        counter.tick();
        counter.tick();
        counter.tick();
        assertThat(counter.getCount()).isEqualTo(3);
    }


    @Test
    void testTwoTicks() {
        counter.tick();
        counter.tick();
        assertThat(counter.getCount()).isEqualTo(2);
    }

}
