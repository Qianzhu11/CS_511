package Assignment2;

import java.util.*;


public class Client {
	
	private int id;
	private List<Exercise> routine;
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
	
	
	public static Client generateRandomClient(int id, Map<WeightPlateSize, Integer> noOfWeightPlate) {
		
		return new Client(id);
	}
	
}
