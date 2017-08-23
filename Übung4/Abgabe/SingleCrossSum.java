/**
 * This class build the cross sum down till only one single digit is left.
 * It is a subclass of CrossSum.
 * 
 * @author Theresa Steinmetz
 *
 */
public class SingleCrossSum extends CrossSum {

	/**
	 * build the cross sum of each ASCII-value of each letter of the string.
	 * extended to calculate till only a single number is left as solution.
	 * 
	 *  @param input
	 * 				Is a String of which the checksum should be calculated
	 * @return a single Integer, the result of the checksum
	 */
	@Override
	public int checksum(String input) {
		int crossSum = super.checksum(input);
	    int sum = crossSum % 9;
	    if(sum == 0){
	    	if(crossSum > 0)
	    		return 9;
	        }
	    return sum;
	}
}
