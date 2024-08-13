import java.util.Scanner;

class E3
{	
	int row, col;
	boolean chek;
	double B[][];
	
	E3(int r, int c)
	{
		B=new double[r][c];
	}
	public static void main (String[] args)
	{
		Scanner stinp=new Scanner(System.in);
		
		System.out.print ("Enter no of rows: ");
		int r=stinp.nextInt();
		
		System.out.print ("Enter no of columns: ");
		int c=stinp.nextInt();
		
		double A[][]=new double [r][c];
		
		E3 e=new E3(r, c);
		
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
	{System.out.println ("making digit 0");
		for(int a=1; a<B.length; a++)
		{
			double y=1;
			if( B[row+a][col]!= 0.0)
				y=(-1)*B[row+a][col];
			else
				break;
			for(int c=0; c<B[col].length; c++)
			{
				B[row+a][c]+=(y*B[row][c]);
			}
		}
	}
	public void makeDigit1()
	{System.out.println ("making 1");
		double x=B[row][col];
		for(int c=0; c<B.length; c++)
		{
			B[row][c]/=x;
		}
	}
	public void interchangRows()
	{System.out.println ("interchanging");
		double s=0.0;
		for(int a=1; a<B.length ; a++)
		{
			if(B[row+a][c] == 0.0)
				continue;
			else
				for(int c=0; c<B[row].length-1; c++)
				{
					s=B[row][c];
					B[row][c]=B[row+a][c];
					B[row+a][c]=s;
					chek=false;
				}
		}
	}
	
	public void makeEchelon()
	{boolean entry=false;
		for( ;col<B[row].length; col++)
		{
			for( ;row< B.length ;row++)
			{System.out.println ("processing a["+row+"]["+col+"] = "+B[row][col]);
					if(B[row][col]==0.0)
					{
						if(row<B.length-1)
						{
							interchangRows();
							if(chek)
								break;
						}						
					}
					if(B[row][col]==1)
					{
						if(row<B.length-1)
							makeDigits0();
						row++;System.out.println (" after processing a["+row+"]["+col+"] = "+B[row][col]);
						break;
					}
					else
					{
						makeDigit1();
						if(row<B.length-1)
							makeDigits0();
						row++;System.out.println (" after processing a["+row+"]["+col+"] = "+B[row][col]);
						break;
					}
			}
			System.out.println ();
		}
	}
}