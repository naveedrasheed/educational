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
	double ctcr=1.25;
	double ctor=2.00;
	BillCalc(double i,double j)
	{
		l=i;
		o=j;
	}
	double calcLocalCallBill(double nlc)
	{
		return nlc*ctcr;
	}
	double calcO_NetworkBill(double noc)
	{
		return noc*ctor;
	}
	double bill()
	{
		return calcLocalCallBill(l)+calcO_NetworkBill(o);
	}
	double totalBill()
	{
		double gst=gstCalc(bill());
		return bill()-gst;
	}
	public String toString()
	{
		return String.format("Total bill is %.3f",totalBill());
	}
}
class Comtel
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
		BillCalc r=new BillCalc(i,j);
		System.out.println (r);
		//javax.swing.JOptionPane.showMessageDialog(null,r);
	}
}