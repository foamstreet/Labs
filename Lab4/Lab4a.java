import java.util.Scanner;

public class Lab4a {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String name;
		int menuSelect;
		int people = 0;
		int impact = 0;
		int utils = 0;

		System.out.print("Enter name > ");
		name = input.nextLine();

		do {
			System.out.println("(1) - Buy people ice cream");
			System.out.println("(2) - Steal ice cream from people");
			System.out.println("(3) - Dream about people eating ice cream");
			System.out.println("(4) - Die");
			System.out.print("Enter next action of " + name + "> ");
			menuSelect = input.nextInt();
			// 4 ends program. Does not need amount of people.
			if(menuSelect != 4){
				System.out.print("How many people? > ");
				people = input.nextInt();
			}

			switch (menuSelect){
				case 1:
					// 3 utils for every person you bought ice cream for will be added to utils
					impact = 3 * people;
					utils += impact;
					System.out.println("This action caused " + impact + " utils of happiness");
					break;
				case 2:
					// -5 utils for every person you stole ice cream from will be added to utils
					impact = -5 * people;
					utils += impact;
					System.out.println("This action caused " + impact + " utils of happiness");
					break;
				case 3:
					// Dreaming about people eating ice cream has no impact on utils
					System.out.println("This action caused 0 utils of happiness");
					break;
				case 4:
					// Print total utils and determine if life was morally good, neutral, or evil
					System.out.println(name + " caused " + utils + " utils of happiness.");
					if(utils > 0){
						System.out.println("This was a morally good life.");
					}
					else if(utils == 0){
						System.out.println("This was a morally neutral life.");
					}
					else {
						System.out.println("This was a morally evil life.");
					}
					break;
				default:
					System.out.println("Invalid selection");
			}
		}while(menuSelect != 4);
		input.close();
		System.exit(0);
	}
}