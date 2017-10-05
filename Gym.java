package Assignment2;

import java.util.*;
import java.util.concurrent.ExecutorService;

public class Gym implements Runnable {
	
	private static final int GYM_SIZE = 30;
	private static final int GYM_REGISTERED_CLINETS = 10000;
	private static Map<WeightPlateSize, Integer> noOfWeightPlates;
	private Set<Integer> clients;
	private ExecutorService executor;
	
	public enum WeightPlateSize {
		SMALL_3KG, MEDIUM_5KG, LARGE_10KG
	}
	
	static {
		noOfWeightPlates = new HashMap<WeightPlateSize, Integer>();
		noOfWeightPlates.put(WeightPlateSize.valueOf("SMALL_3KG"), 110);
		noOfWeightPlates.put(WeightPlateSize.valueOf("MEDIUM_5KG"), 90);
		noOfWeightPlates.put(WeightPlateSize.valueOf("LARGE_10KG"), 75);
	}
	
	
	public void run() {
		
	}
	
	public static void main(String[] args) {
		Gym g = new Gym();
		System.out.println(g.noOfWeightPlates);
	}
}
