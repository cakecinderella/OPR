package Chiffren;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Theresa Steinmetz
 *
 */
public class TestStreamCipher {

	@Test
	public void testRandomEncryptAndDecrypt() {
		StreamCipher test = new StreamCipher();
		String testString = "Hallo Welt!";
		byte[] testArray = testString.getBytes();
		byte[] ciphertext = test.encrypt(testArray, 5);
		String s1 = new String (ciphertext);
		System.out.println(s1);
		byte[] plaintext = test.decrypt(ciphertext, 5);
		String s2 = new String (plaintext);
		System.out.println(s2);
		assertEquals("÷ÞÓÓÐŸèÚÓËž",s1);
		assertEquals("Hallo Welt!", s2);
	}

	@Test
	public void testIfPlainbytesAreNull() {
		StreamCipher test = new StreamCipher();
		try{
			test.encrypt(null, 5);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Plainbytes must not be NULL!");
		}
	}

	@Test
	public void testIfCipherbytesAreNull() {
		StreamCipher test = new StreamCipher();
		try{
			test.decrypt(null, 5);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Cryptbytes must not be NULL!");
		}
	}
}
