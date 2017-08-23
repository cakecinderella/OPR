import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Theresa Steinmetz
 */
public class JUnit_DateChecker {
	@Test
	public void testDayZero() {
		boolean valid = DateChecker.checkValidDate(0, 10, 2017);
		assertTrue("Obacht", !valid);
	}
	
	@Test
	public void testDayThirtyTwo() {
		boolean valid = DateChecker.checkValidDate(32, 10, 2017);
		assertTrue("Obacht", !valid);
	}
	
	@Test
	public void testFirstDayOfTheYear() {
		boolean valid = DateChecker.checkValidDate(01, 01, 2017);
		assertTrue("Obacht", valid);
	}
	
	@Test
	public void testLastDayOfTheYear() {
		boolean valid = DateChecker.checkValidDate(31, 12, 2017);
		assertTrue("Obacht", valid);
	}
	
	@Test
	public void testFirstMonth() {
		boolean valid = DateChecker.checkValidDate(15, 1, 2017);
		assertTrue("Obacht", valid);
	}
	
	@Test
	public void testLastMonth() {
		boolean valid = DateChecker.checkValidDate(15, 12, 2017);
		assertTrue("Obacht", valid);
	}
	
	@Test
	public void testMonthZero() {
		boolean valid = DateChecker.checkValidDate(15, 0, 2017);
		assertTrue("Obacht", !valid);
	}
	
	@Test
	public void testMonthThirteen() {
		boolean valid = DateChecker.checkValidDate(15, 13, 2017);
		assertTrue("Obacht", !valid);
	}
	
	@Test
	public void testMonthThirtyDays() {
		boolean valid = DateChecker.checkValidDate(15, 4, 2017);
		assertTrue("Obacht", valid);
	}
	
	@Test
	public void testMonthThirtyDaysWithThirtyOne() {
		boolean valid = DateChecker.checkValidDate(31, 4, 2017);
		assertTrue("Obacht", !valid);
	}
	
	@Test
	public void testMonthThirtyOneDays() {
		boolean valid = DateChecker.checkValidDate(15, 5, 2017);
		assertTrue("Obacht", valid);
	}
	
	@Test
	public void testFirstPossible() {
		boolean valid = DateChecker.checkValidDate(15, 10, 1582);
		assertTrue("Obacht", valid);
	}
	
	@Test
	public void testDayBeforeFirstPossible() {
		boolean valid = DateChecker.checkValidDate(14, 10, 1582);
		assertTrue("Obacht", !valid);
	}
	
	@Test
	public void testYearZero() {
		boolean valid = DateChecker.checkValidDate(15, 10, 0);
		assertTrue("Obacht", valid);
	}
	@Test
	public void testFutureYear() {
		boolean valid = DateChecker.checkValidDate(15, 10, 10000);
		assertTrue("Obacht", valid);
	}
	
	@Test
	public void testLeapYear() {
		boolean valid = DateChecker.checkValidDate(29, 2, 1584);
		assertTrue("Obacht", valid);
	}
	
	@Test
	public void testLeapYearhundred() {
		boolean valid = DateChecker.checkValidDate(29, 2, 1700);
		assertTrue("Obacht", !valid);
	}
	
	@Test
	public void testLeapYearFourHundred() {
		boolean valid = DateChecker.checkValidDate(29, 2, 2000);
		assertTrue("Obacht", valid);
	}
	
	@Test
	public void testNotALeapYear() {
		boolean valid = DateChecker.checkValidDate(29, 2, 2017);
		assertTrue("Obacht", !valid);
	}
}