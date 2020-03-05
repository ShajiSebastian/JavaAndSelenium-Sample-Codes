package AccessModifier2;

import AccessModifier1.Jimmy;

class Joshy 
{
	
	public static void main(String[] args) 

	{
		Jimmy obj = new Jimmy();
		//System.out.println("Value in another class of Different package is "+ obj.JimmyAge);
		//obj.printname1();
		
		System.out.println("'JimmyAge' Variable can be accessed from  another class of Different package and its value is " + obj.JimmyAge);
		System.out.println("'printname' Method can be accessed from  another class of Different package and its output is '"+ obj.printname()+"'" );
	}

}
