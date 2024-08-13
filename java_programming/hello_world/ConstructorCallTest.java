//package jhtp.ch_9.console;

import jhtp.ch_9.console.*;

class Vehical
{
	private String name;
	private int number;
	
	Vehical(String n, int num)
	{
		name=n;
		number=num;
		
		System.out.println ("Vehical  " + this);
		System.out.println ();
	}
	
	public String toString()
	{
		return String.format("%s   %,02d",name,number);
	}
}

class BMW extends Vehical
{
	private String color;
	
	BMW(String n, int num, String c)
	{
		super(n,num);
		color=c;
		
		System.out.println ("BMEW   "+this );
	}
	
	BMW()
	{
		//super("ghj",98);
		this("QA",1021,"green");
		
		color="pine";
		
	}
	public String toString()
	{
		return String.format("Naveed %s %20s",super.toString(),color);
	}
}

class ConstructorCallTest
{
	public static void main (String[] args)
	{
		BMW car=new BMW("BMW",2008,"red");
		//BMW car1=new BMW();
	}
}