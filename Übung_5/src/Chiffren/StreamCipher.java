package Chiffren;

import java.util.Random;

/**
 * This class implements a stream cipher, every byte get encrypted with a different random key.
 * 
 * @author Theresa Steinmetz
 *
 */
public class StreamCipher implements Cipher {

	/**
	 * This method encrypt plainbytes with a random key generator.
	 * The generator is an object of the class Random.
	 * 
	 * @see Chiffren.Cipher#encrypt(byte[], int)
	 * @throws an IllegalArgumentsException if the plainbytes are null
	 * @param plainbytes
	 * 					is the byte-array which should be encrypted
	 * @param key
	 * 			the secret bytes as seed for the random key generator
	 * @return the cipherbytes
	 */
	@Override
	public byte[] encrypt(byte[] plainbytes, int key) {
		if(plainbytes == null){
			throw new IllegalArgumentException("Plainbytes must not be NULL!");
		}
			Random generator = new Random();
			generator.setSeed(key);
			int nextKey = generator.nextInt();
			byte[] cryptbytes = new byte[plainbytes.length];
			int i = 0;
			for (byte b : plainbytes){
				cryptbytes[i] = (byte)(b ^ nextKey);
				i++;
		}
		return cryptbytes;
	}

	/**
	 *  This method decrypt by using the method encryption.
	 *  It works because if the same seed is added to the random key generator
	 *  the same out put is produced.
	 * 
	 * @see Chiffren.Cipher#decrypt(byte[], int)
	 * @param cryptbytes
	 * 					is the encrypted plainbyte-array
	 * @param key
	 * 			is the same key used by the method encrypt
	 * @throws an IllegalArgumentsException if the cryptbytes are null
	 * @return the plainbytes
	 */
	@Override
	public byte[] decrypt(byte[] cryptbytes, int key) {
		if(cryptbytes == null){
			throw new IllegalArgumentException("Cryptbytes must not be NULL!");
		}
		return encrypt(cryptbytes, key);
	}
}
