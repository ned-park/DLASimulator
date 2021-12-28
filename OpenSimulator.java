package dla;

/**
 * Sets up a simulator with an open boundary on one plane 
 */
public class OpenSimulator implements Simulator {

	private DLA dla;
	
	/**
	 * Default constructor initializes an open DLA simulation 
	 */
	public OpenSimulator() {
		this.dla = new DLA();
		
		// Build the simulation
		for (int z = 0; z < dla.getZ(); ++z) {
			for (int y = 0; y < dla.getY(); ++y) {
				for (int x = 0; x < dla.getX(); x++) {
					// Seed bottom with EXIT Sites and top with seeds
					Site state = (z == 0)? Site.EXIT: (z == (dla.getZ() - 1))? Site.PARTICLE: Site.EMPTY;
					dla.setState(z, y, x, state);
				}
			}
		}
		
	}
	
	@Override
	public void print() {
		dla.printSimulation();
	}

	@Override
	public void insertParticle(int tries) {
		int x, y, z;
		int attempt = 0; 
		do {
			x = (int)(Math.random() * this.dla.getX());
			y = (int)(Math.random() * this.dla.getY());
			z = (int)(Math.random() * this.dla.getZ());
		} while (!this.dla.walkParticle(z, y, x) && ++attempt < (tries != 100000? tries: 100000));
	}
	
	@Override
	public String toString() {
		return dla.toString();
	}

}
