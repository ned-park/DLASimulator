/**
 *  Runner class for DLA simulators
 */
public class DLArunner {

	public static void main(String[] args) {
		int particles = 0;
		char simType = 'c';
		int attempts = 100000;
		
		if (args.length < 2) {
			printUsage();
		}

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-t")) {
				simType = args[i+1].charAt(0);
			} else if (args[i].equals("-n")) {
				try {
					System.out.println("argument is good: " + args[i+1]);
					particles = Integer.parseInt(args[i+1]);
				} catch (Exception e) {

					printUsage();
				}
			}  else if (args[i].equals("-a")) {
				try {
					attempts = Integer.parseInt(args[i+1]);
				} catch (Exception e) {
					printUsage();
				}
			}
		}
		
		
		Simulator simulation;
		
		if (simType == 'o') {
			simulation = new OpenSimulator();
		} else {
			simulation = new ClosedSimulator();
		}		
		
		for (int p = 0; p < particles; p++) {
			simulation.insertParticle(attempts);
		}
		
		simulation.print();
		
		System.exit(0);
		
	}
	
	/**
	 * Print the usage information for command line invocation
	 * 
	 * @param progName The program's name (in general given by args[0])
	 */
	public static void printUsage() {
		System.out.println("Usage: DLArunner -t <o|c> -n <int>");
        System.out.println("-t the type of simulation, open (o) or closed (c)");
        System.out.println("-n the number of particles to add to the system");
        System.out.println("-a the number of attempts to make when adding an indivual particle"
        		+ "to the system (defaults to 100,000 to prevent infinite indefinite hangs if n is too large)\n");
        System.out.println("Examples:");
        System.out.println("DLArunner -t c -n 600");
        System.out.println("DLArunner -t o -n 700");
        System.exit(0);
	}

}
