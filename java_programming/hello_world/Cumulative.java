package jhtp.ch_4.console;
import java.io.*;

class Cumulative
{
	public static void main (String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ans=1;
		int n=0;
		/*while(n!=-9777)
		{
			System.out.print("Enter a number: ");
			String a=br.readLine();
			n=Integer.parseInt(a);
			while(n!=-9777)
			{
				ans*=n;
				System.out.println ("Cumulative Product = "+ans+"\n\n");
				break;
			}
		}
		System.out.println ("Cumulative Product = "+ans);*/
		while (n!=-9777)
		{
			System.out.print("Enter a number: ");
			String a=br.readLine();
			n=Integer.parseInt(a);
			if(n!=-9777)
				ans*=n;
				System.out.println ("Cumulative Product = "+ans+"\n\n");
		}
	}
}