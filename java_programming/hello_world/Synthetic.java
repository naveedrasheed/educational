import java.util.Scanner;

public class Synthetic
{
	public static void main (String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		int c[]=new int[5];
		char o='a';
		int res=0;
		for(int i=0;i<c.length;i++)
		{
			System.out.println ("Enter "+o);
			c[i]=input.nextInt();
			o++;
		}
		System.out.printf ("%s %8s\n","index","value");
		for (int i = 0; i<c.length; i++)
			System.out.println (i+"   "+c[i]);
	}
}