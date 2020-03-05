package AccessModifier1;

  public class Jimmy 
{

	public int JimmyAge = 10;
	
	public String printname()
	{
		//System.out.println("Inside Printname " );
		return "Inside Printname";
	}
	

		
	public static void main(String[] args) 
	{
		Jimmy jim = new Jimmy();
		System.out.println("'JimmyAge' Variable can be accessed within Main Class and its value is " + jim.JimmyAge);
		System.out.println("'printname' Method can be accessed within Main Class and its output is '"+ jim.printname()+"'" );
		
}
}