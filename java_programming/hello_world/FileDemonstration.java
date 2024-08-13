package jhtp.ch14.console;

import java.io.File;
import java.util.Scanner;

public class FileDemonstration
{
	public void analyzePath(String path)
	{
		File name=new File(path);
		
		if(name.exists())
		{
			System.out.printf ("%s %s",name.getName(),"exists");
		}
		else
			System.out.printf ("\n%s %s",path ,"does not exist.");
	}
	
	public static void main (String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		FileDemonstration file=new FileDemonstration();
		
		System.out.println ("Enter file name");
		
		String p=input.nextLine();
		file.analyzePath(p);
	}
}