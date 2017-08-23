package Chiffren;

/**
 * This class provides methods to encrypt and decrypt a byte-array through addition.
 * 
 * @author Theresa Steinmetz
 *
 */
public class Addition implements Cipher {

	/**
	 * This method encrypt plainbytes by adding the key.
	 * 
	 * @see Chiffren.Cipher#encrypt(byte[], int)
	 * @throws an IllegalArgumentsException if the plainbytes are null
	 * @throws an IndexOutOfBoundsException if the key is not in the allowed range
	 * @param plainbytes
	 * 					is the byte-array which should be encrypted
	 * @param key
	 * 			the secret bytes which get added to the plaintext
	 * @return the cipherbytes
	 */
	@Override
	public byte[] encrypt(byte[] plainbytes, int key) {
		if(plainbytes == null){
			throw new IllegalArgumentException("Plainbytes must not be NULL!");
		}
		if(key <= 127 && key >= -128){
			byte[] cryptbytes = new byte[plainbytes.length];
			int i = 0;
			for (byte b : plainbytes){
				cryptbytes[i] = (byte)(b + key);
				i++;
			}
			return cryptbytes;
		} else {
			throw new IndexOutOfBoundsException("Key is not in the allowed range!");
		}
	}

	/**
	 * This method decrypt the cryptbytes with the same key as in the
	 * method encrypt, by using the method encrypt, only difference here is that you need to subtract the key from the cryptbytes.
	 * This works by multiply the key with -1.
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
		int decryptKey = key * (-1);
		return encrypt(cryptbytes, decryptKey);
	}
}
