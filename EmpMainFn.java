public class EmpMainFn
{

	   public static void main(String args[])
	   {
	      /* Create two objects using constructor */
	      EmpSubFn empOne = new EmpSubFn("James Smith");
	      EmpSubFn empTwo = new EmpSubFn("Mary Anne");

	      // Invoking methods for each object created
	      empOne.empAge(26);
	      empOne.empDesignation("Senior Software Engineer");
	      empOne.empSalary(1000);
	      empOne.printEmployee();

	      empTwo.empAge(21);
	      empTwo.empDesignation("Software Engineer");
	      empTwo.empSalary(500);
	      empTwo.printEmployee();
	   }
}