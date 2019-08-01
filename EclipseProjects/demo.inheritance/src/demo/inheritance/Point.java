package demo.inheritance;
import static java.lang.Math.sqrt;

public class Point {

	private double x,y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double distance(Point p2) {
		double dx= x-p2.x;
		double dy= y-p2.y;
		return sqrt(dx*dx+dy*dy);
	}
	
	public String info() {
		return "Point("+x+","+y+")";
	}
	
	public double slope() {
		return y/x;
	}
	
}