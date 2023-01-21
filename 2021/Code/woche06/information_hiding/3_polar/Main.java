public class Main {
    public static void main(String[] args) {
        Point p = Point.fromCartesian(3, 4);
        System.out.println("Punkt: " + p.getX() + ", " + p.getY());
        System.out.println("Radius: " + p.getRadius());  // 5.0
    }
}
