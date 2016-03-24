public class World {

	final int WORLD_LENGTH;
	int[][][][][] world;

	public World(){
		WORLD_LENGTH = 10;
		world = new int[WORLD_LENGTH][WORLD_LENGTH][WORLD_LENGTH][WORLD_LENGTH][WORLD_LENGTH];
	}

	// Returns world array.
	public int[][][][][] returnWorld(){
		return this.world;
	}

}