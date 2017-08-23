/**
 * The Interface guranty basic functionality for Resistors.
 * 
 * @author Theresa Steinmetz
 *
 */
public interface Circuit {
	
	/**
	 * This method provide the total ohm value of a Resistor.
	 * 
	 * @return the total ohm value
	 */
	public double getOhm();
	
	/**
	 * This method get you the total number of resistances in a connection
	 * 
	 * @return the total number of resistances
	 */
	public int numberOfResistors();
}
