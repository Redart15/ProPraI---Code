package exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.parallel.Execution;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

class DivisionTest {

    @Test
    void test_divideByZero() {
        Executable code = new Executable() {
            public void execute() throws Throwable {
                Division.div(2, 0);
            }
        };
        ArithmeticException exception = assertThrows(ArithmeticException.class,
                code);
        assertThat(exception.getMessage()).contains("by zero");

    }

    @Test
    void test_divideByZero_lambda() {
        ArithmeticException exception = assertThrows(ArithmeticException.class,
            () -> Division.div(2, 0));
        assertThat(exception.getMessage()).contains("by zero");

    }



}