import java.util.Random;

public class Lab08 {

	// Determine number of empty spaces in garden array.
	public static int emptySpaces(int[] garden){
		int empty = 0;
		for(int i = 0; i < garden.length; i++){
			if(garden[i] == 0){
				empty++;
			}
		}
		return empty;
	}

	// Resizes garden array based on whether it is Martin or Pangloss' garden.
	public static int[] resizeGarden(int[] garden, String owner){
		int[] newGarden;
		if(owner == "martin"){
			newGarden = new int[garden.length + 2];
			for(int i = 0; i < garden.length; i++){
				newGarden[i] = garden[i];
			}
		}
		else {
			newGarden = new int[garden.length * 2];
			for(int i = 0; i < garden.length; i++){
				newGarden[i] = garden[i];
			}
		}
		return newGarden;
	}

	// Fills the garden array with number of rutabagas grown during each season.
	public static int[] fillGarden(int[] garden, int rutabaga){
		for(int i = 0; i < garden.length; i++){
			if(garden[i] == 0){
				for(int j = i; j < (i + rutabaga); j++){
					garden[j] = rutabaga;
				}
				break;
			}
		}
		return garden;
	}

	// Prints garden array graphical representation.
	public static void printArray(int[] arr, int numItems) {
	    System.out.print("[ ");
	    for (int j=0; j < (arr.length - 1); j++) {
	        if (j >= numItems) {
	        	System.out.print("***, ");
	        } 
	        else {
	        	System.out.print(arr[j] + ", ");
	        }
	    }

	    if ((arr.length -1) >= numItems) {
	        System.out.println("*** ]");
	    } else {
	        System.out.println(arr[arr.length - 1] + " ]");
	    }
    }

	public static void main(String[] args){
		int season = 0;
		int rutabaga = 0;
		int martinNumRutabaga = 0;
		int panglossNumRutabaga = 0;
		int resized = 0;
		int panglossGardenSize;

		int[] martinGarden = new int[5];
		int[] panglossGarden = new int[5];

		Random rand = new Random();

		while(season < 40){

			// Generate random number of rutabagas
			rutabaga = rand.nextInt(5);

			System.out.print("\nSeason: " + (++season) + ", " + rutabaga + " rutabaga(s)");

			if(emptySpaces(martinGarden) < rutabaga){
				// Resize array.
				while(emptySpaces(martinGarden) < rutabaga){
					martinGarden = resizeGarden(martinGarden, "martin");
				}
				System.out.print("\nResized Martin's Garden to " + martinGarden.length + "!");
				martinGarden = fillGarden(martinGarden, rutabaga);
			}
			else {
				// Fill garden.
				martinGarden = fillGarden(martinGarden, rutabaga);
			}
			
			if(emptySpaces(panglossGarden) < rutabaga){
				// Resize array
				while(emptySpaces(panglossGarden) < rutabaga){
					panglossGarden = resizeGarden(panglossGarden, "pangloss");
				}
				System.out.print("\nResized Pangloss's Garden to " + panglossGarden.length + "!");
				panglossGarden = fillGarden(panglossGarden, rutabaga);
			}
			else{
				// Fill garden.
				panglossGarden = fillGarden(panglossGarden, rutabaga);
			}

		}

		// Find number of rutabagas that have grown during all seasons.
		for(int i = 0; i < martinGarden.length; i++){
			if(martinGarden[i] != 0){
				martinNumRutabaga++;
			}
		}
		for(int i = 0; i < panglossGarden.length; i++){
			if(panglossGarden[i] != 0){
				panglossNumRutabaga++;
			}
		}

		System.out.println();

		printArray(martinGarden, martinNumRutabaga);
		// Find resize number.
		resized = (martinGarden.length - 5) / 2;
		System.out.println("Martin Garden Size: " + martinGarden.length + ", Resized " + resized + " times.");
		
		printArray(panglossGarden, martinNumRutabaga);
		// Find resize number.
		resized = 0;
		panglossGardenSize = panglossGarden.length;
		while(panglossGardenSize != 5){
			panglossGardenSize = panglossGardenSize / 2;
			resized++;
		}
		System.out.println("Pangloss Garden Size: " + panglossGarden.length + ", Resized " + resized + " times.");
	}

}