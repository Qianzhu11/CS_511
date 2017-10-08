package Assignment2;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Gym implements Runnable {
	
	private static final int GYM_SIZE = 30;
	private static final int GYM_REGISTERED_CLINETS = 10000;
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
	private int id = 0;
	
	public WeightPlateSize wpsSmall = new WeightPlateSize(WeightPlateSize.wps.SMALL_3KG);
	public WeightPlateSize wpsMedium = new WeightPlateSize(WeightPlateSize.wps.MEDIUM_5KG);
	public WeightPlateSize wpsLarge = new WeightPlateSize(WeightPlateSize.wps.LARGE_10KG);
	
	ExecutorService es = Executors.newFixedThreadPool(GYM_SIZE);
	
	public void run() {
		Map noOfWeightPlates = new HashMap<WeightPlateSize, Integer>();
		Client c = Client.generateRandomClient(++id);
		List routine = c.getRoutine();
		int durationSum = 0;

		int k = (int)(Math.random() * 5) + 15;
		
		for (int i = 0; i < k; i++) {
			noOfWeightPlates.put(wpsSmall, (int)(Math.random() * 10));
			noOfWeightPlates.put(wpsMedium, (int)(Math.random() * 10));
			noOfWeightPlates.put(wpsLarge, (int)(Math.random() * 10));
			Exercise e = Exercise.generateRandomExercise(noOfWeightPlates);
			c.addExercise(e);
		}
		
		for (int i = 0; i < k; i++) {
			ApparatusType at = ((Exercise)routine.get(i)).getApparatus();
			String ats = at.toString();
			try {
				switch (ats) {
					case "LEGPRESSMACHINE": lps.acquire();
					case "BARBELL": bb.acquire();
					case "HACKSQUATMACHINE": hsm.acquire();
					case "LEGEXTENSIONMACHINE": lem.acquire();
					case "LEGCURLMACHINE": lcm.acquire();
					case "LATPULLDOWNMACHINE": lpm.acquire();
					case "PECDECKMACHINE": pm.acquire();
					case "CABLECROSSOVERMACHINE": ccm.acquire();
				}
				
				Map<WeightPlateSize, Integer> weight = ((Exercise)routine.get(i)).getWeight();
				Integer smallTimes = weight.get(wpsSmall);
				Integer mediumTimes = weight.get(wpsMedium);
				Integer largeTimes = weight.get(wpsLarge);
				
				if (small.availablePermits() >= smallTimes) {
					for (int j = 0; j < smallTimes.intValue(); j++) {
						small.acquire();
					}
				}
				
				if (medium.availablePermits() >= mediumTimes) {
					for (int j = 0; j < mediumTimes; j++) {
						medium.acquire();
					}
				}
				
				if (large.availablePermits() >= largeTimes) {
					for (int j = 0; j < largeTimes; j++) {
						large.acquire();
					}
				}
					
				int duration = ((Exercise)routine.get(i)).getDuration();
				durationSum += duration;
				
				Thread.sleep((long)duration);
				
				small.release(smallTimes);
				
				medium.release(mediumTimes);
				
				large.release(largeTimes);
				
				switch (ats) {
					case "LEGPRESSMACHINE": lps.release();
					case "BARBELL": bb.release();
					case "HACKSQUATMACHINE": hsm.release();
					case "LEGEXTENSIONMACHINE": lem.release();
					case "LEGCURLMACHINE": lcm.release();
					case "LATPULLDOWNMACHINE": lpm.release();
					case "PECDECKMACHINE": pm.release();
					case "CABLECROSSOVERMACHINE": ccm.release();
					
				}
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(routine);
		System.out.println("Client" + id + " completes today's routine, using " + durationSum + "ms");
	}
}

class Client implements Runnable {
	
	private int id;
	private List<Exercise> routine = new ArrayList<Exercise>();
	private static Map<WeightPlateSize, Integer> weight;
	
	public Client(int id) {
		this.id = id;
	}

	static {
		weight = new HashMap<WeightPlateSize, Integer>();
		weight.put(new WeightPlateSize(WeightPlateSize.wps.SMALL_3KG), (int)Math.random() * 2);
		weight.put(new WeightPlateSize(WeightPlateSize.wps.MEDIUM_5KG), (int)Math.random() * 2);
		weight.put(new WeightPlateSize(WeightPlateSize.wps.LARGE_10KG), (int)Math.random() * 2);
	}
	
	public void addExercise(Exercise e) {
		routine.add(e);
	}
	
	public List<Exercise> getRoutine() {
		return this.routine;
	}
	
	
	public static Client generateRandomClient(int id) {
		return new Client(id);
	}
	
	public void run() {
		
	}
}