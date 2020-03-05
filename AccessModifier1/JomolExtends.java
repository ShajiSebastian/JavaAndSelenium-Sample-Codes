package AccessModifier1;

import AccessModifier1.Jimmy;

public class JomolExtends  extends Jimmy 
{

	public static void main(String[] args) 
	{
		Jimmy Jomo = new Jimmy();
		//System.out.println("Value in another Sub class of same package is "+ Jomo.JimmyAge);
		//Jomo.printname1();
		System.out.println("'JimmyAge' Variable can be accessed from Sub class of same package and its value is " + Jomo.JimmyAge);
		System.out.println("'printname' Method can be accessed from Sub class of same package and its output is '"+ Jomo.printname()+"'" );
	}

}
