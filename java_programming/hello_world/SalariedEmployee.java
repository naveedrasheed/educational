package jhtp.ch_10.console;

import jhtp.ch_10.console.Employee;

public class SalariedEmployee extends Employee
{
	private double weeklySalary;
	
	public SalariedEmployee(String first,String last,String ssn,double salary)
	{
		super(first,last,ssn);
		setWeeklySalary(salary);
	}
	public void setWeeklySalary(double salary)
	{
		weeklySalary=salary>=0.0 ? salary:0.0;
	}
	public double getWeeklySalary()
	{
		return weeklySalary;
	}
	public double earnings()
	{
		return weeklySalary;
	}
	
	public String toString()
	{
		return String.format("Salaried Employee: %s\n%s: $%.2f",super.toString(),
		"Weekly Salary ",getWeeklySalary());
	}
}