package jhtp.ch_11.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TextFieldFrame extends JFrame
{
	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JPasswordField passwordField;
	
	public TextFieldFrame()
	{
		super("Testing Event Hanling");
		setLayout(new FlowLayout());
		
		textfield1=new JTextField(10);
		add(textfield1);
		
		textfield2=new JTextField("Naveed");
		add(textfield2);
		
		textfield3=new JTextField("Uneditable Text",21);
		textfield3.setEditable(false);
		add(textfield3);
		
		passwordField=new JPasswordField("Hidden Text");
		passwordField.setToolTipText("This is a password field");
		add(passwordField);
		
		TextFieldHandler handler=new TextFieldHandler();
		textfield1.addActionListener(handler);
		textfield2.addActionListener(handler);
		textfield3.addActionListener(handler);
		passwordField.addActionListener(handler);
	}
	
	private class TextFieldHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String output="";
			
			if(event.getSource()==textfield1)
				output=String.format("%s %s",textfield1.getClass().getName(),event.getActionCommand());
			
			else if(event.getSource()==textfield2)
				output=String.format("%s %s ",textfield2.getClass().getName(),event.getActionCommand());
			
			else if(event.getSource()==textfield3)
				output=String.format("%s %s",textfield3.getClass().getName(),event.getActionCommand());
			
			else if(event.getSource()==passwordField)
				output=String.format("%s %s",passwordField.getClass().getName(),new String(passwordField.getPassword()));
				
			JOptionPane.showMessageDialog(null,output);
		}
	}
}