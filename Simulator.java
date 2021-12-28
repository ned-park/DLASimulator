/**
 *
 * An interface for all types of DLA Simulators
 */
public interface Simulator {

	
	/**
	 * Prints the current state of the simulator to the console 
	 */
	void print();
	
	
	/**
	 * Inserts a particle into the system, limited by the the number of tries in order
	 * to avoid infinite loops in dense systems.
	 * 
	 * @param tries the number of attempts to make when adding a particle to the system 
	 */
	void insertParticle(int tries);
	
	
	/**
	 * Standard toString() for a Simulator
	 * 
	 * @return A String containing the current state of the simulator
	 */
	String toString();
	
}
