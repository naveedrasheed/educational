package jhtp.ch_8.console;

import jhtp.ch_8.console.Date;

public class Time2 extends Date
{
	private int minute,hour,second;
	
	public Time2(int h,int m,int s,int d,int mon,int y)
	{
		super(d,mon,y);
		setTime(h,m,s);
	}
	public void setTime(int h,int m,int s)
	{
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
	public void setHour(int h)
	{
		hour=(h>=0&&h<24)?h:0;
	}
	public void setMinute(int m)
	{
		minute=(m>=0&&m<60)? m:0;
	}
	public void setSecond(int s)
	{
		second=(s>=0&&s<60) ?s:0;
	}
	public int getHour()
	{
		return hour;
	}
	public int getMinute()
	{
		return minute;
	}
	public int getSecond()
	{
		return second;
	}
	public String toUniversalString()
	{
		return String.format("%02d:%02d:%02d",hour,minute,second);
	}
	public String toString()
	{
		return String.format("%d:%02d:%02d %s \n\n%s",((hour==0||hour==12)?12:hour%12),minute,second,(hour<12)?"AM":"PM",super.toString());
	}
	public void tick()
	{
		setSecond(++second);
		if(second==0)
			incrementMinute();
		//System.out.println (second);
	}
	public void incrementMinute()
	{
			setMinute(++minute);
			if(minute==0)
				incrementHour();
			//System.out.println (minute);
	}
	public void incrementHour()
	{
			setHour(++hour);
			//System.out.println (hour);
			if(hour==0)
				incrementDay();
	}
}