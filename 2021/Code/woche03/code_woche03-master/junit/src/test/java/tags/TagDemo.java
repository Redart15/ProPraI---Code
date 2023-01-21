package tags;

import annotations.SlowTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@Tag("filtering")
public class TagDemo {

    @Test
    @Tag("unit")
    @Tag("fast")
    void test_fast() {
        System.out.println("FAST!!!");
    }

    @Test
    @Tag("slow")
    @Tag("integration")
    void test_slow() {
        System.out.println("Zzzz ... slow");
    }

    @SlowTest
    void test_slow_anno() {
        System.out.println("Zzzz ... annotated");
    }



}
