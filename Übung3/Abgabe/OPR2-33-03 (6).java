import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Theresa Steinmetz
 *
 */
public class PointTest {

	// Test Points
	Point p = new Point(0.0, 0.0);
	Point p1 = new Point(-1.0, -1.0);
	Point p2 = new Point(1.0, 1.0);
	Point p3 = new Point(-1.9, -1.28);
	Point p4 = new Point(11.00001, -1.0000001);
	Point p5 = new Point(65535, -65535);
	private static final double TOLERANCE = 0.00001;
	
	/**
	 * Tests for the method getX().
	 */
	 @Test
	 public void getXOfPointOfOrigin(){
	     assertEquals("X of Point p", 0.0, p.getX(), 0);
	 }
	 
	 @Test
	 public void getXNegativValue(){
	     assertEquals("X of Point p1", -1.0, p1.getX(), 0);
	 }
	 
	 @Test
	 public void getXPositivValue(){
	     assertEquals("X of Point p2", 1.0, p2.getX(), 0);
	 }
	 
	 @Test
	 public void getXNegativValueRandom(){
	     assertEquals("X of Point p3", -1.9, p3.getX(), 0);
	 }
	 
	 @Test
	 public void getXPositivValueRandom(){
	     assertEquals("X of Point p4", 11.00001, p4.getX(), 0);
	 }
	 
	 @Test
	 public void getXHigherRandom(){
	     assertEquals("X of Point p5", 65535, p5.getX(), 0);
	 }
	 
	 /**
	 * Tests for the method getY().
	 */
	 @Test
	 public void getYOfPointOfOrigin(){
		assertEquals("Y of Point p", 0.0, p.getY(), 0);
	 }
	 
	 public void getYNgeativValue(){
	    assertEquals("Y of Point p1", -1.0, p1.getY(), 0);
	 }
	 		
	 public void getYPositivValue(){
	 	assertEquals("Y of Point p2", 1.0, p2.getY(), 0);
	 }
	 
	 public void getYNegativValueRandom(){
	 	assertEquals("Y of Point p3", -1.28, p3.getY(), 0);
	 }
	 
	 public void getYPositivValueRandom(){
	 	assertEquals("Y of Point p4", -1.0000001, p4.getY(), 0);
	 }
	 
	 public void getYHigherNegativRandom(){
	 	assertEquals("Y of Point p5", -65535, p5.getY(), 0);
	 }
	 
	 /**
	  * Tests for the method distance().
	  */
	 @Test
	 public void distancePointOfOrigin(){
		 assertEquals("distance between Point p and the given Point", 0.0, p.distance(p),0.0);
	 }
	 
	 public void distancePointOfOriginAndPositivPoint(){
		 assertEquals("distance between Point p and the given Point", 1.41421, p.distance(p1),TOLERANCE);
	 }
	 
	 public void distancePointOfOriginAndNegativPoint(){
		 assertEquals("distance between Point p and the given Point", 1.41421, p.distance(p2),TOLERANCE);
	 }
	 
	 public void distancePointOfOriginAndRandomNegativPoint(){
		 assertEquals("distance between Point p and the given Point", 2.29094, p.distance(p3),TOLERANCE);
	 }
	 
	 public void distancePointOfOriginAndRandomPositivPoint(){
		 assertEquals("distance between Point p and the given Point", 11.04537, p.distance(p4),TOLERANCE);
	 }
	 
	 public void distancePointOfOriginAndHigherRandom(){
		 assertEquals("distance between Point p and the given Point", 92680.48581, p.distance(p5),TOLERANCE);
	 }
	 
	 /**
	  * Tests for the method isSame().
	  */
	 @Test
	 public void isSamePositivPointTest(){
		 boolean result = p3.isSame(p3, TOLERANCE);
		assertTrue(result);
	 }
	 
	 @Test
	 public void isSameNegativPointTest(){
		 boolean result = p1.isSame(p1, TOLERANCE);
		assertTrue(result);
	 }
	 
	 @Test
	 public void isSamePointOfOriginTest(){
		 boolean result = p.isSame(p, TOLERANCE);
		assertTrue(result);
	 }
	 
	 @Test
	 public void isSameDifferentPointsTest(){
		 boolean result = p3.isSame(p1, TOLERANCE);
		assertFalse(result);
	 }
	 
	 /**
	  * Tests for the method moved().
	  */
	 @Test
	 public void movedPointOfOriginPositiv(){
		 Point result = p.moved(1.0, 1.0);
		 assertTrue((result.getX() == 1.0 && result.getY() == 1.0) == true);
	 }
	 
	 @Test
	 public void movedPointOfOriginNegativ(){
		 Point result = p.moved(-1.0, -1.0);
		 assertTrue((result.getX() == -1.0 && result.getY() == -1.0) == true);
	 }
	 
	 @Test
	 public void movedPointOfOriginPositivFalse(){
		 Point result = p.moved(1.0, 1.0);
		 assertFalse((result.getX() == -1.0 && result.getY() == -1.0) == true);
	 }
	 
	 @Test
	 public void movedNegativPointToPositiv(){
		 Point result = p1.moved(5.0, 5.0);
		 assertTrue((result.getX() == 4.0 && result.getY() == 4.0) == true);
	 }
	 
	 @Test
	 public void movedPositivPointToNegativ(){
		 Point result = p2.moved(-6.0, -6.0);
		 assertTrue((result.getX() == -5.0 && result.getY() == -5.0) == true);
	 }
	 
	 
	 /**
	  * Tests for the method zoomed().
	  */
	 @Test
	 public void zoomedPositivPointWithPositivFactor(){
		 Point result = p2.zoomed(2);
		 assertTrue((result.getX() == 2.0 && result.getY() == 2.0) == true);
	 }
	 
	 @Test
	 public void zoomedPositivPointWithNegativFactor(){
		 Point result = p2.zoomed(-2);
		 assertTrue((result.getX() == -2.0 && result.getY() == -2.0) == true);
	 }

	 @Test
	 public void zoomedNegativPointWithNegativFactor(){
		 Point result = p1.zoomed(-2);
		 assertTrue((result.getX() == 2.0 && result.getY() == 2.0) == true);
	 }
	 
	 @Test
	 public void zoomedNegativPointWithPositivFactor(){
		 Point result = p1.zoomed(2);
		 assertTrue((result.getX() == -2.0 && result.getY() == -2.0) == true);
	 }
	 
	 @Test
	 public void zoomedPointOfOriginWithPositivFactor(){
		 Point result = p.zoomed(2);
		 assertTrue((result.getX() == 0.0 && result.getY() == 0.0) == true);
	 }
	 
	 @Test
	 public void zoomedPointOfOriginWithNegativFactor(){
		 Point result = p.zoomed(-2);
		 assertTrue((result.getX() == 0.0 && result.getY() == 0.0) == true);
	 }
}
