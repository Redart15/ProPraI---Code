import de.hhu.educode.testing.MethodCall;
import de.hhu.educode.testing.Program;
import de.hhu.educode.testing.RuntimeClass;
import org.junit.jupiter.api.DisplayName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

public class SortTest {
    private static final RuntimeClass ZULASSUNG_CLASS = RuntimeClass.forName("Sort");

    private static final MethodCall<Void> MAIN_METHOD = MethodCall.<Void>builder()
            .runtimeClass(ZULASSUNG_CLASS)
            .modifiers(Modifier.PUBLIC | Modifier.STATIC)
            .returnType(void.class)
            .name("main")
            .parameterTypes(new Class<?>[]{String[].class})
            .build();

    private static final Object[] EMPTY_ARGS = { new String[]{} };

    private static final String MULTIPLE_INPUT =
            "Tai Becker\n" +
            "Sascha Maier\n" +
            "Kim Müller\n" +
            "Kari Nguyen-Kim\n" +
            "Katara Schmidt";

    @Test
    @DisplayName("Prüfe, ob das Programm bei einer leeren Eingabe nichts ausgibt.")
    void testEmptyInput() {
        var result = Program.execute(() -> MAIN_METHOD.invoke(null, EMPTY_ARGS), "");

        Assertions.assertThat(result.getOutput()).isBlank();
    }

    @Test
    @DisplayName("Prüfe, ob das Programm bei einer einzelnen Eingabezeile diese ausgibt.")
    void testSingleInput() {
        var result = Program.execute(() -> MAIN_METHOD.invoke(null, EMPTY_ARGS), "0");
        Assertions.assertThat(result.getOutput().lines()).containsExactly("0");
    }

    @Test
    @DisplayName("Prüfe, ob das Programm bei vielen Eingabezeile diese sortiert ausgibt.")
    void testMultipleInputLines() {
        var result = Program.execute(() -> MAIN_METHOD.invoke(null, EMPTY_ARGS), MULTIPLE_INPUT);

        Assertions.assertThat(result.getOutput().lines()).containsExactlyInAnyOrder(MULTIPLE_INPUT.split("\n"));
        Assertions.assertThat(result.getOutput().lines()).isSorted();
    }

}
