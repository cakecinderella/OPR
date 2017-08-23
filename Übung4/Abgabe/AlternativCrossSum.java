/**
 * This class extends the class CrossSum and implements an altered cross sum of a string.
 * 
 * @author Theresa Steinmetz
 *
 */
public class AlternativCrossSum extends CrossSum {
	
	/**
	 * This Method calculates the alternated cross sum of a String.
	 * Means every number of the to ASCII converted string gets
	 * counted plus or minus in change.
	 * 
	 * @param input
	 * 				Is a String of which the checksum should be calculated
	 * @throws IllegalArgumentsException if the input is NULL or empty.
	 * @return the solution of the calculated alternated cross sum.
	 */
	@Override
	public int checksum(String input){
		if(input == null || input.isEmpty()){
			throw new IllegalArgumentException("Input must not be NULL or empty!");
		}
		byte[] byteArray = input.getBytes();
		int sum = 0;
		for(int i = 0; i < byteArray.length; i++){
			int num = byteArray[i];
			while (num > 0) {
				if(num % 2 == 0){
					sum = sum - num % 10;
					num = num / 10;
				} else {
					sum = sum + num % 10;
					num = num / 10;
				}
			}
	} 
	return sum;
	}
}
