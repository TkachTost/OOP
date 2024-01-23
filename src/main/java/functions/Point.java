package functions;

public class Point {
    public double x;
    public double y;
    public void copy(Point point){
        this.x= point.x;
        this.y= point.y;
    }
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
}
