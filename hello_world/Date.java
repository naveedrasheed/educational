package jhtp.ch_8.console;

public class Date
{
	private int month,day,year;
	public Date(int d,int m,int y)
	{
		month=checkMonth(m);
		year=y;
		day=checkDay(d);
		System.out.println (this);
	}
	private int checkMonth(int m)
	{
		return m=(m>0&&m<=12)?m:1;
	}
	private int checkDay(int d)
	{
		int daysPerMonth[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
		if (d>0&&d<=daysPerMonth[month])
			return d;
			
			if(month==2&&d==29&&(year%400==0||(year%4==0&&year%100!=0)))
			{
				System.out.println ("leap Year");
				return d;
			}	
				return 1;
	}
	public String toString()
	{
		return String.format("%d/%d/%d",day,month,year);
	}
	public void incrementDay()
	{
		day=checkDay(++day);//System.out.println (day);
		if (day==1)
			incrementMonth();
	}
	public void incrementMonth()
	{
		month=checkMonth(++month);
		if(month==1)
			++year;
	}
}