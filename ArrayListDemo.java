import java.util.ArrayList;

public class ArrayListDemo 
{

	public static void main(String[] args) 
	{
	
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("USA");
		countries.add("India");
		countries.add("Ireland");
		
		for (int i=0; i < countries.size(); i++)
		{
			System.out.println(countries.get(i));
		}
	 }

}


