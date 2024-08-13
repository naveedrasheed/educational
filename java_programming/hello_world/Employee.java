package jhtp.ch_10.console;

public abstract class Employee
{
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	//Constructor
	public Employee(String first,String last,String ssn)
	{
		firstName=first;
		lastName=last;
		socialSecurityNumber=ssn;
	}
	public String toString()
	{
		return String.format("%s %s \nssn: %s ",firstName,lastName,socialSecurityNumber);
	}
	
	public abstract double earnings();
}