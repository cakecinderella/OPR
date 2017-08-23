import static org.junit.Assert.*;

import org.junit.Test;

public class AlternativCrossSumTest extends CrossSum {

	@Test
	public void testChecksumNormalString() {
		AlternativCrossSum test = new AlternativCrossSum();
		int result = test.checksum("Hallo Welt!");
		assertEquals(7, result);
	}
	
	@Test
	public void testChecksumNull() {
		AlternativCrossSum test = new AlternativCrossSum();
		try{
			test.checksum(null);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Input must not be NULL or empty!");
		}
	}
	
	@Test
	public void testChecksumEmpty() {
		AlternativCrossSum test = new AlternativCrossSum();
		try{
			test.checksum("");
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Input must not be NULL or empty!");
		}
	}
	
	@Test
	public void testChecksumSpaceAtBeginn() {
		AlternativCrossSum test = new AlternativCrossSum();
		int result = test.checksum(" Hallo Welt!");
		assertEquals(8, result);
	}
	
	@Test
	public void testChecksumSpecialCharacterAtBeginn() {
		AlternativCrossSum test = new AlternativCrossSum();
		int result = test.checksum("?Hallo Welt!");
		assertEquals(4, result);
	}
	
	@Test
	public void testChecksumWithNumbers() {
		AlternativCrossSum test = new AlternativCrossSum();
		int result = test.checksum("123456789");
		assertEquals(49, result);
	}
	
	@Test
	public void testChecksumWithNumbersAndCharacters() {
		AlternativCrossSum test = new AlternativCrossSum();
		int result = test.checksum("1234asdf");
		assertEquals(42, result);
	}
	
	@Test
	public void testChecksumJustSpace() {
		AlternativCrossSum test = new AlternativCrossSum();
		int result = test.checksum(" ");
		assertEquals(1, result);
	}
	
	@Test
	public void testChecksumJustCapitalLetters() {
		AlternativCrossSum test = new AlternativCrossSum();
		int result = test.checksum("ASDFG");
		assertEquals(-5, result);
	}
	
	@Test
	public void testChecksumJustMinorLetters() {
		AlternativCrossSum test = new AlternativCrossSum();
		int result = test.checksum("asdfg");
		assertEquals(27, result);
	}

	@Test
	public void testChecksumNegativResult() {
		AlternativCrossSum test = new AlternativCrossSum();
		int result = test.checksum("ASDFGASDFGASDFG");
		assertEquals(-15, result);
	}
	

}
