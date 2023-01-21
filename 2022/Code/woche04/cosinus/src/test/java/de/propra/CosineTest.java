package de.propra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class CosineTest {
    @Test
    @DisplayName("cos(0) ist 1")
    void test_1() {
        double result = Cosine.of(0);
        assertThat(result).isCloseTo(1, within(0.0001));
    }

    @Test
    @DisplayName("cos(π/2) ist 0")
    void test_2() {
        double result = Cosine.of(Math.PI / 2);
        assertThat(result).isCloseTo(0, within(0.0001));
    }

    @Test
    @DisplayName("cos(1) ist 0.54")
    void test_3() {
        double result = Cosine.of(1);
        assertThat(result).isCloseTo(0.5403023058681397, within(0.0001));
    }

    @Test
    @DisplayName("cos(3.5) ist -0.93")
    void test_4() {
        double result = Cosine.of(3.5);
        assertThat(result).isCloseTo(-0.9364566872907963377, within(0.0001));
    }

    @Test
    @DisplayName("cos(-0.5) ist 0.88")
    void test_5() {
        double result = Cosine.of(-0.5);
        assertThat(result).isCloseTo(0.87758256189037271612, within(0.0001));
    }

    @Test
    @DisplayName("cos(42.5) ist -0.08")
    void test_6() {
        double result = Cosine.of(42.5);
        assertThat(result).isCloseTo(0.08838369930580555045, within(0.0001));
    }
}
