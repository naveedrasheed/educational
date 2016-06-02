package jhtp.ch_10.console;

import jhtp.ch_10.console.Employee;

public class CommissionEmployee extends Employee
{
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee(String first,String last,String ssn,double sales,double rate)
	{
		super(first,last,ssn);
		setGrossSales(sales);
		setCommissionRate(rate);
	}
	
	public void setGrossSales(double sales)
	{
		grossSales=sales>=0.0 ? sales : 0.0 ;
	}
	public double getGrossSales()
	{
		return grossSales;
	}
	
	public void setCommissionRate(double rate)
	{
		commissionRate=(rate>0.0&&rate<1.0) ? rate : 0.0 ;
	}
	public double getCommissionRate()
	{
		return commissionRate;
	}
	
	public double earnings()
	{
		return getCommissionRate()*getGrossSales();
	}
	
	public String toString()
	{
		return String.format("%s: %s\n%s: $%.2f; %s: %.2f","Commission Employee",super.toString(),
		"Gross Sale",getGrossSales(),"Commision Rate",getCommissionRate());
	}
}