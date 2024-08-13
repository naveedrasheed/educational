package jhtp.miniproject;

import jhtp.jutil.MyJMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CGPA extends JPanel implements ActionListener
{
	JTextField tf[]=new JTextField[8];
	JLabel l1, l2;
	JButton calculateButton;
	JTextField cgpaField;
	public Font textFont;
	
	public CGPA()
	{
		super(new GridLayout(12,1,1,1));
		
		l1=new JLabel("Enter GPA (1-4)");
		add(l1);
		
		for (int i=0; i<tf.length; i++)
		{
			tf[i]=new JTextField();
			add(tf[i]);
		}
			
		l2=new JLabel("Your CGPA is ");
		add(l2);
		
		textFont=new Font(Font.SANS_SERIF,Font.BOLD,15);
		
		cgpaField=new JTextField();
		cgpaField.setEditable(false);
		cgpaField.setFont(textFont);
		add(cgpaField);
		
		calculateButton=new JButton("CGPA");
		calculateButton.addActionListener(this);
		add(calculateButton);
		
		setSize(100,200);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		double a=0;
		int j=0;
		for (int i = 0; i<tf.length; i++)
		{
			if(!tf[i].getText().equals(""))
			{
				a+=Double.parseDouble(tf[i].getText());
				j++;
			}
		}
		cgpaField.setText(""+a/j);
	}
}