package jhtp.ch_8.console;

public class SavingsAccount
{
	static double annualInterestRate;
	private double savingBalance;
	
	public SavingsAccount(double b)
	{
		savingBalance=b;
	}
	static void modifyInterestRate(double air)
	{
		annualInterestRate=air/100;
	}
	public double calculateMonthlyInterest()
	{
		return (savingBalance*annualInterestRate)/12;
	}
	public double getBalance()
	{
		return savingBalance+=calculateMonthlyInterest();
	}
}