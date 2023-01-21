public class Person {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String greet() {
    return "Hallo, ich bin "+name+".";
  }
}
