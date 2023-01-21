public class Point {
    private final double radius;
    private final double theta;
    
    private Point(double radius, double theta) {
        this.radius = radius;
        this.theta = theta;
    }

    public static Point fromCartesian(double x, double y) {
        return new Point(Math.hypot(x, y), Math.atan2(x, y));
    }
    
    public double getX() {
        return radius * Math.cos(theta);
    }
    
    public double getY() {
        return radius * Math.sin(theta);
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getTheta() {
        return theta;
    }
}
