
public class ManyFns 
{
	
	 public static void main(String[] args) 
		{ Shaji();
		  Titto();
		  int a = 11;
	      int b = 6;
	      int c = minFunction(a, b);
	      System.out.println("Minimum Value = " + c);
		}

	   static String MyName = "Shaji";
	   static String SonName = "Titto";
			   
	   static void Shaji()
	   {
		   System.out.println("My Name is "+MyName);
		  
	   }
	   		   
	   static void Titto()
	   {
		  System.out.println("Son Name is "+SonName);
	   }
	   
	   public static int minFunction(int n1, int n2) 
	   {
		      int min;
		      if (n1 > n2)
		         min = n2;
		      else
		         min = n1;
		      
				return min; //Return to where it called from. It carries a value also
	   }
	 
}

