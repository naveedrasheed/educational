import javax.swing.JFrame;
import javax.swing.JSeparator;
import jhtp.miniproject.*;

class Testi
{
	public static void main (String[] args)
	{
		jhtp.miniproject.GPA g=new jhtp.miniproject.GPA();
		jhtp.miniproject.CGPA c=new jhtp.miniproject.CGPA();
		
		JSeparator s=new JSeparator(javax.swing.SwingConstants.VERTICAL);
		
		JFrame f=new JFrame();
		f.add(g.gpaPanel,"East");
		f.add(s);
		f.add(c, "West");
		f.pack();
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setDefaultLookAndFeelDecorated(true);
		f.setVisible(true);	
	}
}