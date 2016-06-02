package jhtp.ch_11.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame
{
	private JButton plainButton;
	private JButton fancyButton;
	
	public ButtonFrame()
	{
		super("Button Testing");
		setLayout(new FlowLayout());
		
		plainButton=new JButton("Plain Button");
		add(plainButton);
		
		Icon pic1=new ImageIcon("civic-02.jpg");
		Icon pic2=new ImageIcon("Flower 14.jpg");
		fancyButton=new JButton("Fancy Button",pic1);
		fancyButton.setRolloverIcon(pic2);
		add(fancyButton);
		
		ButtonHandler handler=new ButtonHandler();
		plainButton.addActionListener(handler);
		fancyButton.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(ButtonFrame.this,String.format("You Pressed: %s",event.getActionCommand()));
			Toolkit.getDefaultToolkit().beep();
				
		}
	}
}