package Assignment2;

import java.util.Map;

public class Exercise {
	
	private ApparatusType at;
	private Map<WeightPlateSize, Integer> weight;
	private int duration;
	
	public Exercise(ApparatusType at, Map<WeightPlateSize, Integer> weight, int duration) {
		this.at = at;
		this.weight = weight;
		this.duration = duration;
	}
	
	public enum ApparatusType {
		LEGPRESSMACHINE, BARBELL, HACKSQUATMACHINE, LEGEXTENSIONMACHINE, LEGCURLMACHINE, 
		LATPULLDOWNMACHINE ,PECDECKMACHINE ,CABLECROSSOVERMACHINE
	}
	
	public enum WeightPlateSize {
		SMALL_3KG , MEDIUM_5KG , LARGE_10KG
	}
	
	
	public static Exercise generateRandomExercise(Map<WeightPlateSize, Integer> noOfWeightPlates) {
		double d = Math.random() * 10;
		return null;
	}
	
}
