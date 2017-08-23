/**
 * Secure the data integrity by building a checksum
 * <p>
 * The input can be variable.
 * 
 * @author Theresa Steinmetz
 */
public interface Checksum {

	/**
	 * This method build a checksum the input is a String.
	 * The letters get changed to numbers of the ASCII-table.
	 * 
	 * @param input
	 * 				Is a String of which the checksum should be calculated
	 * @return a single Integer, the result of the checksum
	 */
	public int checksum(String input);
}