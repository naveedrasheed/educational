package jhtp.ch_8.gui;

import jhtp.ch_8.gui.Time2GUI;
import javax.swing.JFrame;

public class Time2GUI_Test 
{
	public static void main (String[] args)
	{
		Time2GUI c=new Time2GUI();
		JFrame frame=new JFrame("Timer Created By Naveed Rasheed");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(400,150);
		frame.setVisible(true);
		frame.add(c);
	}
}