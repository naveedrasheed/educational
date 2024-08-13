package jhtp.ch_3.console;

public class StaticMethodTest
{
	static public void displayMessage()
	{
		System.out.println ("Test");
		String a[]={"k","l"};
		main(a);
	}
	
	public static void main (String[] args)
	{
		//this.displayMessage();  non-static variable this cannot be referenced from a static context
		System.out.println ("Testing main");
		double z='9';
		System.out.println (z);
		//displayMessage();
	}
}