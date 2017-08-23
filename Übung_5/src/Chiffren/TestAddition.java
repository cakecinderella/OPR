package Chiffren;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Theresa Steinmetz
 *
 */
public class TestAddition {

	@Test
	public void testRandomEncryptAndDecrypt() {
		Addition test = new Addition();
		String testString = "Hallo Welt!";
		byte[] testArray = testString.getBytes();
		byte[] ciphertext = test.encrypt(testArray, 1);
		String s1 = new String (ciphertext);
		byte[] plaintext = test.decrypt(ciphertext, 1);
		String s2 = new String (plaintext);
		assertEquals("Ibmmp!Xfmu\"",s1);
		assertEquals("Hallo Welt!", s2);
	}
	
	@Test
	public void testIfPlainbytesAreNull() {
		Addition test = new Addition();
		try{
			test.encrypt(null, 5);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Plainbytes must not be NULL!");
		}
	}

	@Test
	public void testIfCipherbytesAreNull() {
		Addition test = new Addition();
		try{
			test.decrypt(null, 5);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Cryptbytes must not be NULL!");
		}
	}

	@Test
	public void testIfKeyToBig() {
		Addition test = new Addition();
		String testString = "Hallo Welt!";
		byte[] testArray = testString.getBytes();
		try{
			test.encrypt(testArray, 128);
		} catch(IndexOutOfBoundsException ex) {
			assertEquals(ex.getMessage(), "Key is not in the allowed range!");
		}
	}
	
	@Test
	public void testIfKeyToSmall() {
		Addition test = new Addition();
		String testString = "Hallo Welt!";
		byte[] testArray = testString.getBytes();
		try{
			test.encrypt(testArray, -129);
		} catch(IndexOutOfBoundsException ex) {
			assertEquals(ex.getMessage(), "Key is not in the allowed range!");
		}
	}

}
