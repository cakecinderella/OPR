package Chiffren;

/**
 * This Interface provides two methods. Encrypt to XOR a plainbytes with
 * a key, and decrypt using the same key with XOR to get the plainbytes.
 * 
 * @author Theresa Steinmetz
 *
 */
public interface Cipher {
	
	/**
	 * Encrypt plainbytes by XOR with a key, result are cipherbytes.
	 * 
	 * @param plainbytes
	 * 					the plain text to be encrypted
	 * @param key
	 * 			the key for encryption
	 * @return cryptbytes, encrypted by XOR with plainbytes and key
	 */
	byte[] encrypt(byte[] plainbytes, int key);
	
	/**
	 * Decrypt cypherbytes by XOR with the key, result are the
	 * plainbytes.
	 * 
	 * @param cryptbytes
	 * 					the output of an encryption
	 * @param key
	 * 			the key needed for decryption
	 * @return the original plainbytes of the encryption
	 */
	byte[] decrypt(byte[] cryptbytes, int key);
}
