package fruits;

public class Fruit {
  private final String name;
  private final int price;

  public Fruit(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getPrice() {
    return String.format("%.2f", price / 100.0);
  }
}
