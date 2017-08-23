package Chiffren;

/**
 * This class is designed as a factory pattern.
 * It provides two static methods to create instances of substitution cipher.
 * 
 * @author Theresa Steinmetz
 *
 */
public class CipherFactory {

	/**
	 * This static method provide new instances of cipher, which get chosen by the name of the cipher.
	 * 
	 * @param name
	 * 				based on the name this method chose a cipher
	 * @throws an IllegalArgumentException if the name does not fit to one of the cipher.
	 * @return an instance of a substitution cipher of an exception
	 */
	public static Cipher getInstance(String name){
		if(name == null){
			throw new IllegalArgumentException("Name can't be NULL!");
		}
		if(name.equals("Addition")){
			Addition newAddition = new Addition();
			return newAddition;
		} else if(name.equals("Xor")) {
			Xor newXor = new Xor();
			return newXor;
		} else if(name.equals("StreamCipher")) {
			StreamCipher newStreamCipher = new StreamCipher();
			return newStreamCipher;
		} throw new IllegalArgumentException("There is no substitution with this name!");
		
	}
	
	/**
	 * This static method provide a new instance of the addtional cipher
	 * 
	 * @return a new instance of the additional cipher
	 */
	public static Cipher getInstance(){
		return getInstance("Addition");
	}
}
