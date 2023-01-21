package counter;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CounterOrderedTest {

    private Counter counter = new Counter();

    @Test
    @Order(2)
    void testSingleTick() {
        counter.tick();
        assertThat(counter.getCount()).isEqualTo(1);
    }

    @Test
    @Order(1)
    void testThreeTicks() {
        counter.tick();
        counter.tick();
        counter.tick();
        assertThat(counter.getCount()).isEqualTo(3);
    }


    @Test
    @Order(3)
    void testTwoTicks() {
        counter.tick();
        counter.tick();
        assertThat(counter.getCount()).isEqualTo(2);
    }

}
