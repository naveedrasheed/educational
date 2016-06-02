package jhtp.ch_8.console;

class FinalVarTest
{
	public final int i;
	
	FinalVarTest()
	{
		i=10;
	}
	
	public FinalVarTest(int a)
	{
		i=5;
	}
	
	public static void main (String[] args)
	{
		FinalVarTest f=new FinalVarTest();
		
		System.out.println (f.FinalVarTest());
	}
	
	public int FinalVarTest()
	{
		return i;
	}
}