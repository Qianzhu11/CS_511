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
	public int id = 0;
	
	
	ExecutorService es = Executors.newFixedThreadPool(GYM_SIZE);
	
	public void run() {
		Client c = Client.generateRandomClient(++id);
		List l = c.getRoutine();
		
		for (int i = 0; i < l.size(); i++) {
			ApparatusType at = ((Exercise)l.get(i)).getApparatus();
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
			}

			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Map<WeightPlateSize, Integer> weight = ((Exercise)l.get(i)).getWeight();
		}	
	}
	
	public static void main(String[] args) {
	}
}
