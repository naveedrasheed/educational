import javax.swing.JFrame;
class Clocktest
{
	public static void main (String[] args)
	{
		Clock c=new Clock();
		//Clock_C t=new Clock_C();
		JFrame frame=new JFrame("Naveed");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250,250);
		frame.setVisible(true);
		frame.add(c);
	}
}