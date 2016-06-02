package jhtp.ch_6.console;
import java.util.Random; 

public class Roll_Dice_Util
{
	public static void main(String args[])
	{
		System.out.println("Welcome");
		Random r=new Random();
		int a=r.nextInt(3);
		System.out.println(a);
	}
}