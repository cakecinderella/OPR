package Chiffren;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Theresa Steinmetz
 *
 */
public class TestXor {

	@Test
	public void testRandomEncryptionAndDecryption() {
		Xor test = new Xor();
		String testString = "Hallo Welt!";
		byte[] testArray = testString.getBytes();
		byte[] ciphertext = test.encrypt(testArray, 5);
		String s1 = new String (ciphertext);
		byte[] plaintext = test.decrypt(ciphertext, 5);
		String s2 = new String (plaintext);
		assertEquals("Mdiij%R`iq$",s1);
		assertEquals("Hallo Welt!", s2);
	}

	@Test
	public void testIfPlainbytesAreNull() {
		Xor test = new Xor();
		try{
			test.encrypt(null, 5);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Plainbytes must not be NULL!");
		}
	}

	@Test
	public void testIfCipherbytesAreNull() {
		Xor test = new Xor();
		try{
			test.decrypt(null, 5);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Cryptbytes must not be NULL!");
		}
	}
	
	@Test
	public void testIfKeyToBig() {
		Xor test = new Xor();
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
		Xor test = new Xor();
		String testString = "Hallo Welt!";
		byte[] testArray = testString.getBytes();
		try{
			test.encrypt(testArray, -129);
		} catch(IndexOutOfBoundsException ex) {
			assertEquals(ex.getMessage(), "Key is not in the allowed range!");
		}
	}
}
