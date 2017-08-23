/**
 * This class implements the Interface Circuit and creates a new resistor.
 * 
 * @author Theresa Steinmetz
 *
 */
public class Resistor implements Circuit {
	private final double ohm;
	
	/**
	 * This constructor create a new resistor by initialize with ohm. 
	 * 
	 * @param ohm
	 * 				amount of ohm for the resistor
	 */
	public Resistor(final double ohm){
		this.ohm = ohm;
	}
	
	/**
	 * This method provides the number of total ohm in a resistor.
	 * 
	 * @see Circuit#getOhm()
	 * @return the total number of ohm in a resistor.
	 */
	@Override
	public double getOhm() {
		return ohm;
	}

	/**
	 * This method provides the number of resistors.
	 * 
	 * @see Circuit#numberOfResistors()
	 * @return the total number of resistors
	 */
	@Override
	public int numberOfResistors() {
		return 1;
	}
}
