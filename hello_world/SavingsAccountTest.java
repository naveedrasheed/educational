package jhtp.ch_8.console;

public class SavingsAccountTest
{
	public static void main (String[] args)
	{
		SavingsAccount saver1=new SavingsAccount(2000);
		SavingsAccount saver2=new SavingsAccount(3000);
		SavingsAccount.modifyInterestRate(5);
		
		System.out.println ("Interest1 "+saver1.calculateMonthlyInterest());
		System.out.println ("B1 "+saver1.getBalance());
		
		System.out.println ("Interest2 "+saver2.calculateMonthlyInterest());
		System.out.println ("B2 "+saver2.getBalance());
	}
}