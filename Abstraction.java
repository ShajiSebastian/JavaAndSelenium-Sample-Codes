/*  
    Abstract class can not be instantiated.
    Abstract class can have all non-abstract methods.
    Any class that have at least one abstract method, has to declare itself as abstract.
    Any non-abstract sub class of abstract class has to implement all abstract methods of parent abstract class.
    Abstract methods does not have any method body.
    Abstract class does have a constructor.

 */

abstract class Bike
{  
   Bike()
   {
	   System.out.println("bike is created");
   }  
   
   abstract void run();  
   
   void changeGear()
   {
	   System.out.println("gear changed");
   }  
 }  
  
 class Honda extends Bike
 {  
	 void run()
 	{
		System.out.println("running safely..");
 	}  
 }  
 
 class Abstraction
 {  
	 public static void main(String args[])
	 {  
		  System.out.println("In Main Method");
		 Bike obj = new Honda();  
		 System.out.println("Going to call 'run' Method");
		 obj.run();  
		 System.out.println("Going to call 'changeGear' Method");
		 obj.changeGear();  
	 }  
 }  