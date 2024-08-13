class SubStringTest
{
	public static void main (String[] args)
	{
		int z=2;
		String a="fdghjbjk";
		for (int i = 0; i<a.length(); i++)
		{
			if(a.substring(i,(i+1)).equals("b"))
				z++;
				System.out.println (z);
		}
	}
}