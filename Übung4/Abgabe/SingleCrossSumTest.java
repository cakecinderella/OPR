import static org.junit.Assert.*;

import org.junit.Test;

public class SingleCrossSumTest extends SingleCrossSum {

	@Test
	public void testChecksumNormalString() {
		SingleCrossSum test = new SingleCrossSum();
		int result = test.checksum("Hallo Welt!");
		assertEquals(1, result);
	}
	
	@Test
	public void testChecksumNull() {
		SingleCrossSum test = new SingleCrossSum();
		try{
			test.checksum(null);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Input must not be NULL or empty!");
		}
	}
	
	@Test
	public void testChecksumEmpty() {
		SingleCrossSum test = new SingleCrossSum();
		try{
			test.checksum("");
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Input must not be NULL or empty!");
		}
	}
	
	@Test
	public void testChecksumSpaceAtBeginn() {
		SingleCrossSum test = new SingleCrossSum();
		int result = test.checksum(" Hallo Welt!");
		assertEquals(6, result);
	}
	
	@Test
	public void testChecksumSpecialCharacterAtBeginn() {
		SingleCrossSum test = new SingleCrossSum();
		int result = test.checksum("?Hallo Welt!");
		assertEquals(1, result);
	}
	
	@Test
	public void testChecksumWithNumbers() {
		SingleCrossSum test = new SingleCrossSum();
		int result = test.checksum("123456789");
		assertEquals(9, result);
	}
	
	@Test
	public void testChecksumWithNumbersAndCharacters() {
		SingleCrossSum test = new SingleCrossSum();
		int result = test.checksum("1234asdf");
		assertEquals(4, result);
	}
	
	@Test
	public void testChecksumJustSpace() {
		SingleCrossSum test = new SingleCrossSum();
		int result = test.checksum(" ");
		assertEquals(5, result);
	}
	
	@Test
	public void testChecksumJustCapitalLetters() {
		SingleCrossSum test = new SingleCrossSum();
		int result = test.checksum("ASDFG");
		assertEquals(6, result);
	}
	
	@Test
	public void testChecksumJustMinorLetters() {
		SingleCrossSum test = new SingleCrossSum();
		int result = test.checksum("asdfg");
		assertEquals(4, result);
	}
	
	@Test
	public void testChecksumLongInput() {
		SingleCrossSum test = new SingleCrossSum();
		int result = test.checksum("DonauDampfSchiffFahrtsGessellschaftsFähigeKapitänsMüzenHalterung!"
				+ "DonauDampfSchiffFahrtsGessellschaftsFähigeKapitänsMüzenHalterung!"
				+ "DonauDampfSchiffFahrtsGessellschaftsFähigeKapitänsMüzenHalterung!"
				+ "DonauDampfSchiffFahrtsGessellschaftsFähigeKapitänsMüzenHalterung!");
		assertEquals(5, result);
	}

}
