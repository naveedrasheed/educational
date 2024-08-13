package jhtp.ch_2.console;

class CastingTest
{
	public static void main (String[] args)
	{
		int i=8;
		
		double j=9.5;
		
		char a='a';
		
		String s="b";
		
		//i=(int) j;
		
		System.out.println (i);
		
		j=i;
		
		System.out.println (j);
		
		a= (char )  i;
		
		System.out.println (a);
		
		
		//a=(char )  s;             error inconvertible types
	}
}