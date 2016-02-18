import java.util.Scanner;
import java.util.Random;


public class OfficeQuest {

	public static void time(int totalMinutes){
		int hours = totalMinutes / 60;
		int minutes = totalMinutes % 60;
		String outcome = hours + " hour(s) and " + minutes + " to go...";
		if(totalMinutes <= 0){
			System.out.println("Congratulations, the day is done.  You survived your OFFICE QUEST.");
			System.exit(0);
		}
		else{
			System.out.println(outcome);
		}
	}

	public static int paperStaplesTape() {
		Random rand = new Random();
		int probability = rand.nextInt(99) + 1;
		int outcome = 0;
		if(probability > 0 && probability < 6){
			outcome = 1;
		}
		else if(probability > 4 && probability < 11){
			outcome = 2;
		}
		else {
			outcome = rand.nextInt(60) + 1;
		}
		return outcome;
	}

	public static void main(String[] args){
		
		int turn = 0;
		int pages = 0;
		int delivery;
		int totalMinutes = 480;
		int hours;
		Scanner input = new Scanner(System.in);
		char tapeOrStaple = 't';

		TapeDispenser tape = new TapeDispenser();
		Stapler staples = new Stapler();

		System.out.println("OFFICE QUEST");
		while(totalMinutes > 0){
			System.out.println("Turn Number: " + turn++);
			System.out.println("The stapler feels... " + staples.staplesStatus());
			System.out.println("The tape dispenser looks... " + tape.inchesOfTapeStatus());

			// Generate random number of pages to collate
			delivery = paperStaplesTape();
			switch(delivery){
				case 1:
					tape.refillTape();
					System.out.println("The delivery person came by with more tape!");
					totalMinutes -= 20;
					time(totalMinutes);
					break;
				case 2:
					staples.refillStaples();
					System.out.println("The delivery person came by with more staples!");
					totalMinutes -= 20;
					time(totalMinutes);
					break;
				default:
					pages = delivery;
					System.out.println("The delivery person dropped off " + pages + " pages to collate!");
					System.out.print("[T]ape or [S]taple > ");
					tapeOrStaple = input.next().charAt(0);
					tapeOrStaple = Character.toLowerCase(tapeOrStaple);
			}
			if(tapeOrStaple == 't'){
				tape.useTape(pages);
			}
			else if(tapeOrStaple == 's'){
				staples.useStapler(pages);
			}
			else{
				do{
					System.out.print("[T]ape or [S]taple > ");
					tapeOrStaple = input.next().charAt(0);
					tapeOrStaple = Character.toLowerCase(tapeOrStaple);
				}while(tapeOrStaple != 's' && tapeOrStaple != 't');
			}
			totalMinutes -= 20;
			time(totalMinutes);
		}
	}

}