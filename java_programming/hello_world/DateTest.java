import java.util.Scanner;
import jhtp.ch_8.console.Date;

class DateTest
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println ("Enter m /d/y");
		int m=sc.nextInt();
		int d=sc.nextInt();
		int y=sc.nextInt();
		
		Date date=new Date(d,m,y);
		date.incrementDay();
		System.out.println (date);
		
	}
}