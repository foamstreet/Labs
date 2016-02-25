import java.util.Scanner;
import java.util.Random;


public class OfficeQuest {

	public static void time(int totalMinutes){
		if(totalMinutes > 0){
			int hours = totalMinutes / 60;
			int minutes = totalMinutes % 60;
			System.out.println( hours + " hour(s) and " + minutes + " to go...");
		}
	}

	public static void main(String[] args){
		int turn = 0;
		int pages = 0;
		int totalMinutes = 480;
		int hours;
		int delivery;
		char tapeOrStaple = 't';

		Scanner input = new Scanner(System.in);
		TapeDispenser tape = new TapeDispenser();
		Stapler staples = new Stapler();

		System.out.println("OFFICE QUEST");

		while((totalMinutes -= 20) >= 0){
			System.out.println("Turn Number: " + turn++);
			System.out.println("The stapler feels... " + staples.staplesStatus());
			System.out.println("The tape dispenser looks... " + tape.inchesOfTapeStatus());

			Random rand = new Random();
			delivery = rand.nextInt(99) + 1;
			if(delivery > 0 && delivery < 6){
				delivery = 1;
			}
			else if(delivery > 5 && delivery < 11){
				delivery = 2;
			}
			else {
				pages = rand.nextInt(60) + 1;
			}
			switch(delivery){
				case 1:
					tape.refillTape();
					System.out.println("The delivery person came by with more tape!");
					time(totalMinutes);
					break;
				case 2:
					staples.refillStaples();
					System.out.println("The delivery person came by with more staples!");
					time(totalMinutes);
					break;
				default:
					System.out.println("The delivery person dropped off " + pages + " pages to collate!");
					System.out.print("[T]ape or [S]taple > ");
					tapeOrStaple = input.next().charAt(0);
					tapeOrStaple = Character.toLowerCase(tapeOrStaple);
					time(totalMinutes);
				if(tapeOrStaple == 't'){
					tape.useTape(pages);
				}
				else if(tapeOrStaple == 's'){
					staples.useStapler(pages);
				}
				else{
					while(tapeOrStaple != 's' && tapeOrStaple != 't'){
						System.out.print("[T]ape or [S]taple > ");
						tapeOrStaple = input.next().charAt(0);
						tapeOrStaple = Character.toLowerCase(tapeOrStaple);
					}
				}
			}
			if(totalMinutes == 0){
				System.out.println("Congratulations, the day is done.  You survived your OFFICE QUEST.");
				System.exit(0);
			}
		}
	}

}