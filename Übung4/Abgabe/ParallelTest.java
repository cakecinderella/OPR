import static org.junit.Assert.*;

import org.junit.Test;

public class ParallelTest {
	double delta = 0.001;
	
	@Test
	public void testParallel() {
		Parallel test = new Parallel(new Resistor(4.0), new Resistor(4.0));
		double result = test.getOhm();
		assertEquals(2, result, delta);
	}
	
	@Test
	public void testParallelZero() {
		Parallel test = new Parallel(new Resistor(0.0), new Resistor(0.0));
		double result = test.getOhm();
		assertEquals(0.0, result, delta);
	}
}
