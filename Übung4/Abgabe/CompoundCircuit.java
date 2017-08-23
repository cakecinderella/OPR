/**
 *This class create a whole constructed circuit network.
 * 
 * @author Theresa Steinmetz
 *
 */
public abstract class CompoundCircuit implements Circuit {
	private final Circuit circuit1;
	private final Circuit circuit2;

	/**
	 * This constructor create the new circuit network.
	 * Before creating a new CompoundCircuit i tested if the parameters are null.
	 * 
	 * @param circ1
	 * 				Is the first circuit for the network.
	 * @param circ2
	 * 				Is the second circuit for the network.
	 * @throws IllegalArgumentsException if a circuit is NULL.
	 */
	protected CompoundCircuit(final Circuit circ1, final Circuit circ2){
		if(circ1 == null){
			throw new IllegalArgumentException("Input must not be NULL!");
		}
		if(circ2 == null){
			throw new IllegalArgumentException("Input must not be NULL!");
		}
		circuit1 = circ1;
		circuit2 = circ2;
	}
	
	/**
	 * This method provide the first circuit for the network.
	 * 
	 * @return the first circuit for the network.
	 */
	protected Circuit circuit1(){
		return circuit1;
	}
	
	/**
	 * This method provide the second circuit for the network.
	 * 
	 * @return the second circuit for the network.
	 */
	protected Circuit circuit2(){
		return circuit2;
	}

	/**
	 * This method calculate the total number of resistors of an the circuit network.
	 * 
	 * @return the total number of resistors of a the circuit network.
	 */
	public int numberOfResistors() {
		return circuit1.numberOfResistors() + circuit2.numberOfResistors();
	}
}