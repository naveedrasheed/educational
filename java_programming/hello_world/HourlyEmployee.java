package jhtp.ch_10.console;

import jhtp.ch_10.console.Employee;

public class HourlyEmployee extends Employee
{
	private double wage;
	private double hour;
	
	public HourlyEmployee(String first,String last,String ssn,double hourlyWage,double hoursWorked)
	{
		super(first,last,ssn);
		setWage(hourlyWage);
		setHour(hoursWorked);
	}
	
	public void setHour(double hoursWorked)
	{
		hour=(hoursWorked>=0.0&&hoursWorked<=168) ? hoursWorked : 0.0 ;
	}
	public double getHour()
	{
		return hour;
	}
	
	public void setWage(double hourlyWage)
	{
		wage=hourlyWage>=0.0 ? hourlyWage : 0.0 ;
	}
	public double getWage()
	{
		return wage;
	}
	
	public double earnings()
	{
		if(getHour()<=40)
			return getHour()*getWage();
			
			else
				return 40*getWage()+(getHour()-40)*getWage()*1.5;
	}
	
	public String toString()
	{
		return String.format("Hourly Employee: %s \n%s: $%.2f; %s: %.2f",
		super.toString(),"Hourly Wage ",getWage(),"Hours Worked ",getHour());
	}
}