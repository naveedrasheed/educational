package jhtp.ch_11.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class CheckBoxFrame extends JFrame
{
	private JTextField textField;
	private JCheckBox boldBox;
	private JCheckBox italicBox;
	
	public CheckBoxFrame()
	{
		super("Testing Check Box");
		setLayout(new FlowLayout());
		
		textField=new JTextField("Watch Font Style",22);
		textField.setFont(new Font("serif",Font.PLAIN,14));
		add(textField);
		
		boldBox=new JCheckBox("Bold");
		add(boldBox);
		
		italicBox=new JCheckBox("Italic");
		add(italicBox);
		
		CheckBoxHandler handler=new CheckBoxHandler();
		boldBox.addItemListener(handler);
		italicBox.addItemListener(handler);
	}
	
	private class CheckBoxHandler implements ItemListener
	{
		private int valBold=Font.PLAIN;
		private int valItalic=Font.PLAIN;
		
		public void itemStateChanged(ItemEvent event)
		{
			if(event.getSource()==boldBox)
				valBold=boldBox.isSelected() ? Font.BOLD : Font.PLAIN;
				
			if(event.getSource()==italicBox)
				valItalic=italicBox.isSelected() ? Font.ITALIC : Font.PLAIN;
				
			textField.setFont(new Font("serif",valBold+valItalic,14));
		}
	}
}