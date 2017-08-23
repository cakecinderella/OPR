/**
 *  In This class the resistor can have a value between zero and any maximum value
 * 	It Implements the interface Circuit.
 * 
 * @author Theresa Steinmetz
 *
 */
public class Potentiometer implements Circuit {
	private double ohm;
	private final double maxOhm;

	/**
	 * This constructor create a new circuit, which can be filled with a number of resistors.
	 *  
	 * @param ohm
	 * 				Set the number of resistors.
	 */
	public Potentiometer(final double ohm){
		this.ohm = ohm;
		maxOhm = ohm;
	}
	
	/**
	 * This method get the number of resistors of a circuit.
	 * 
	 * @return the number of resistors
	 */
	@Override
	public double getOhm() {
		return ohm;
	}

	/**
	 * This method set the number of resistors between zero and a maximum value.
	 * 
	 * @param ohm
	 * 			Its the number of resistors that the circuit should have
	 */
	public void setOhm(final double ohm){
		if(ohm < 0){
			this.ohm = 0;
		} else if(ohm > maxOhm) {
			this.ohm = maxOhm;
		} else {
			this.ohm = ohm;
		}
	}
	
	/**
	 * This method get the number of resistors.
	 * 
	 * @return the number of resistors.
	 */
	@Override
	public int numberOfResistors() {
		return 1;
	}
}
