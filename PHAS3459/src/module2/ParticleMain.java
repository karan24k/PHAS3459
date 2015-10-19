package module2;

public class ParticleMain {
	public static void main(String[] args) {
		
		// particle instance
		FallingParticle particle = new FallingParticle(4.8, 3.2);
				
		// array of deltaTs
		double[] dts = {0.5, 0.1, 0.01, 0.001, 0.0001};
		
		// Loop through deltaTs and simulate drop
		for (double increment : dts) {
		
			// Set height to 10m and v to 0m/s
			particle.setZ(6);
			particle.setT(0);
			particle.setV(0);
			
			// Drop particle 
			particle.drop(increment);
			
			// Print results
		    System.out.println("\ndeltaT: " + increment + " s");
		    System.out.println("Time taken: " + particle.getT() + " s");
		    System.out.println("Final Velocity: " + particle.getV()+ " m/s");
		}
		
		System.out.println("\nThe first two deltaTs are too large to measure the final values of "
				+ "the variables precisely. Therefore, when we use a smaller delta T\n"
				+ "we get closer to the actual final value of T and V.");
	}

}
