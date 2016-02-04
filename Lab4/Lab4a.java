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
			if(menuSelect != 4){
				System.out.print("How many people? > ");
				people = input.nextInt();
			}
			switch (menuSelect){
				case 1:  
					impact = 3 * people;
					utils += impact;
					System.out.println("This action caused " + impact + " utils of happiness");
					break;
				case 2:
					impact = -5 * people;
					utils += impact;
					System.out.println("This action caused " + impact + " utils of happiness");
					break;
				case 3:
					System.out.println("This action caused 0 utils of happiness");
					break;
				case 4:
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