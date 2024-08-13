package jhtp.ch_9.console;

import java.io.*;

class Tax
{
	double gstCalc(double bill)
	{
		return bill*0.15;
	}
}

class BillCalc extends Tax
{
	double l,o;
	BillCalc(double i,double j)
	{
		l=(i>=0.0)?i:0.0;
		o=(j>=0.0)?j:0.0;
	}
	double bill()
	{
		return l*1.25+o*2.00;
	}
	double totalBill()
	{
		double gst=gstCalc(bill());
		return bill()+gst;
	}
	public String toString()
	{
		return String.format("Total bill is %.3f",totalBill());
	}
}

class Comtel1
{
	public static void main (String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println ("Enter Number of Calls from CTC");
		String a=br.readLine();
		System.out.println ("Enter Number of Calls from CTO");
		String b=br.readLine();
		double i=Double.parseDouble(a);
		double j=Double.parseDouble(b);
		System.out.println ("Press 1 if You are POSTPAY Costmer");
		String c=br.readLine();
		int k=Integer.parseInt(c);
		if(k==1)
		{
			i=(i<=50)?0.0:i-50;
		}
		BillCalc charges=new BillCalc(i,j);
		System.out.println (charges);
	}
}