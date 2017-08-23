import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Theresa Steinmetz
 *
 */
public class ResistorTest {
	double delta = 0.01;
	
	@Test
	public void testGetOhmZero() {
		double testValue = 0.0;
		Resistor test = new Resistor(testValue);
		double result = test.getOhm();
		assertEquals(0.0, result, delta);
	}

	
	@Test
	public void testGetOhmMegaohm() {
		double testValue = 1000000.0;
		Resistor test = new Resistor(testValue);
		double result = test.getOhm();
		assertEquals(1000000.0, result, delta);
	}
	
	@Test
	public void testGetOhmKiloohm() {
		double testValue = 1000.0;
		Resistor test = new Resistor(testValue);
		double result = test.getOhm();
		assertEquals(1000.0, result, delta);
	}
	
	@Test
	public void testGetOhmMilliohm() {
		double testValue = 0.001;
		Resistor test = new Resistor(testValue);
		double result = test.getOhm();
		assertEquals(0.001, result, delta);
	}

	@Test
	public void testNumberOfResistors() {
		double testValue = 0.001;
		Resistor test = new Resistor(testValue);
		int result = test.numberOfResistors();
		assertEquals(1, result, delta);
	}

}
