import java.util.Scanner;

public class Lab4b {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int level;

		System.out.print("Level > ");
		level = input.nextInt();
		// Each hierarchy of needs falls through down the list. 5 gets all needs met, 1 only gets Physiological, etc... 
		switch (level){
			case 5:
				System.out.println("Self-actualization");
			case 4:
				System.out.println("Esteem");
			case 3:
				System.out.println("Love and Belonging");
			case 2:
				System.out.println("Safety");
			case 1:
				System.out.println("Physiological");
		}

		System.exit(0);
	}
}