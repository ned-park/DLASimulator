/**
 * Implements the mechanisms to run the DLA simulations
 *
 */

public class DLA {

	private Lattice lattice;
	private final int stepSize = 1; 
	
	/**
	 * Default constructor for DLA simulations 
	 */
	public DLA() {
		this.lattice = new Lattice();
		
	}
	
	/**
	 * Sets the lattice site (x,y,z) to the provided state
	 * 
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param z z coordinate
	 * @param state The state to set the site to 
	 */
	public void setState(int z, int y, int x, Site state) {
		lattice.setState(z, y, x, state);
	}
	
	
	/**
	 * Perform a random walk of a particle starting a the specified coordinates
	 * and ending when it joins the existing group of particles or exits the system
	 * 
	 * @param z the z coordinate of the particle's entry point
	 * @param y the y coordinate of the particle's entry point
	 * @param x the x coordinate of the particle's entry point
	 * @return
	 */
	public boolean walkParticle(int z, int y, int x) {  
		
		if(lattice.getState(z, y, x) != Site.EMPTY) {
	        return false;
		}

	    //  continue until one of the Sites in direction contains a particle
	    while(lattice.getState(getEquivalenceClassZn(z-1, lattice.dimZ()), y, x) != Site.PARTICLE
		    && lattice.getState(getEquivalenceClassZn(z+1, lattice.dimZ()), y, x) != Site.PARTICLE     
	    	&& lattice.getState(z, getEquivalenceClassZn(y-1, lattice.dimY()), x) != Site.PARTICLE
	        && lattice.getState(z, getEquivalenceClassZn(y+1, lattice.dimY()), x) != Site.PARTICLE
	        && lattice.getState(z, y, getEquivalenceClassZn(x-1, lattice.dimX())) != Site.PARTICLE
	        && lattice.getState(z, y, getEquivalenceClassZn(x+1, lattice.dimX())) != Site.PARTICLE) {

	    	int direction = (int)(Math.random() * 6);
	    	
	    	switch(direction) {
	    	case 0: // up
	    		y = getEquivalenceClassZn(y-stepSize, lattice.dimY());
	    		break;
	    	case 1: // down
	    		y = getEquivalenceClassZn(y+stepSize, lattice.dimY());
	    		break;
	    	case 2: // left
	    		x = getEquivalenceClassZn(x-stepSize, lattice.dimX());
	    		break;
		    case 3: // right
		        x = getEquivalenceClassZn(x+stepSize, lattice.dimX());
		        break;
		    case 4: // toward
		        z = getEquivalenceClassZn(z-stepSize, lattice.dimZ());
		        break;
		    case 5: // away
		        z = getEquivalenceClassZn(z+stepSize, lattice.dimZ());
		        break;
		    }
    	
    	if(lattice.getState(z, y, x) == Site.EXIT) {
    		return false;
    	}
    }
	    
   	lattice.setState(z, y, x, Site.PARTICLE);
   	return true;
	
}
	
	/**
	 * Print the current state of the simulation in slices
	 */
	public void printSimulation() {
		System.out.println(this.toString());
		
	}
	
	
	/**
	 *  Returns a string of the current state of the simulation in slices
	 * 
	 *	@Return a string of the current state of the simulation in slices
	 */
	public String toString() {
		char c = ' ';
		String out = "--------------------\n";
		for (int z = 0; z < lattice.dimZ(); ++z) {
			for (int y = 0; y < lattice.dimY(); ++y) {
				for (int x = 0; x < lattice.dimX(); x++) {
					switch(lattice.getState(z,y,x)) {
					case EMPTY:
						c = '.';
						break;
					case PARTICLE:
						c = '+';
						break;
					case EXIT:
						c = '0';
						break;
					}
					out+= c;
				}
				out += "\n";
			}
			// Print obvious Break for each new z
			out += "--------------------\n";
		}
		return out;
	}
	
	/**
	 *  Accessor for the size of the X dimension
	 * 
	 * @return the size of the X dimension
	 */
	public int getX() { return lattice.dimX(); }
	
	/**
	 *  Accessor for the size of the Y dimension
	 * 
	 * @return the size of the Y dimension
	 */
	public int getY() { return lattice.dimY(); }
	
	/**
	 * Accessor for the size of the Z dimension
	 * 
	 * @return the size of the Z dimension
	 */
	public int getZ() { return lattice.dimZ(); }
	
	
	
	/**
	 * Get the principle value of the equivalence class the particle is in
	 * 
	 * @param m the position of the particle
	 * @param n the size of the dimension the particle moved in
	 * @return the principle value of the equivalence class the particle is in
	 */
	private int getEquivalenceClassZn(int m, int n) {
		return (m < 0)? n - 1 : m < n? m : 0;
	}

}

