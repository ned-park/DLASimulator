/**
 * Provides a 3D lattice of Sites that constitutes the simulated world
 * and functions to set and access the states of those Sites
 *
 */


public class Lattice {

	private int X = 20;
	private int Y = 20;
	private int Z = 20;
	
	private int particleCount = 0;
	private int exitCount = 0;
	
	private Site[][][] lattice;
	
	
	
	/**
	 * Default constructor if size is not specified
	 */
	public Lattice() {
		lattice = new Site[Z][Y][X];
	}
	
	
	/**
	 * Argumented constructor for making variable sized simulations
	 * 
	 * @param x the x dimension of the simulation
	 * @param y the y dimension of the simulation
	 * @param z the z dimension of the simulation
	 */
	public Lattice(int x, int y, int z) {
		this.X = x;
		this.Y = y;
		this.Z = z;
		
		lattice = new Site[Z][Y][X];
	}
	
	
	/**
	 * Sets the site (x,y,z) to the provided state
	 * 
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param z z coordinate
	 * @param state The state to set the site to 
	 */
	public void setState(int x, int y, int z, Site state) {
		switch(state) {
		case PARTICLE:	
			++particleCount;
			break;
		case EXIT:
			++exitCount;
			break;
		}
		
		lattice[z][y][x] = state;
	}
	
	/**
	 * Returns the state at the given coordinates
	 * 
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param z z coordinate
	 * @return the state at the given coordinates
	 */
	public Site getState(int x, int y, int z) {
		return lattice[z][y][x];
	}
	
	/**
	 * Get the number of particles added
	 * 
	 * @return the number of particles sites
	 */
	public int getNumSeeded() { return particleCount; }
	
	
	/**
	 *  Get the number of exit sites
	 * 
	 * @return the number of exit sites
	 */
	public int getNumExits() { return exitCount; }
	
	
	/**
	 *  Get the size of the X dimension
	 * 
	 * @return the size of the X dimension
	 */
	public int dimX() { return X; }
	
	/**
	 *  Get the size of the Y dimension
	 * 
	 * @return the size of the Y dimension
	 */
	public int dimY() { return Y; }
	
	/**
	 * Get the size of the Z dimension
	 * 
	 * @return the size of the Z dimension
	 */
	public int dimZ() { return Z; }
	
}
