import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Fridolin Schadenfroh
 *
 */
public class PointTest {
	
	private static final double TOLERANCE = 0.05; 
	
	
			// distance
	@Test
	public void testPointDistanceStandart() {
		Point testPoint = new Point(1.0, 1.0);
		Point testPointTwo = new Point (4.0, 4.0);
		
		double result = testPoint.distance(testPointTwo);
		assertEquals(4.242, result , TOLERANCE);
	}
	
	@Test
	public void testPointDistanceStandartDiffrentValue() {
		Point testPoint = new Point(2.0, 4.0);
		Point testPointTwo = new Point (3.0, 8.0);
		
		double result = testPoint.distance(testPointTwo);
		assertEquals(4.123, result , TOLERANCE);
	}
	
	@Test
	public void testPointDistanceHighValues() {
		Point testPoint = new Point(456.0, 385.0);
		Point testPointTwo = new Point (543.0, 783.0);
		
		double result = testPoint.distance(testPointTwo);
		assertEquals(407.397, result , TOLERANCE);
	}
	
	@Test
	public void testPointDistanceIdentPoints() {
		Point testPoint = new Point(1.0, 1.0);
		Point testPointTwo = new Point (1.0, 1.0);

		double result = testPoint.distance(testPointTwo);
		assertEquals(0.0, result , TOLERANCE);
	}
	
	@Test
	public void testPointDistancePointZeero() {
		Point testPoint = new Point(0.0, 0.0);
		Point testPointTwo = new Point (1.0, 1.0);

		double result = testPoint.distance(testPointTwo);
		assertEquals(1.414, result , TOLERANCE);
	}
	
	
	@Test(expected=NoSuchElementException.class)
	public void testPointDistancePointNull() {
		Point testPoint = new Point(0.0, 0.0);
		
		testPoint.distance(null);
	}
	
	@Test
	public void testPointDistancePointNegative() {
		Point testPoint = new Point(-5.0, -5.0);
		Point testPointTwo = new Point (1.0, 1.0);

		double result = testPoint.distance(testPointTwo);
		assertEquals(8.485, result , TOLERANCE);
	}
	
	@Test
	public void testPointDistanceStandartFractionalDigits() {
		Point testPoint = new Point(1.42, 3.86);
		Point testPointTwo = new Point (7.36, 2.75);
		
		double result = testPoint.distance(testPointTwo);
		assertEquals(6.0123, result , TOLERANCE);
	}
	
	
	
			// isSame
	@Test
	public void testPointIsSameTrue() {
		Point testPoint = new Point(1.0, 1.0);
		Point testPointTwo = new Point (1.0, 1.0);
		double deviation = 0.05;

		boolean result = testPoint.isSame(testPointTwo, deviation);
		assertTrue(result);
	}
	
	@Test
	public void testPointIsSameFalse() {
		Point testPoint = new Point(5.0, 1.0);
		Point testPointTwo = new Point (1.0, 1.0);
		double deviation = 0.05;

		boolean result = testPoint.isSame(testPointTwo, deviation);
		assertFalse(result);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testPointIsSamePointNull() {
		Point testPoint = new Point(0.0, 0.0);
		
		testPoint.distance(null);
	}
		
	@Test
	public void testPointIsSameTrueNegativePoint() {
		Point testPoint = new Point(-1.0, -1.0);
		Point testPointTwo = new Point (-1.0, -1.0);
		double deviation = 0.05;

		boolean result = testPoint.isSame(testPointTwo, deviation);
		assertTrue(result);
	}
	
	@Test
	public void testPointIsSameFalseNegativePoint() {
		Point testPoint = new Point(-1.0, -1.0);
		Point testPointTwo = new Point (1.0, 1.0);
		double deviation = 0.05;

		boolean result = testPoint.isSame(testPointTwo, deviation);
		assertFalse(result);
	}
	
			// Moved
//	
//	@Test
//	public void testPointMovedStandart() {
//		Point testPoint = new Point(1.0, 1.0);
//		Point expectedPoint = new Point (5.0, 5.0);
//		
//		Point result = testPoint.moved(4.0, 4.0);
//		boolean isTrue = expectedPoint.isSame(result, TOLERANCE);
//		assertTrue(isTrue);
//	}
//
//	So nicht dann hald anders
	
	@Test
	public void testPointMovedStandart() {
		Point testPoint = new Point(1.0, 1.0);
		
		Point result = testPoint.moved(4.0, 4.0);
		assertTrue((result.getX() == 5.0 && result.getY() == 5.0) == true);
	}
	
	@Test
	public void testPointMovedStandartNegative() {
		Point testPoint = new Point(1.0, 1.0);
		
		Point result = testPoint.moved(4.0, 4.0);
		assertFalse((result.getX() == 8.0 && result.getY() == 8.0) == true);
	}
	
	@Test
	public void testPointMovedStandartNegativePoint() {
		Point testPoint = new Point(-1.0, -1.0);
		
		Point result = testPoint.moved(4.0, 4.0);
		assertTrue((result.getX() == 3.0 && result.getY() == 3.0) == true);
	}
	
	@Test
	public void testPointMovedStandartNegativeValue() {
		Point testPoint = new Point(1.0, 1.0);
		
		Point result = testPoint.moved(-4.0, -4.0);
		assertTrue((result.getX() == -3.0 && result.getY() == -3.0) == true);
	}
	
	@Test
	public void testPointMovedNegativeResult() {
		Point testPoint = new Point(-1.0, -1.0);
		
		Point result = testPoint.moved(4.0, 4.0);
		assertFalse((result.getX() == 4.0 && result.getY() == 4.0) == true);
	}
	
	@Test
	public void testPointMovedStandartNegativeResultNegativeValue() {
		Point testPoint = new Point(-1.0, -1.0);
		
		Point result = testPoint.moved(4.0, 4.0);
		assertFalse((result.getX() == 5.0 && result.getY() == 5.0) == true);
	}
	
	
	
			//MakeZoom
	
	
	@Test
	public void testPointMakeZoomStandart() {
		Point testPoint = new Point(1.0, 1.0);
		
		Point result = testPoint.makeZoom(5);
		assertTrue((result.getX() == 5.0 && result.getY() == 5.0) == true);
	}
	
	@Test
	public void testPointMakeNegativeFactor() {
		Point testPoint = new Point(1.0, 1.0);
		
		Point result = testPoint.makeZoom(-5);
		assertTrue((result.getX() == -5.0 && result.getY() == -5.0) == true);
	}
	
	@Test
	public void testPointMakeZoomNegativepoint() {
		Point testPoint = new Point(-1.0, -1.0);
		
		Point result = testPoint.makeZoom(5);
		assertTrue((result.getX() == -5.0 && result.getY() == -5.0) == true);
	}
	
	@Test
	public void testPointMakeZoomZeroPoint() {
		Point testPoint = new Point(0.0, 0.0);
		
		Point result = testPoint.makeZoom(5);
		assertTrue((result.getX() == 0.0 && result.getY() == 0.0) == true);
	}
	
	
	
	

	
	

}
