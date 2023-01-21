package math;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SinusTest {

    @Test
    void test_sin0(){
        double sin = Sinus.von(0.0);
        assertEquals(0.0,sin,1e-5);
    }

    @Test
    void test_sin_Pi2(){
        double sin = Sinus.von(Math.PI/2);
        assertEquals(1.0,sin,1e-5);
    }


    @Test
    void test_sin_Pi2_assertj(){
        double sin = Sinus.von(Math.PI/2);
        assertThat(sin).isCloseTo(1.0, offset(1e-5));
    }

    @Test
    void test_sin_Pi(){
        double sin = Sinus.von(Math.PI);
        assertEquals(0.0,sin,1e-5);
    }

    @Test
    void test_sin_2Pi(){
        double sin = Sinus.von(2*Math.PI);
        assertEquals(0.0,sin,1e-5);
    }

    @Test
    void test_sin_Pi4(){
        double sin = Sinus.von(Math.PI/4);
        assertEquals(0.707106,sin,1e-5);
    }

    @Test
    void test_sin_halb(){
        double sin = Sinus.von(0.523598);
        assertEquals(0.5,sin,1e-5);
    }


    @Test
    @Disabled("Siehe optionale Aufgaben")
    void test_sin_40Pi(){
        double sin = Sinus.von(40*Math.PI);
        assertEquals(0.0,sin,1e-5);
    }






}