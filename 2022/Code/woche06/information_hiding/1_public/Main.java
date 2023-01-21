public class Main {
    public static void main(String[] args) {
        Point p = new Point();
        p.x = 3;
        p.y = 4;
        System.out.println("Punkt: " + p.x + ", " + p.y);
        System.out.println("Radius: " + Math.hypot(p.x, p.y));  // 5.0
    }
}
