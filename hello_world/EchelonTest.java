import java.util.Scanner;

class EchelonTest
{	
	int col;
	double B[][]=new double[2][2];
	
	public static void main (String[] args)
	{
		Scanner stinp=new Scanner(System.in);
		
		double A[][]={{1,0},{2,3}};
		
		EchelonTest e=new EchelonTest();
		
		for (int i = 0; i<A.length; i++)
		{
			for (int j = 0; j<A[i].length; j++)
			{
				System.out.print ("Enter A["+(i+1)+"]["+(j+1)+"]: ");
				A[i][j]=stinp.nextDouble();
			}
		}
		System.out.println ("\nMatrix is");
		for (int i = 0; i<A.length; i++)
		{
			for (int j = 0; j<A[i].length; j++)
			{
				System.out.printf (" %.2f",A[i][j]);
			}
			System.out.println ();
		}
		e.B=A;
		
		e.makeEchelon();
		
		for (int i = 0; i<e.B.length; i++)
		{
			for (int j = 0; j<e.B[i].length; j++)
			{
				System.out.printf (" %.2f",e.B[i][j]);
			}
			System.out.println ();
		}
	}
	
	public void makeDigits0()
	{
		double y=(-1)*B[col+1][col];
		int row=col;
		for(int colu=0; colu<B.length; colu++)
		{
			B[row+1][colu]+=(y*B[row][colu]);
		}
	}
	public void makeDigit1()
	{
		double x=B[col][col];
		int row=col;
		for(int colu=0; colu<B.length; colu++)
		{
			B[row][colu]/=x;
		}
	}
	public void interchangRows()
	{
		int row=col;
		double s=0.0;
		for(int c=0; c<B.length; c++)
		{
			s=B[row][c];
			B[row][c]=B[row+1][c];
			B[row+1][c]=s;
		}
		
		try
		{
			makeEchelon();
		}
		catch(ArrayIndexOutOfBoundsException ae)
		{
			System.out.println (ae+" interchang rows");
		}
	}
	
	public void makeEchelon()
	{
		abc:
		for(col=0 ;col<B.length; col++)
		{
			for(int row=0 ;row< B[col].length ;row++)
			{
				if(row==col)
				{
					if(B[row][col]!=0.0)
					{
						if(B[row][col]==1)
							makeDigits0();
						else
						{
							makeDigit1();
							try
							{
								makeDigits0();
							}
							catch(ArrayIndexOutOfBoundsException ae)
							{
								System.out.println (ae + " making digit zero");
							}
						}
					}
					else
					{
						try
						{
							interchangRows();
							continue abc;
						}
						catch(ArrayIndexOutOfBoundsException ae)
						{
							System.out.println (ae+" calling to interchanging rows");
						}
					}
				}
			}
			System.out.println ();
		}
	}
}