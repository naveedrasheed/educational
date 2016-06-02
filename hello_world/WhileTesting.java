package jhtp.ch_10.console;

class WhileTesting
{
	public static void main (String[] args)
	{
		int i=1;
		while (i<10)
		{
			System.out.print (i+" ");
			i++;
		}
		System.out.println ();
		i=0;
		while (++i<11)
			System.out.print (i+" ");
			
		System.out.println ();
			
		/*while (i>-1)
		{
			System.out.print (i+" ");
			{
				i--;
				i++;
				i--;
			}
		}*/
		
		System.out.println ();
		
		while (i==-1)
			System.out.print (i+" ");
			
		System.out.println ();
			
		//while(1==0) Unreachabal statment error
			System.out.println (++i);
	}
}