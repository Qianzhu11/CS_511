package Assignment2;

import java.util.Set;

public class Gym implements Runnable {
	
	private static final int GYM_SIZE = 30;
	private static final int GYM_REGISTERED_CLINETS = 10000;
	//private Map<WeightPlateSize, int> noOfWeightPlates;
	private Set<Integer> clients;
	//private ExecutorService executor;
	
	public enum WeightPlateSize {
		SMALL_3KG, MEDIUM_5KG, LARGE_10KG
	}
	
	public void run() {
		
	};
}
