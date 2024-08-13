package jhtp.ch_11.gui;

import jhtp.ch_11.gui.ButtonFrame;

public class ButtonFrameTest
{
	public static void main (String[] args)
	{
		ButtonFrame frame=new ButtonFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(350,250);
		frame.setVisible(true);
	}
}