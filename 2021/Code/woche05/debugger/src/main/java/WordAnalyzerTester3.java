// Beispiel zur Fehlersuche von Cay Horstmann
// https://horstmann.com/bigj/help/debugger/tutorial.html

public class WordAnalyzerTester3 {
  public static void main(String[] args) {
    test("mississippiii"); // expect: 4 (ss, ss, pp, iii)
    test("test"); // expect: 0 (no repeated letters)
    test("aabbcdaaaabb"); // expect: 4 (aa, bb, aaaa, bb)
  }

  public static void test(String s) {
    WordAnalyzer wa = new WordAnalyzer(s);
    int result = wa.countRepeatedCharacters();
    System.out.println(result + " repeated characters.");
  }
}