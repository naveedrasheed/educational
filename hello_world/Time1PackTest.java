import jhtp.ch_8.console.Time1;
import java.util.Scanner;

class Time1PackTest
{
	public static void main (String[] args)
	{
		Time1 time=new Time1();
		Scanner sc=new Scanner(System.in);
		
		System.out.println (time);
		System.out.println ("Enter time ");
		int h=sc.nextInt();
		int m=sc.nextInt();
		int s=sc.nextInt();
		
		time.setTime(h,m,s);
		System.out.println ("uni "+time.toUniversalString());
		System.out.println (time);
	}	
}