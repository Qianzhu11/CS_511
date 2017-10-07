package Assignment2;

import java.util.*;


public class Client {
	
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
	

	public static void main(String[] args) {
		WeightPlateSize wpsSmall = new WeightPlateSize(WeightPlateSize.wps.SMALL_3KG);
		WeightPlateSize wpsMedium = new WeightPlateSize(WeightPlateSize.wps.MEDIUM_5KG);
		WeightPlateSize wpsLarge = new WeightPlateSize(WeightPlateSize.wps.LARGE_10KG);
		
		Map<WeightPlateSize, Integer> weight = new HashMap<WeightPlateSize, Integer>();
		weight.put(wpsSmall, (int)(Math.random() * 3));
		weight.put(wpsMedium, (int)(Math.random() * 3));
		weight.put(wpsLarge, (int)(Math.random() * 3));
		
		Client c = generateRandomClient(1);
		c.routine.add(Exercise.generateRandomExercise(weight));
		c.routine.add(Exercise.generateRandomExercise(weight));
		c.routine.add(Exercise.generateRandomExercise(weight));
		List routine = c.getRoutine();
		
		System.out.println(routine);
		weight.put(wpsSmall, (int)(Math.random() * 3) + 1);
		System.out.println(routine);
	}
}
