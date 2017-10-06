package Assignment2;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Gym implements Runnable {
	
	private static final int GYM_SIZE = 30;
	private static final int GYM_REGISTERED_CLINETS = 10000;
	private static Map<WeightPlateSize, Integer> noOfWeightPlates;
	private Set<Integer> clients;
	private ExecutorService executor;
	private Semaphore lps = new Semaphore(5, true);
	private Semaphore bb = new Semaphore(5, true);
	private Semaphore hsm = new Semaphore(5, true);
	private Semaphore lem = new Semaphore(5, true);
	private Semaphore lcm = new Semaphore(5, true);
	private Semaphore lpm = new Semaphore(5, true);
	private Semaphore pm = new Semaphore(5, true);
	private Semaphore ccm = new Semaphore(5, true);
	private Semaphore small = new Semaphore(110, true);
	private Semaphore medium = new Semaphore(90, true);
	private Semaphore large = new Semaphore(75, true);
	public int id = 0;
	
	
	ExecutorService es = Executors.newFixedThreadPool(GYM_SIZE);
	
	public void run() {
		
		noOfWeightPlates = new HashMap<WeightPlateSize, Integer>();
		noOfWeightPlates.put(new WeightPlateSize(WeightPlateSize.wps.SMALL_3KG), (int)Math.random() * 2);
		noOfWeightPlates.put(new WeightPlateSize(WeightPlateSize.wps.MEDIUM_5KG), (int)Math.random() * 2);
		noOfWeightPlates.put(new WeightPlateSize(WeightPlateSize.wps.LARGE_10KG), (int)Math.random() * 2);
		Client c = Client.generateRandomClient(++id, noOfWeightPlates);
		c.getRoutine();
	}
	
	public static void main(String[] args) {
	}
}
