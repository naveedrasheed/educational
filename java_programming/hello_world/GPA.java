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
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GPA extends JPanel implements ActionListener
{
	public JTextField tf[]=new JTextField[12];
	public JLabel l1, l2 ,l3, l4;
	public JButton calculateButton, exitButton;
	public JPanel marksPanel, creditPanel;
	public JTextField gpaField, tc;
	public Font textFont;
	public GPA()
	{				
		setLayout(new GridLayout(1,2,2,2));
		
		marksPanel=new JPanel(new GridLayout(10, 1, 2, 2));
		
		creditPanel= new JPanel(new GridLayout(10, 1, 2, 2));
		
		l1= new JLabel("Enter Marks (1-100)");
		marksPanel.add(l1);
		
		l2 = new JLabel("Enter CreditHour (1-4)");
		creditPanel.add(l2);
		
		for (int i = 0; i<tf.length; i++)
		{
			if(i%2==0)
			{
				tf[i]=new JTextField();
				marksPanel.add(tf[i]);
			}
			else
			{
				tf[i]=new JTextField();
				creditPanel.add(tf[i]);
			}
		}
		
		l3=new JLabel("Your GPA");
		marksPanel.add(l3);
		
		l4=new JLabel("Total Credit Hour");
		creditPanel.add(l4);
		
		textFont=new Font(Font.SANS_SERIF,Font.BOLD,15);
		
		gpaField=new JTextField();
		gpaField.setEditable(false);
		gpaField.setFont(textFont);
		marksPanel.add(gpaField);
		
		tc= new JTextField();
		tc.setEditable(false);
		tc.setFont(textFont);
		creditPanel.add(tc);
		
		calculateButton = new JButton("Calculate GPA");
		calculateButton.addActionListener(this);
		marksPanel.add(calculateButton);
		
		exitButton=new JButton("Exit");
		exitButton.addActionListener(this);
		creditPanel.add(exitButton);
		
		add(marksPanel);
		add(creditPanel);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exitButton)
			System.exit(0);
		else if(e.getSource()==calculateButton)
		{
			int totalCredit=0, subNumber=0, subCredit=0;
			double gpa=0.0;
			
			for (int i = 0; i<tf.length; i++)
			{
				if(i%2==0)
				{
					try
					{
						subNumber=Integer.parseInt(tf[i].getText());
						subCredit=Integer.parseInt(tf[i+1].getText());
					}
					catch(ArithmeticException ae)
					{
						tc.setText("Credit Hours must not 0");
					}
					catch(NumberFormatException nfe)
					{
						gpaField.setText("Enter a valid number");
					}
					gpa+=subjectGPA(subNumber)*subCredit;
				}
				else
					totalCredit+=subCredit;
			}
			tc.setText(""+totalCredit);
			gpaField.setText(String.format("%.4f",gpa/totalCredit));
			repaint();
		}
	}
	
	public double subjectGPA(int i)
	{
		if(i>=90)
			return 4;
		else if(i>=85 & i<90)
			return 3.7;
		else if(i>=80 & i<84)
			return 3.3;
		else if(i>=75 & i<79)
			return 3.0;
		else if(i>=70 & i<74)
			return 2.7;
		else if(i>=65 & i<69)
			return 2.3;
		else if(i>=60 & i<64)
			return 2.0;
		else if(i>=55 & i<59)
			return 1.7;
		else if(i>=50 & i<54)
			return 1.3;
		else
			return 0.0;
	}
}

class  GPATest extends JFrame implements ActionListener
{
	public JRadioButtonMenuItem gpaItem, cgpaItem;
	public ButtonGroup g;
	
	MyJMenuBar m;
	CGPA cgpaPanel;
	GPA gpaPanel;
	
	GPATest()
	{
		super("GPA Calculator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		m=new MyJMenuBar();
		
		m.exitItem.addActionListener(this);
		m.remove(m.editMenu);
		gpaItem=new JRadioButtonMenuItem("GPA", true);
		gpaItem.setMnemonic('G');
		gpaItem.addActionListener(this);
		cgpaItem=new JRadioButtonMenuItem("CGPA", false);
		cgpaItem.setMnemonic('c');
		cgpaItem.addActionListener(this);
				
		g=new ButtonGroup();
		g.add(gpaItem);
		g.add(cgpaItem);
		
		m.viewMenu.add(gpaItem);
		m.viewMenu.add(cgpaItem);
		m.aboutItem.addActionListener(this);
		m.aboutAuthorItem.addActionListener(this);
		
		setJMenuBar(m);
		
		cgpaPanel=new CGPA();
		
		gpaPanel=new GPA();
		add(gpaPanel);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==gpaItem)
		{
			setVisible(false);
			remove(cgpaPanel);
			add(gpaPanel);
			setVisible(true);
		}
		else if(e.getSource()==cgpaItem)
		{
			setVisible(false);
			remove(gpaPanel);
			add(cgpaPanel);
			setVisible(true);
		}
		else if(e.getSource()==m.aboutItem)
			JOptionPane.showMessageDialog(null,"GPA Calculator 11.1" ,
				"About GPA Calculator",JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main (String[] args)
	{
		GPATest f=new GPATest();
		f.pack();
		f.setLocation(150,150);
		f.setVisible(true);
	}
}