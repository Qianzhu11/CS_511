package Assignment2;

import java.util.Arrays;
import java.util.List;

public class ApparatusType {
	
	private at apparatusType;
	
	public ApparatusType(at apparatusType) {
		this.apparatusType = apparatusType;
	}
	
	public enum at {
		LEGPRESSMACHINE, BARBELL, HACKSQUATMACHINE, LEGEXTENSIONMACHINE, LEGCURLMACHINE, 
		LATPULLDOWNMACHINE , PECDECKMACHINE , CABLECROSSOVERMACHINE
	}
	
	public static ApparatusType generateRandom(int id) {
		List<at> ApparatusTypeToList = Arrays.asList(at.values());
		int atLength = ApparatusTypeToList.size();
		int i = (int)(Math.random() * id % atLength);
		return new ApparatusType(ApparatusTypeToList.get(i));
	}
	
	public static void main(String[] args) {
		ApparatusType a = generateRandom(10);
		System.out.println(a.apparatusType);
	}
}
