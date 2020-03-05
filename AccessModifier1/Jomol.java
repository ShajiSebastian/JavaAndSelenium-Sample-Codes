package AccessModifier1;

import AccessModifier1.Jimmy;

public class Jomol  
{

	public static void main(String[] args) 
	{
		Jimmy Jomo = new Jimmy();
		
		System.out.println("'JimmyAge' Variable can be accessed from another class of same package and its value is " + Jomo.JimmyAge);
		System.out.println("'printname' Method can be accessed from another class of same package and its output is '"+ Jomo.printname()+"'" );
	}

}
