package jhtp.ch_11.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame
{
	private JRadioButton plainRadioButton;
	private JRadioButton italicRadioButton;
	private JRadioButton boldRadioButton;
	private JRadioButton boldItalicRadioButton;
	
	private Font plainFont;
	private Font italicFont;
	private Font boldFont;
	private Font boldItalicFont;
	private JTextField textField;
	
	private ButtonGroup group;
	
	public RadioButtonFrame()
	{
		super("Testing Radio Button");
		setLayout(new FlowLayout());
		
		textField=new JTextField(25);
		add(textField);
		
		plainRadioButton=new JRadioButton("Plain",false);
		italicRadioButton=new JRadioButton("Italic",false);
		boldRadioButton=new JRadioButton("Bold",false);
		boldItalicRadioButton=new JRadioButton("Bold/Italic",false);
		add(plainRadioButton);
		add(italicRadioButton);
		add(boldRadioButton);
		add(boldItalicRadioButton);
		
		group=new ButtonGroup();
		group.add(plainRadioButton);
		group.add(italicRadioButton);
		group.add(boldRadioButton);
		group.add(boldItalicRadioButton);
		
		plainFont=new Font("serif",Font.PLAIN,15);
		italicFont=new Font("serif",Font.ITALIC,15);
		boldFont=new Font("serif",Font.BOLD,15);
		boldItalicFont=new Font("serif",Font.BOLD+Font.ITALIC,15);
		
		plainRadioButton.addItemListener(new RadioButtonHandler(plainFont));
		italicRadioButton.addItemListener(new RadioButtonHandler(italicFont));
		boldRadioButton.addItemListener(new RadioButtonHandler(boldFont));
		boldItalicRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));
	}
	
	private class RadioButtonHandler implements ItemListener
	{
		private Font font;
		
		RadioButtonHandler(Font f)
		{
			font=f;
		}
		
		public void itemStateChanged(ItemEvent event)
		{
			textField.setFont(font);
		}
	}
}