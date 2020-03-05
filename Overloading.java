
public class Overloading 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		/*Calculation calculation=new Calculation();
		System.out.println(calculation.addition(4500,100));
		System.out.println(calculation.addition(45.145,100));
		*/
		System.out.println("in Main method");
		System.out.println(Calculation.addition(10,10.55));
		
		
		
	}

}

class Calculation
{
	
		public static int addition(int num1,int num2)
		{
			System.out.println("in Int method");
			return num1+num2;
						
		}
		//overloading
		public static double addition(double num1,double num2)
		{
			System.out.println("in Double method");
			return num1+num2;
		}
}

