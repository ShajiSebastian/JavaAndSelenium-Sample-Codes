public class ManyFnsWithObjAndConstctr
{
   
   static int puppyAge;
   
   public static void main(String []args)
   {
	      // Object creation and calling Function
	      ManyFnsWithObjAndConstctr myPuppy = new ManyFnsWithObjAndConstctr( "Tommy" );

	      // Call class method to set puppy's age
	      myPuppy.setAge( 2 );

	      /* Call another class method to get puppy's age */
	      getAge( );

	      /* You can access instance variable as follows as well */
	      System.out.println("The value returned from getAge Function is :" + myPuppy.puppyAge ); 
	}
	

   public ManyFnsWithObjAndConstctr(String name)
   {
	   System.out.println("//This function is called by the Object 'Puppy'" ); 
      // This constructor has one parameter, name.
      System.out.println("The value which is passed from constructor is :" + name ); 
   }
   
   public void setAge( int age )
   {
	   System.out.println("\n//Executing setAge Function" ); 
       puppyAge = age;
   }

   public static int getAge( )
   {
	   System.out.println("\n//Executing getAge Function" ); 
       System.out.println("Puppy's age is :" + puppyAge ); 
       return puppyAge;
   }
   
}
   