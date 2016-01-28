public class Lab3 {

	public static void main(String[] args){
		double distance = 10;
		int steps = 0;
		while(distance > 0.0){
			distance = distance / 2;
			System.out.println("Step(s): " + steps + " Distance:  " + distance);
			steps++;
		}
	}
}