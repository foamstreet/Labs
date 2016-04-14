public class CoogieException extends Exception
{
	int numCats;

	public CoogieException(int numCats)
	{
		this.numCats = numCats;
	}

	public String toString()
	{
		String str = (this.numCats + " is too many cats!");
		return str;
	}

}