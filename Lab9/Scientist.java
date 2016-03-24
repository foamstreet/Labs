public class Scientist {

	int[][][][][] world;
	int[] location = { 0, 0, 0, 0, 0, 0 };
	int color;

	// Returns world array.
	public Scientist(int[][][][][] world) {
		this.world = world;
	}

	// Determines if room has been visited. If it has assigns color 10. 10 = white.
	private void visited(int[][][][][] world){
		if(world[this.location[0]][this.location[1]][this.location[2]][this.location[3]][this.location[4]] == 10){
			color = 10;
		}
		else {
			world[this.location[0]][this.location[1]][this.location[2]][this.location[3]][this.location[4]] = 10;
		}
	}

	// Prevents location from going below 0 or beyond 9.
	private int misner(int location){
		while(location < 0 || location > 9){
			if(location < 0){
				location = location + 10;
			}
			else if(location > 9){
				location = location - 10;
			}
		}
		return location;
	}

	// Moves Scientist through world array coordinates. Returns location array. Assigns color value if not 10 (white).
	public int[] move(int dimension, int numUnits){
		this.color = 0;
		location[5] = 0;
			switch(dimension){
				case 1:
					this.location[0] += numUnits;
					this.location[0] = misner(this.location[0]);
					visited(world);
					break;
				case 2:
					this.location[1] += numUnits;
					this.location[1] = misner(this.location[1]);
					visited(world);
					break;
				case 3:
					this.location[2] += numUnits;
					this.location[2] = misner(this.location[2]);
					visited(world);
					break;
				case 4:
					this.location[3] += numUnits;
					this.location[3] = misner(this.location[3]);
					visited(world);
					break;
				case 5:
					this.location[4] += numUnits;
					this.location[4] = misner(this.location[4]);
					visited(world);
					break;
			}
			if(color != 10){
				for(int i = 0; i < location.length; i++){
					color += location[i];
				}
				color = color % 10;
			}
		location[5] = color;
		return location;
	}

}