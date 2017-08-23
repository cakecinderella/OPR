/**
 * Parallel Circuit of 2 networks
 * 
 * @author Theresa Steinmetz
 *
 */
public class Parallel extends CompoundCircuit {

	/**
	 * This constructor creates a parallel circuit of 2 circuit networks.
	 * 
	 * @param c1 
	 * 				First circuit.
	 * @param c2
	 * 				Second circuit.
	 */
	public Parallel(final Circuit circ1, final Circuit circ2){
		super(circ1, circ2);
	}

	/**
	 * This method get the total number of resistors of a parallel circuit
	 * 
	 * @return total number of ohm of a parallel circuits
	 */
	public double getOhm(){
		return 1/(1/circuit1().getOhm() + 1/circuit2().getOhm());
	}
}
