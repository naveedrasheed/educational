package jhtp.ch_8.console;

import java.util.Scanner;
import java.util.Calendar;
import javax.swing.JFrame;
import jhtp.ch_8.console.Time2;

public class Time2_Test
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println ("Enter Time ");
		int h=sc.nextInt();
		int m=sc.nextInt();
		int s=sc.nextInt();
		
		Time2 time=new Time2(h,m,s);
		System.out.println (time);
		
		//Calendar c=Calendar.getInstance();
		
		/*JFrame frame=new JFrame("Naveed");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250,250);
		frame.setVisible(true);
		frame.add(time.toString());*/
	}
}