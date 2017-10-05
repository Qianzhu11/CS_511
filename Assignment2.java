package Assignment2;

public class Assignment2 {
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Gym());
		thread.start();
	}
}
