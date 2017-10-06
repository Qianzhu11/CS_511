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
	
	public String toString() {
		return this.at.toString() + "," + this.weight.toString() + " " + this.duration;
	}
	
	public static Exercise generateRandomExercise(Map<WeightPlateSize, Integer> noOfWeightPlates) {
		ApparatusType at = ApparatusType.generateRandomAt(10);
		int d = (int)(Math.random() * 10000);
		return new Exercise(at, noOfWeightPlates, d);
	}
	
	public static void main(String[] args) {
		Map<WeightPlateSize, Integer> weight = new HashMap<WeightPlateSize, Integer>();
		weight.put(new WeightPlateSize(WeightPlateSize.wps.SMALL_3KG), (int)(Math.random() * 3));
		weight.put(new WeightPlateSize(WeightPlateSize.wps.MEDIUM_5KG), (int)(Math.random() * 3));
		weight.put(new WeightPlateSize(WeightPlateSize.wps.LARGE_10KG), (int)(Math.random() * 3));
		Exercise e = generateRandomExercise(weight);
		System.out.println(e);
	}

}
