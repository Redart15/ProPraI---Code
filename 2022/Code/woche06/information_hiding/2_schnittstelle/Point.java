public class Point {
    private final double x;
    private final double y;
    
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point fromCartesian(double x, double y) {
        return new Point(x, y);
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getRadius() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    public double getTheta() {
        return Math.atan2(y, x);
    }
}
