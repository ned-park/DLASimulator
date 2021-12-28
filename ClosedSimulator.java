/**
 * Sets up a closed simulator with periodic boundary conditions and no EXITS
 */
public class ClosedSimulator implements Simulator {

	private DLA dla;
	
	/**
	 * Default constructor initializes a closed DLA simulation 
	 */
	public ClosedSimulator() {
		this.dla = new DLA();
		
		// Build the simulation
		for (int z = 0; z < dla.getZ(); ++z) {
			for (int y = 0; y < dla.getY(); ++y) {
				for (int x = 0; x < dla.getX(); x++) {
					dla.setState(z, y, x, Site.EMPTY);
				}
			}
		}
		
		// Place initial particle
		this.dla.setState((int)(dla.getZ()*Math.random()), 
				(int)(dla.getY()*Math.random()), 
				(int)(dla.getX()*Math.random()), Site.PARTICLE); 
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
			x = (int)(Math.random() * (this.dla.getX() / 2));
			y = (int)(Math.random() * (this.dla.getY() / 2));
			z = (int)(Math.random() * (this.dla.getZ() ));
		} while (!this.dla.walkParticle(z, y, x) && ++attempt < (tries != 100000? tries: 100000));

	}

	@Override
	public String toString() {
		return dla.toString();
	}
	
}
