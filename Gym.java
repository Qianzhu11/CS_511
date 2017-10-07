package Assignment2;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Gym implements Runnable {
	
	private static final int GYM_SIZE = 30;
	private static final int GYM_REGISTERED_CLINETS = 10000;
	private Map<WeightPlateSize, Integer> noOfWeightPlates;
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
	
	ExecutorService es = Executors.newFixedThreadPool(GYM_SIZE);
	
	public void run() {
		Client c = Client.generateRandomClient(++id);
		List routine = c.getRoutine();
		
		int k = (int)(Math.random() * 5) + 15;
		
		noOfWeightPlates = new HashMap<WeightPlateSize, Integer>();
		
		for (int i = 0; i < k; i++) {
			noOfWeightPlates.put(new WeightPlateSize(WeightPlateSize.wps.SMALL_3KG), (int)(Math.random() * 3));
			noOfWeightPlates.put(new WeightPlateSize(WeightPlateSize.wps.MEDIUM_5KG), (int)(Math.random() * 3));
			noOfWeightPlates.put(new WeightPlateSize(WeightPlateSize.wps.LARGE_10KG), (int)(Math.random() * 3));
			c.addExercise(Exercise.generateRandomExercise(noOfWeightPlates));
		}
		
		for (int i = 0; i < routine.size(); i++) {
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
				Integer smallTimes = weight.get(new WeightPlateSize(WeightPlateSize.wps.SMALL_3KG));
				Integer mediumTimes = weight.get(new WeightPlateSize(WeightPlateSize.wps.MEDIUM_5KG));
				Integer largeTimes = weight.get(new WeightPlateSize(WeightPlateSize.wps.LARGE_10KG));
				
				System.out.println(lps.availablePermits());
				//System.out.println(medium.availablePermits());
				//System.out.println(large.availablePermits());
				/*if (small.availablePermits() >= smallTimes.intValue()) {
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
				
				System.out.println("Client beginning to do the routine");
				System.out.println(l);
				
				int duration = ((Exercise)l.get(i)).getDuration();
				
				Thread.sleep((long)duration);
				
				System.out.println("Client completes today's routine");
				
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
					
				}	*/
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	
	public static void main(String[] args) {
		new Thread(new Gym()).start();
	}
}
