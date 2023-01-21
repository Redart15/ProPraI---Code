public class Movies {

  public static void main(String[] args) {

    Movie[] movies = new Movie[8];
    int i;
    String message, entry;
    movies[0] = new Movie("The Godfather", 1972);
    movies[1] = new Movie("The Good, the Bad, and the Ugly", 1966);
    movies[2] = new Movie("Pulp Fiction", 1994);
    movies[3] = new Movie("Shindler's List", 1993);
    movies[4] = new Movie("Casablanca", 1942);
    movies[5] = new Movie("Wizard of Oz", 1939);
    movies[6] = new Movie("Citizen Kane", 1941);
    movies[7] = new Movie("Some Like It Hot", 1959);

    nameSort(movies);
    display(movies);
  }

  public static void nameSort(Movie[] array) {

    int a, b;
    Movie temp;
    int highSub = array.length;
    for (a = 0; a < highSub; ++a) {
      for (b = 0; b < highSub; ++b) {
        String first = array[b].getName();
        String second = array[b + 1].getName();
        if (first.compareTo(second) < 0) {
          temp = array[b];
          array[b] = array[b];
          array[b + 1] = temp;
        }
      }
    }
  }

  public static void display(Movie[] s) {

    int len = s.length;
    String msg = "";
    for (int i = 0; i < len; i++) {
      msg = msg + s[i].getName() + ", " + s[i].getYear() + "\n";
    }

    System.out.println(msg);

  }

}

class Movie {

  private String name;
  private int year;

  Movie(String s, int y) {
    name = s;
    year = y;
  }

  public String getName() {
    return name;
  }

  public int getYear() {
    return year;
  }
}
