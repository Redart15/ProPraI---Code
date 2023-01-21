// Beispiel zur Fehlersuche von Cay Horstmann
// https://horstmann.com/bigj/help/debugger/tutorial.html

public class WordAnalyzerTester2 {

  public static void main(String[] args) {
    test("missisippi"); // expect: i (not m or s)
    test("mate"); // expect: 0 (no duplicate letters)
    test("test"); // expect: t
  }

  public static void test(String s) {
    WordAnalyzer wa = new WordAnalyzer(s);
    char result = wa.firstMultipleCharacter();
     if (result == 0) {
        System.out.println("No multiple character.");
     }
     else {
        System.out.println("First multiple character = " + result);
     }
  }
}