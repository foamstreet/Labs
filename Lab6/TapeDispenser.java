public class TapeDispenser
{

	private double inchesOfTape;

	public TapeDispenser()
	{
		inchesOfTape = 50.0;
	}

	public String inchesOfTapeStatus()
	{
		String status = "";
		if(inchesOfTape > 45.0){
			status = "full";
		}
		else if(inchesOfTape >= 35.0 && inchesOfTape < 45.0){
			status = "almost full";
		}
		else if(inchesOfTape >= 15.0 && inchesOfTape < 35.0){
			status = "halfway full";
		}
		else if(inchesOfTape > 0.0 && inchesOfTape < 15.0){
			status = "almost empty";
		}
		else if(inchesOfTape == 0){
			status = "empty";
		}
		return status;
	}

	public void refillTape(){
		inchesOfTape = 50.0;
	}

	public void useTape(double pages){
		inchesOfTape -=  pages * 0.25;
		if(inchesOfTape <  0){
			System.out.println("You have run out of tape!");
			System.out.println("You could not survive the ordeal of the OFFICE QUEST.");
			System.exit(0);
		}
	}

}