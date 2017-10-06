package Assignment2;

import java.util.HashMap;
import java.util.Map;

public class Exercise {
	
	private ApparatusType at;
	private static Map<WeightPlateSize, Integer> weight;
	private int duration;
	
	public Exercise(ApparatusType at, Map<WeightPlateSize, Integer> weight, int duration) {
		this.at = at;
		this.weight = weight;
		this.duration = duration;
	}
	
	public enum at {
		LEGPRESSMACHINE, BARBELL, HACKSQUATMACHINE, LEGEXTENSIONMACHINE, LEGCURLMACHINE, 
		LATPULLDOWNMACHINE ,PECDECKMACHINE ,CABLECROSSOVERMACHINE
	}
	
	
	public static Exercise generateRandomExercise(Map<WeightPlateSize, Integer> noOfWeightPlates) {
		ApparatusType at = ApparatusType.generateRandomAt(10);
		int d = (int)Math.random() * 10;
		return new Exercise(at, noOfWeightPlates, d);
	}
	
}
