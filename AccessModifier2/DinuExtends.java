package AccessModifier2;

import AccessModifier1.Jimmy;

public class DinuExtends extends Jimmy{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jimmy Jomo = new Jimmy();
		//System.out.println("Value in another Sub class of Different package is "+ Jomo.JimmyAge);
		//Jomo.printname1();
		
		System.out.println("'JimmyAge' Variable can be accessed from  another Sub class of Different package and its value is " + Jomo.JimmyAge);
		System.out.println("'printname' Method can be accessed from  another Sub class of Different package and its output is '"+ Jomo.printname()+"'" );
	}

}
