import java.util.Scanner;

public class Lab09 {
	
	public static String getColor(int value){
		String color;
		switch(value){
			case 1:
				color = "Lime";
				break;
			case 2:
				color = "Cerulean";
				break;
			case 3:
				color = "Goldenrod";
				break;
			case 10:
				color = "White";
				break;
			default:
				color = "Black";
		}
		return color;
	}

	public static void main(String[] args){

		int dimension;
		int numUnits;
		int[] location = new int[6];

		Scanner input = new Scanner(System.in);
		World world = new World();
		Scientist scientist = new Scientist(world.returnWorld());

		do{
			System.out.print("Enter dimension to travel (1,2,3,4,5) (negative to quit) > ");
			dimension = input.nextInt();
			if(dimension < 0){
				System.out.println("The scientist gives up on the quest for understanding.");
				System.exit(0);
			}
			System.out.print("Enter units to travel (negative for backwards) > ");
			numUnits = input.nextInt();
			System.out.print("Location: [");
			location = scientist.move(dimension, numUnits);
			for(int i = 0; i < location.length; i++){
				if(i == (location.length - 1)){
					System.out.println("] = " + getColor(location[i]));
				}
				else{
					System.out.print(location[i] + " ");
				}
			}

		}while(dimension >= 0);

	}

}