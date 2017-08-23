import static org.junit.Assert.*;

import org.junit.Test;

public class CrossSumTest {

	@Test
	public void testChecksumNormalString() {
		CrossSum test = new CrossSum();
		int result = test.checksum("Hallo Welt!");
		assertEquals(91, result);
	}

	@Test
	public void testChecksumNull() {
		CrossSum test = new CrossSum();
		try{
			test.checksum(null);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Input must not be NULL or empty!");
		}
	}
	
	@Test
	public void testChecksumEmpty() {
		CrossSum test = new CrossSum();
		try{
			test.checksum("");
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Input must not be NULL or empty!");
		}
	}
	
	@Test
	public void testChecksumSpaceAtBeginn() {
		CrossSum test = new CrossSum();
		int result = test.checksum(" Hallo Welt!");
		assertEquals(96, result);
	}
	
	@Test
	public void testChecksumSpecialCharacterAtBeginn() {
		CrossSum test = new CrossSum();
		int result = test.checksum("?Hallo Welt!");
		assertEquals(100, result);
	}
	
	@Test
	public void testChecksumWithNumbers() {
		CrossSum test = new CrossSum();
		int result = test.checksum("123456789");
		assertEquals(81, result);
	}
	
	@Test
	public void testChecksumWithNumbersAndCharacters() {
		CrossSum test = new CrossSum();
		int result = test.checksum("1234asdf");
		assertEquals(58, result);
	}
	
	@Test
	public void testChecksumJustSpace() {
		CrossSum test = new CrossSum();
		int result = test.checksum(" ");
		assertEquals(5, result);
	}
	
	@Test
	public void testChecksumJustCapitalLetters() {
		CrossSum test = new CrossSum();
		int result = test.checksum("ASDFG");
		assertEquals(51, result);
	}
	
	@Test
	public void testChecksumJustMinorLetters() {
		CrossSum test = new CrossSum();
		int result = test.checksum("asdfg");
		assertEquals(31, result);
	}
	
	@Test
	public void testChecksumLongInput() {
		CrossSum test = new CrossSum();
		int result = test.checksum("DonauDampfSchiffFahrtsGessellschaftsFähigeKapitänsMüzenHalterung!"
				+ "DonauDampfSchiffFahrtsGessellschaftsFähigeKapitänsMüzenHalterung!"
				+ "DonauDampfSchiffFahrtsGessellschaftsFähigeKapitänsMüzenHalterung!"
				+ "DonauDampfSchiffFahrtsGessellschaftsFähigeKapitänsMüzenHalterung!");
		assertEquals(1868, result);
	}
}
