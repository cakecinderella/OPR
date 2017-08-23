import static org.junit.Assert.*;

import org.junit.Test;

public class PotentiometerTest {
	double delta = 0.001;
	
	@Test
	public void testPotentiometertest() {
		double testValue = 100.0;
		Potentiometer test = new Potentiometer(testValue);
		double result = test.getOhm();
		assertEquals(100, result, delta);
	}
	
	@Test
	public void testPotentiometer(){
		final Circuit c1 = new Resistor(100);
        final Circuit c2 = new Resistor(200);
        final Circuit c3 = new Resistor(300);
        final Circuit c4 = new Resistor(400);
        final Potentiometer c5 = new Potentiometer(500);
        final Circuit c6 = new Resistor(600);
        final Circuit c13 = new Parallel(c1, c3);
        final Circuit c123 = new Serial(c13, c2);
        final Circuit c45 = new Serial(c4, c5);
        final Circuit c12345 = new Parallel(c123, c45);
        final Circuit c = new Parallel(c12345, c6);

        for(int ohm = 0; ohm <= 500; ohm += 100) {
            c5.setOhm(ohm);
            System.out.println(c.getOhm());
        }
	}
}
