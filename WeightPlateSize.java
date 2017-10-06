package Assignment2;

import java.util.*;

public class WeightPlateSize {

	private wps weightPlateSize;
	
	public WeightPlateSize(wps weightPlateSize) {
		this.weightPlateSize = weightPlateSize;
	}
	
	public static enum wps {
		SMALL_3KG, MEDIUM_5KG, LARGE_10KG
	}
	
	public String toString() {
		return this.weightPlateSize.name();
	}
	
	public static WeightPlateSize generateRandomWps(int id) {
		List<wps> wpsToList = Arrays.asList(wps.values());
		int wpsLength = wpsToList.size();
		int i = (int)(Math.random() * id % wpsLength);
		return new WeightPlateSize(wpsToList.get(i));
	}
}
