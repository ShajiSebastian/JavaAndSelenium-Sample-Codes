import java.util.Scanner;



public class StringComparison {	
	public static void main(String[] args) 
	{
	String S1,S2;
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the First string");
	S1 = in.nextLine();
	System.out.println("Enter the Second string");
	S2 = in.nextLine();
	
	boolean b=(S1.contentEquals(S2));
	
	if (b== true)
	{
		System.out.println("Strings are same");
	}
	else
	{
		System.out.println("Strings are NOT same");
	}
	
	

}
}




