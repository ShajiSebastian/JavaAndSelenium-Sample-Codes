
public class LeaveCalculator 
{
		public static void main(String[] args) 
	{
		Employee emp01=new Employee("Shaji");
		Employee emp02=new Employee("Titto");
		emp01.applyLeave();
		emp01.applyLeave();
		emp02.applyLeave();
		emp01.availableLeave();
		emp02.availableLeave();
			
	}

}



class Employee
{
	
	//declaring class variable??
	
	private static int leaveBalance=10;
	
	private String name;
	
	//constructor called whenever employee object created!	
	public Employee(String n)
	{
		name=n;
	}
	
		public void applyLeave()
	{
			leaveBalance--;
	}
		
		public void availableLeave()
	{
		System.out.println(name+" Available Leave "+leaveBalance);
	}
}