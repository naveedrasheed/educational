package jhtp.lastpaper;

class Base
{
	int var;
	Base(double var)
	{
		this.var=(int) var;
	}
	
	Base(int var)
	{
		this("hello");
	}
	Base(String s)
	{
			this();
			System.out.println (s);
	}
	Base()
	{
		System.out.println ("good-bye");
	}
	public static void main (String[] args)
	{
		Base t=new Base(5);
	}	
}