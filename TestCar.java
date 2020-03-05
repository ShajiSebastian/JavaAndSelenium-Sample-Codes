//This example gives constructor, overriding, subclass etc
//super class


class Car
{
	
	public Car()
	{
		System.out.println("In Car. No Color");
	}
	
	public Car(String str)
	{
		System.out.println("In Car. Color is "+str);
	}
	
	public void acceleration()
	{
		System.out.println("In Acceleration...");
	}
	
	public void breaking()
	{
		System.out.println("In Breaking..");
	}			
}

//sub-class

class CarX extends Car
{
	
	public CarX()
	{
		super("Yellow");//this statement is calling super class constructor and its mandatory this should be the first statement in sub-class constructor
	}
	
	public void ABS()
	{
		System.out.println("in ABS");
	}
	
	//overriding the acceleration method
	
	public void acceleration()
	{
		System.out.println("in CarX acceleration....");
	}
}
class Benz extends CarX
{
}


public class TestCar 
{
		public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("in Main Class....");
		Benz car1=new Benz();
		car1.acceleration();
		car1.breaking();
		car1.ABS();
	}

}