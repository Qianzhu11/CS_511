package Assignment2;

import java.util.Arrays;
import java.util.List;

public class ApparatusType {
	
	private at apparatusType;
	
	public ApparatusType(at apparatusType) {
		this.apparatusType = apparatusType;
	}
	
	public String toString() {
		return this.apparatusType.name();
	}
	
	public enum at {
		LEGPRESSMACHINE, BARBELL, HACKSQUATMACHINE, LEGEXTENSIONMACHINE, LEGCURLMACHINE, 
		LATPULLDOWNMACHINE, PECDECKMACHINE, CABLECROSSOVERMACHINE
	}
	
	public static ApparatusType generateRandomAt(int id) {
		List<at> atToList = Arrays.asList(at.values());
		int atLength = atToList.size();
		int i = (int)(Math.random() * id % atLength);
		return new ApparatusType(atToList.get(i));
	}

}
