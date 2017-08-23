/**
 * This class allow to create triangles, 
 * @author Theresa Steinmetz
 *
 */
public class Triangle {
	
	Point pointA;
	Point pointB;
	Point pointC;
	double ab;
	double bc;
	double ca;
	
	/**
	 * Creates a triangle with 3 points of the instance using the class Point.
	 * Also calculating the distance between the Points using the method "distance"
	 * 
	 * @param a is a point in the Cartesian coordinate system
	 * @param b is a point
	 * @param c is a point
	 */
	Triangle(Point a, Point b, Point c){
		this.pointA = a;
		this.pointB = b;
		this.pointC = c;
		ab = a.distance(b);
		bc = b.distance(c);
		ca = c.distance(a);
	}
	
	/**
	 * This method calculates the perimeter of a triangle using the distances of
	 * the instance points.
	 *
	 * @return the perimeter of a triangle
	 */
	public double perimeter(){
		return (this.ab + this.bc + this.ca);
	}
	
	/**
	 * This method calculate the area of a triangle
	 * 
	 * @return the area of a triangle
	 */
	public double area(){
		double s = (this.perimeter() / 2);
		return Math.sqrt(s*(s - this.ab)*(s - this.bc)*(s - this.ca));
	}
	
	/**
	 * Compare a triangle with a triangle of the instance.
	 * 
	 * @param t triangle which get compared to the triangle of the instance
	 * @param within the maximum divergence between the two triangles
	 * @return true for the same triangle and false if they are different
	 */
	public boolean isSame(Triangle t, double within){
		return ((this.pointA.isSame(t.pointA, within)) &&
					(this.pointB.isSame(t.pointB, within)) &&
							(this.pointC.isSame(t.pointC, within)));
		}
	
	/**
	 * Shift the triangle on the x-axis and the y-axis
	 * 
	 * @param dx shift in every point of the triangle the x by the amount of dx
	 * @param dy shift in every point of the triangle the y by the amount of dy
	 * @return the shifted triangle
	 */
	public Triangle moved(double dx, double dy){
		return new Triangle(this.pointA.moved(dx, dy), this.pointB.moved(dx, dy), this.pointC.moved(dx, dy));
							
	}
	
	/**
	 * This Method creates a new triangle. which is zoomed by the factor f.
	 * 
	 * @param f is the factor which the triangle coordinates are multiplied with to zoom
	 * @return a new triangle 
	 */
	public Triangle zoomed(double f){
		return new Triangle(this.pointA.zoomed(f), this.pointB.zoomed(f), this.pointC.zoomed(f));
	}
}