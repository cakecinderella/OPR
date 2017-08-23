package Chiffren;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCipherFactory {

	@Test
	public void testGetInstanceAdditon() {
		Cipher test = CipherFactory.getInstance("Addition");
		assertTrue(test instanceof Addition);
	}
	
	@Test
	public void testGetInstanceStreamCipher() {
		Cipher test = CipherFactory.getInstance("StreamCipher");
		assertTrue(test instanceof StreamCipher);
	}
	
	@Test
	public void testGetInstanceXor() {
		Cipher test = CipherFactory.getInstance("Xor");
		assertTrue(test instanceof Xor);
	}
	
	@Test
	public void testExceptionWithOtherName() {
		try{
			CipherFactory.getInstance("Schokolade");
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "There is no substitution with this name!");
		}
	}

	@Test
	public void testExceptionNull() {
		try{
			CipherFactory.getInstance(null);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Name can't be NULL!");
		}
	}
	
	@Test
	public void testGetInstance() {
		Cipher test = CipherFactory.getInstance("Addition");
		assertTrue(test instanceof Addition);
	}
}
