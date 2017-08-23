/**
 * This class implements a serial circuit of 2 resistor networks
 * 
 * @author Theresa Steinmetz
 *
 */
public class Serial extends CompoundCircuit {
	
	
	/**
	 * This constructor creates a serial circuit of 2 resistor networks
	 * 
	 * @param circ1
	 * 				First circuit.
	 * @param circ2
	 * 				Second circuit.
	 */
	public Serial(final Circuit circ1, final Circuit circ2) {
		super(circ1, circ2);
	}
	
	/**
	 * This method get the total ohm value of a circuit network.
	 * 
	 * @return the total number of resistors
	 */
	public double getOhm(){
		return circuit1().getOhm() + circuit2().getOhm();
	}

}
