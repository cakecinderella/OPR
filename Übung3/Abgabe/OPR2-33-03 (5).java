/**
 * This class creates a point in a Cartesian coordinate system, calculate the distance between 2 points, 
 * and calculates another point shifted to the original point.
 * 
 * @author Theresa Steinmetz
 *
 */
public class Point {

	double xCoordinate;
	double yCoordinate;
	
	/**
	 * This constructor determine the attributes of a generated Point in the Cartesian coordinate system
	 * by getting a X-coordinate and Y-coordinate of the instance.
	 * 
	 * @param x is the x-coordinate
	 * @param y is the y-coordinate
	 */
	Point(double x, double y){
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	/**
	 * Gets the x-coordinate of the instance
	 * 
	 * @return the x-coordinate
	 */
	public double getX(){
		return this.xCoordinate;
	}
	
	/**
	 *  Gets the y-coordinate of the instance
	 *  
	 * @return the y-coordinate
	 */
	public double getY(){
		return this.yCoordinate;
	}
	
	/**
	 * Calculate the distance between the instance and a point.
	 * 
	 * @param p is a point in the Cartesian coordinate system
	 * @return the distance between the points 
	 */
	public double distance(Point p){
		return Math.hypot(this.getX() - p.getX(), this.getY() - p.getY());
	}
	
	/**
	 * Compare the instance and a point, if the are at the same spot in the Cartesian coordinate system.
	 * Using the method distance
	 * 
	 * @param p is a point in the Cartesian coordinate system
	 * @param within the maximum divergence which is allowed to call the points equal
	 * @return a boolean true for the same point or false for not the same point
	 */
	public boolean isSame(Point p, double within){
		if((this.distance(p) <= within)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Create a new point shifted from the original point of the instance.
	 * 
	 * @param x amount of shift on the x-axis
	 * @param y amount of shift on the y-axis
	 */
	public Point moved(double x, double y){
		return new Point((x + this.xCoordinate), (y + this.yCoordinate));
	}
	
	/**
	 * Create a new point and increases the coordinates by the factor f.
	 * its a helper method for the class Triangle.
	 * 
	 * @param f is the factor which the Point coordinates get increased
	 * @return the coordinates of the new point
	 */
	public Point zoomed(double f){
		return new Point((this.xCoordinate * f), (this.yCoordinate * f));
		
	}
}