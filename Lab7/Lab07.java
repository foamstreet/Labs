import java.util.Scanner;
import java.io.*;

public class Lab07 {

	public static char[] generateUniverse(int size){
		char[] array = new char[size];
		for(int i = 0; i < size; i++){
			if(i % 7 == 0 || i == 0){
				array[i] = '0';
			}
			else if(i % 5 == 0 && i != 0){
				array[i] = '^';
			}
			else{
				array[i] = '.';
 			}
		}
		return array;
	}

	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		Scanner inputFile;
		int world;
		char choice = 'A';
		int temp;
		char[] universe;
		String theString = "";

		File universeFile = new File("universe.txt");
		if(universeFile.exists()){
		 	inputFile = new Scanner(universeFile);
		 	theString = inputFile.nextLine();
		 	universe = theString.toCharArray();
		}
		else {
			System.out.print("How big of a world? > ");
			world = input.nextInt();
			universe = generateUniverse(world);
		}

		while(choice == 'A' || choice == 'a'){
			for(int i = 0; i < universe.length; i++){
				System.out.print(universe[i]);
			}
			for(int i = 0; i < universe.length; i++){
				if(universe[i] == '0' || universe[i] == '1'){
					temp = Character.getNumericValue(universe[i]);
					temp++;
					universe[i] = Integer.toString(temp).charAt(0);
				}
				else if(universe[i] == '2'){
					if((i + 1) < universe.length && (universe[i + 1] == '.' && universe[i + 1] != '1' && universe[i + 1] != '2')) {
						universe[i + 1] = '2';
						universe[i++] = '.';
					}
					else if((i + 1) < universe.length && universe[i + 1] == '^'){
						universe[i + 1] = '0';
						universe[i++] = '.';
					}
				}
			}
			System.out.println();
			choice = input.next().charAt(0);
		}
		if(choice == 'Q' || choice == 'q'){
			PrintWriter outputFile = new PrintWriter("universe.txt");
			outputFile.println(universe);
			outputFile.close();
		}
	}

}