/**
 * This class calculate the cross sum of a string.
 * Also test if the input is null or empty.
 * It implements the Interface Checksum.
 * 
 * @author Theresa Steinmetz
 *
 */
public class CrossSum implements Checksum {

	/**
	 * build the cross sum of each ASCII-value of each letter of the string.
	 * 
	 *  @param input
	 * 				Is a String of which the checksum should be calculated
	 * @throws an IllegalArgumentsException if the input is null or empty
	 * @return an Integer, the result of the checksum
	 */
	@Override
	public int checksum(String input) {
		if(input == null || input.isEmpty()){
			throw new IllegalArgumentException("Input must not be NULL or empty!");
		}
		byte[] byteArray = input.getBytes();
		int sum = 0;
		for(int i = 0; i < byteArray.length; i++){
			  int num = byteArray[i];
		        while (num > 0) {
		            sum = sum + num % 10;
		            num = num / 10;
		        }
		}
		return sum;
	}
}