import static org.junit.Assert.*;

import org.junit.Test;

public class SerialTest {
	double delta = 0.001;
	
	@Test
	public void testSerialDefaultValue() {
		Serial test = new Serial(new Resistor(4.0), new Resistor(4.0));
		double result = test.getOhm();
		assertEquals(8.0, result, delta);
	}
	
	@Test
	public void testSerialZero() {
		Serial test = new Serial(new Resistor(0.0), new Resistor(0.0));
		double result = test.getOhm();
		assertEquals(0.0, result, delta);
	}
	
	@Test
	public void testSerialFloating() {
		Serial test = new Serial(new Resistor(4.58), new Resistor(4.425));
		double result = test.getOhm();
		assertEquals(9.005, result, delta);
	}
	
	@Test
	public void testSerial() {
		Serial test = new Serial(new Resistor(1000.0), new Resistor(1525.0));
		double result = test.getOhm();
		assertEquals(2525.0, result, delta);
	}

}
