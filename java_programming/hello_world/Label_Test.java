package jhtp.ch_9.gui;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Label_Test
{
	public static void main (String[] args)
	{
		JLabel north=new JLabel("North");
		
		ImageIcon iconcenter=new ImageIcon("civic-02.jpg");
		JLabel center=new JLabel(iconcenter);
		
		ImageIcon iconsouth=new ImageIcon("Flower 14.jpg");
		JLabel south=new JLabel(iconsouth);
		south.setText("South");
		
		JFrame frame=new JFrame("Naveed");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.add(north,BorderLayout.NORTH);
		frame.add(center,BorderLayout.CENTER);
		frame.add(south,BorderLayout.SOUTH);
	}
}