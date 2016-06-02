package jhtp.ch_6.console;
public class Dice
{
	public static void main (String[] args)
	{
		int sum;
		char p='A';
		while(p<='C')
		{
			double a=(Math.random()*10);//Rolling First Dice
			int i=1+((int)a)%6;
			System.out.println (i);
		
			double b=(Math.random()*10);//Rolling Second Dice
			int j=1+((int)b)%6;
			System.out.println (j);
			sum=i+j;
			System.out.println ("Sum for user "+p+" = "+sum);
			p++;
		}
	}
}