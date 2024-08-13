package jhtp.lastpaper;

class Vehicle
{
	public void drive(int i)
	{
		System.out.println ("Vehical drive");
	}
}
class Car extends Vehicle
{
	public void drive(int i)
	{
		System.out.println ("Car drive");
	}
}

public class Test
{
	public static void main (String[] args)
	{
		Vehicle v;
		Car c;
		v=new Vehicle();
		c=new Car();
		v.drive(7);
		c.drive(2);
		v=c;
		v.drive(7);
	}
}