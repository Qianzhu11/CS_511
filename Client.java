package Assignment2;

import java.util.*;

public class Client {
	
	private int id;
	private List<Exercise> routine;
	
	public Client(int id) {
		this.id = id;
	}
	
	
	public void addExercise(Exercise e) {
		routine.add(e);
	}
	
	
	public static Client generateRandom(int id, Map<WeightPlateSize, Integer> noOfWeightPlate) {
		
		return null;
	}
	
}
