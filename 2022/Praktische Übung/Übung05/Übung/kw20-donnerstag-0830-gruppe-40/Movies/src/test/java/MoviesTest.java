import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoviesTest {


    @Test
    @DisplayName("teste nameSort ohne ArrayIndexOutOfBoundsException")
    void test_0(){
        Movie[] movies = new Movie[2];
        movies[0] = new Movie("The Godfather", 1972);
        movies[1] = new Movie("The Good, the Bad, and the Ugly", 1966);
        Movies.nameSort(movies);
    }


    @Test
    @DisplayName("Testet ob sortierung richtig")
    void test_1(){
        Movie[] movies = new Movie[4];
        movies[0] = new Movie("The Godfather", 1972);
        movies[1] = new Movie("The Good, the Bad, and the Ugly", 1966);
        movies[2] = new Movie("Pulp Fiction", 1994);
        movies[3] = new Movie("Shindler's List", 1993);
        Movies.nameSort(movies);
        assertThat(movies[0].getName()).isEqualTo("Pulp Fiction");
        assertThat(movies[1].getName()).isEqualTo("Shindler's List");
        assertThat(movies[2].getName()).isEqualTo("The Godfather");
        assertThat(movies[3].getName()).isEqualTo("The Good, the Bad, and the Ugly");    }
}
