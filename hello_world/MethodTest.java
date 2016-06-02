package jhtp.ch_10.console;

class MethodTest
{
	int i;
	public MethodTest()
	{
		
	}
	public static void main (String[] args)
	{
		MethodTest m=new MethodTest();
		
		nvd();
		
		MethodTest1 m1=new MethodTest1();
		m1.nvd();
	}
	public static void nvd()
		{
			System.out.println ("nvd");
			nvda();	
		}
	public static void nvda()
	{
		System.out.println ("j");
	}
}

class MethodTest1
{
	public void nvd()
	{
		System.out.println ("nvd1");
	}
}