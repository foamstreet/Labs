public class Stapler 
{

	private int staples;

	public Stapler()
	{
		staples = 10;
	}

	public String staplesStatus()
	{
		String status = "";
		if(staples > 10){
			status = "really heavy";
		}
		else if(staples > 5 && staples < 11){
			status = "feels heavy";
		}
		else if(staples > 0 && staples <= 5){
			status = "light";
		}
		else if(staples == 0){
			status = "really light";
		}
		return status;
	}

	public void refillStaples(){
		staples += 10;
	}

	public void useStapler(int pages){
		if(pages <= 50){
			staples -= 1;
		}
		else if(pages > 50){
			staples -= 3;
		}
		if(staples < 0){
			System.out.println("You have run out of Staples!");
			System.out.println("You could not survive the ordeal of the OFFICE QUEST.");
			System.exit(0);
		}
	}

}