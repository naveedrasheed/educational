package jhtp.ch_8.console;

import java.util.Scanner;
import java.util.Calendar;

class Time2Test
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println ("Enter Time ");
		int h=sc.nextInt();
		int m=sc.nextInt();
		int s=sc.nextInt();
		
		Time2 time=new Time2(h,m,s,0,0,0);
		System.out.println (time);
		
		Calendar c=Calendar.getInstance();
		
		for (int i = 0; i<=600; i++)
		{
			if(i%60==0)
			{
				time.tick();
				System.out.println (time);
			}
		}
	}
}