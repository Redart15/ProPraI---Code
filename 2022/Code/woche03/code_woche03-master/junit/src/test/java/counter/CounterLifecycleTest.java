package counter;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CounterLifecycleTest {

    private Counter counter = new Counter();

    @Test
    @Order(1)
    void testSingleTick() {
        counter.tick();
        assertThat(counter.getCount()).isEqualTo(1);
    }


    @Test
    @Order(2)
    void testTwoTicks() {
        // Verwendet den gleichen Counter!
        counter.tick();
        counter.tick();
        assertThat(counter.getCount()).isEqualTo(3);
    }


}
