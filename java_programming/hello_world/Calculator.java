package jhtp.miniproject;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener    //Creating the main class
{
	private JMenuBar menuBar;    //Declaring all required objects
	private JMenu fileMenu, editMenu, helpMenu;
	private JMenuItem exitItem, copyItem, pasteItem, aboutItem, aboutAuthorItem;
	
	private JLabel logo;
	private JTextField textField;
	private JPanel keyPanel,textFieldPanel,cPanel;
	private MyClock clock;
	private JButton buttons,cb,ceb,bsb;
	private String buttonText[]={"7","8","9","/","sqrt","4","5","6","*","%","1","2","3","-","I/x","0","+/-",".","+","="};
	
	private boolean istEntry=true;
	private String binaryOperator="=", unaryOperator="", f="0";
	private double result, currentNumber;
	private int pointCounter, maxInput, operatorCounter;
	
	public Calculator()   // Constructor
	{
		super("Calculator Plus");     //Setting some attributes to frame
		setResizable(false);
		setLayout(new BorderLayout(1,1));
		
		MenuEventHandler handler=new MenuEventHandler();//Event handling class for menu bar & control buttons
		   
		fileMenu=new JMenu("File");    // Creating menus & menu items & setting their Mnemonic
		fileMenu.setMnemonic('F');    
			exitItem=new JMenuItem("Exit");
			exitItem.setMnemonic('x');
			exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,KeyEvent.ALT_MASK));
			exitItem.addActionListener(handler);
		fileMenu.add(exitItem);
		
		editMenu=new JMenu("Edit");
		editMenu.setMnemonic('E');
			copyItem=new JMenuItem("Copy",new ImageIcon("jhtp/pictures/copy.png"));
			copyItem.setMnemonic('C');
			copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK));
			copyItem.addActionListener(handler);
		editMenu.add(copyItem);
			pasteItem=new JMenuItem("Paste",new ImageIcon("jhtp/pictures/paste.png"));
			pasteItem.setMnemonic('P');
			pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_MASK));
			pasteItem.addActionListener(handler);
		editMenu.add(pasteItem);
		
		helpMenu=new JMenu("Help");
		helpMenu.setMnemonic('H');
			aboutItem=new JMenuItem("About Calc...");
			aboutItem.setMnemonic('A');
			aboutItem.addActionListener(handler);
		helpMenu.add(aboutItem);
		helpMenu.addSeparator();
			aboutAuthorItem=new JMenuItem("About Authors",'b');
			aboutAuthorItem.addActionListener(handler);
		helpMenu.add(aboutAuthorItem);
		
		menuBar=new JMenuBar();   //Setting up Menu Bar with all menues
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
		
		textFieldPanel=new JPanel(new GridLayout(2,1));    //Creating a Panel for Text & Time
		
		textField=new JTextField("0.",15);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);      //Setting text to right
		
		clock=new MyClock();     //Creating the object of Class Clock
		
		textFieldPanel.add(textField);
		textFieldPanel.add(clock);
		add(textFieldPanel,BorderLayout.NORTH);
		
		cPanel=new JPanel(new GridLayout(1,4,2,2));    //Control Panel
		
		logo=new JLabel(new ImageIcon("jhtp/pictures/logo1.png"));
		cPanel.add(logo);
		
		cb=new JButton("C");
			cb.setForeground(Color.RED);
			cb.setToolTipText("Clear All");
			cb.addActionListener(handler);
		ceb=new JButton("CE");
			ceb.setToolTipText("Clear Entry");
			ceb.setForeground(Color.RED);
			ceb.addActionListener(handler);		
		bsb=new JButton("Backspace");
			bsb.addActionListener(handler);
			bsb.setToolTipText(bsb.getLabel());
			bsb.setForeground(Color.RED);
		
		cPanel.add(bsb);
		cPanel.add(ceb);
		cPanel.add(cb);
		
		add(cPanel,BorderLayout.CENTER);
		
		keyPanel=new JPanel(new GridLayout(4,5,1,1));   //Key Panel && Number Buttons
		
		for (int i = 0; i<buttonText.length; i++)
		{
			buttons=new JButton(buttonText[i]);
			buttons.setToolTipText(buttonText[i]);
			buttons.addActionListener(this);
			keyPanel.add(buttons);
		}
		add(keyPanel,BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent event)    //Event handling
	{
		String s=event.getActionCommand();
		
		if(s.charAt(0) >= '0' & s.charAt(0) <='9' | s.equals("."))  //Setting the text to textfield
		{
			if(maxInput<30)    //Checking the number of digits in textfield
			{
				if(istEntry)   //Putting the First Entry every time
				{
					if(s.equals("."))
					{
						textField.setText("0"+s);
						pointCounter++;
					}
					else
						textField.setText(s);
				}
				else
				{
					if(s.equals("."))   //handling the point placement
					{
						if(pointCounter < 1)
						{
							textField.setText(textField.getText()+s);
							pointCounter++;
						}
						else
							Toolkit.getDefaultToolkit().beep();
				   }
					else if(s.equals("0"))       //handling the number of 0's
					{
						if(pointCounter!=0)
							textField.setText(textField.getText()+s);
						else if(textField.getText().charAt(0)!='0')
							textField.setText(textField.getText()+s);
					}
					else if(!s.equals(".") & !s.equals("0"))  //handling rest of the digits
						textField.setText(textField.getText()+s);
				}
			
				istEntry=false;
				maxInput++;
				operatorCounter=0;
			
				if(textField.getText().charAt(0)=='0' & pointCounter<1)
					istEntry=true;
			}
			else
				Toolkit.getDefaultToolkit().beep();
		}
		else
		{
			currentNumber=Double.parseDouble(textField.getText());
			
			if(s.equals("sqrt") | s.equals("%") | s.equals("I/x") | s.equals("+/-"))
			{
				unaryOperator=s;	
				performUnaryOperation(unaryOperator);
				textField.setText(""+currentNumber);			
			}				
			else
			{
				if(operatorCounter<1)
				{
					performBinaryOperation(binaryOperator);
					textField.setText(""+result);					
					binaryOperator=s;
				}
				else
					binaryOperator=s;
					
				operatorCounter++;
			}				
			istEntry=true;
			maxInput=pointCounter=0;
		}
	}
	
	public void performUnaryOperation(String unaryOperator)
	{
		if(unaryOperator=="I/x")
			currentNumber=1/currentNumber;
		else if(unaryOperator=="+/-")
			currentNumber=currentNumber*(-1);
		else if(unaryOperator=="%")
			currentNumber=currentNumber*(result/100);
		else if(unaryOperator=="sqrt")
			currentNumber=Math.sqrt(currentNumber);
	}
	
	public void performBinaryOperation(String binaryOperator)
	{
		if(binaryOperator=="+")
			result+=currentNumber;
		else if(binaryOperator=="-")
			result-=currentNumber;
		else if(binaryOperator=="*")
			result*=currentNumber;
		else if(binaryOperator=="/")
			result/=currentNumber;
		else if (binaryOperator=="=")
			result=currentNumber;
	}
	
	public JMenuBar getMyJMenuBar()
	{
		return getJMenuBar();
	}
	
	public static void main (String[] args)
	{
		Calculator frame=new Calculator();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(350,235);
		frame.setVisible(true);
		//frame.pack();
		frame.setLocation(150,150);
	}
	
	private class MenuEventHandler implements ActionListener    //Event handling class for menu & control panel
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==exitItem)
				System.exit(0);
			else if(e.getSource()==copyItem)
				f=textField.getText();
			else if(e.getSource()==pasteItem)
			{
				if(f.equals("0"))
					istEntry=true;
				else
					istEntry=false;
				for (int i = 0; i<f.length(); i++)
					if(f.charAt(i)=='.')
						pointCounter++;
				maxInput+=f.length();
				operatorCounter=0;
				textField.setText(f);
			}
			else if(e.getSource()==aboutItem)
				JOptionPane.showMessageDialog(Calculator.this,
				"Bce-soft ® Calculator Plus\nVersion 11.0.2\nCopyright © 2008 Bce-soft Corporation"
 ,"About Calculator",JOptionPane.PLAIN_MESSAGE, new ImageIcon("jhtp/pictures/logo.png"));
			
			else if(e.getSource()==aboutAuthorItem)
				JOptionPane.showMessageDialog(ceb,
				"Naveed Rasheed      Bce-sp07-34\nMuhammad Jamil    Bte-f06-66\nWaqas Raza             Bce-sp07-18"+
					"\n\nInstructor :            Sir Atif Saeed","About Authors",JOptionPane.PLAIN_MESSAGE);
			else if(e.getSource()==cb)
			{
				maxInput=pointCounter=0;
				currentNumber=result=0.0;
				istEntry=true;
				binaryOperator="=";
				unaryOperator="";
				textField.setText("0");
			}
			else if(e.getSource()==ceb)
			{
				maxInput=pointCounter=0;
				istEntry=true;
				textField.setText("0");
			}
			else if(e.getSource()==bsb)
			{
				String temp=textField.getText();
				if(temp.length()>1)
					textField.setText(temp.substring(0,temp.length()-1));
				else
				{
					textField.setText("0");
					istEntry=true;
				}
			}
		}
	}
}