package jhtp.ch_10.console;

import jhtp.ch_10.console.CommissionEmployee;

public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary;
	
	public BasePlusCommissionEmployee(String first,String last,String ssn,double sales,double rate,double salary)
	{
		super(first,last,ssn,sales,rate);
		setBaseSalary(salary);
	}
	
	public void setBaseSalary(double salary)
	{
		baseSalary=salary<0.0 ? 0.0 : salary ;
	}
	public double getBaseSalary()
	{
		return baseSalary;
	}
	
	public double earnings()
	{
		return getBaseSalary()+super.earnings();
	}
	
	public String toString()
	{
		return String.format("%s: %s\n%s: $%.2f","Base Salaried",super.toString(),"Base salary",getBaseSalary());
	}
}