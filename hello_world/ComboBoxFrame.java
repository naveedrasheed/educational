package jhtp.ch_11.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComboBoxFrame extends JFrame
{
	private JComboBox comboBox;
	private JLabel label;
	private JTextField textField;
	
	private String pics[]={"Flower 14.jpg","civic-02.jpg"};
	private Icon ic[]={new ImageIcon(pics[0]),new ImageIcon(pics[1])};
	
	public ComboBoxFrame()
	{
		super("Testing Combo Box");
		setLayout(new FlowLayout());
		
		comboBox=new JComboBox(pics);
		comboBox.setMaximumRowCount(1);
		//comboBox.setEditable(true);
		comboBox.selectWithKeyChar('s');
		
		comboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent event)
			{
				if(event.getStateChange()==event.SELECTED)
					label.setIcon(ic[comboBox.getSelectedIndex()]);
			}
		});
		
		add(comboBox);
		label=new JLabel(ic[0]);
		add(label);
		
		textField=new JTextField("ff",7);
		textField.setEnabled(false);
		add(textField);
	}
}