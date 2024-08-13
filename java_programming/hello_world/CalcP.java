import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CalcP extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem exitItem;
	private JMenu editMenu;
	private JMenuItem copyItem;
	private JMenuItem pasteItem;
	private JMenu helpMenu;
	private JMenuItem aboutItem;
	
	private JLabel logo;
	private JTextField textField;
	private JPanel keyPanel,textFieldPanel, cPanel;
	private Clock_C clock;
	private JButton buttons, cb,ceb,bsb;
	private String buttonText[]={"7","8","9","/","sqrt","4","5","6","*","%","1","2","3","-","I/x","0","+/-",".","+","="};
	String f="0.";
	
	private boolean istEntry=true;
	private String binaryOperator="=";
	private String unaryOperator="";
	private double result;
	private double currentNumber;
	private int dot, maxInput, lastOperatorCounter;
	
	public CalcP()
	{
		super("Testing CalcP");
		setResizable(false);
		setLayout(new BorderLayout(2,2));
		pack();
		
		MenuEventHandler handler=new MenuEventHandler();
		fileMenu=new JMenu("File");
		fileMenu.setMnemonic('F');
			exitItem=new JMenuItem("Exit");
			exitItem.setMnemonic('x');
			exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,KeyEvent.ALT_MASK));
			exitItem.addActionListener(handler);
		fileMenu.add(exitItem);
		
		editMenu=new JMenu("Edit");
		editMenu.setMnemonic('E');
			copyItem=new JMenuItem("Copy",new ImageIcon("copy.png"));
			copyItem.setMnemonic('C');
			copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK));
			copyItem.addActionListener(handler);
		editMenu.add(copyItem);
			pasteItem=new JMenuItem("Paste",new ImageIcon("paste.png"));
			pasteItem.setMnemonic('P');
			pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_MASK));
			pasteItem.addActionListener(handler);
		editMenu.add(pasteItem);
		
		helpMenu=new JMenu("Help");
		helpMenu.setMnemonic('H');
		helpMenu.addSeparator();
			aboutItem=new JMenuItem("about...");
			aboutItem.setMnemonic('a');
			aboutItem.addActionListener(handler);
		helpMenu.add(aboutItem);
		
		menuBar=new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
		
		textFieldPanel=new JPanel(new GridLayout(2,1));
		textField=new JTextField("0.",15);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		
		clock=new Clock_C();
		
		textFieldPanel.add(textField);
		textFieldPanel.add(clock);
		add(textFieldPanel,BorderLayout.NORTH);
		
		cPanel=new JPanel(new GridLayout(1,4,2,2));
		
		logo=new JLabel(new ImageIcon("cut.png"));
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
		
		keyPanel=new JPanel(new GridLayout(4,5,2,2));
		
		for (int i = 0; i<buttonText.length; i++)
		{
			buttons=new JButton(buttonText[i]);
			buttons.setToolTipText(buttonText[i]);
			buttons.addActionListener(this);
			keyPanel.add(buttons);
		}
		add(keyPanel,BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String s=event.getActionCommand();
		
		if(s.charAt(0) >= '0' && s.charAt(0) <='9' || s.equals("."))
		{
			if(maxInput<30)
			{ 
				if(istEntry)
				{
					if(s.equals("."))
					{
						textField.setText("0"+s);
						dot++;
					}
					else
						textField.setText(s);
				}
				else
				{
					if(s.equals(".") && dot<1 )
					{
						textField.setText(textField.getText()+s);
						dot++;
					}
					else if(s.equals("0"))
					{
						if(dot!=0)
							textField.setText(textField.getText()+s);
						else if(textField.getText().charAt(0)!='0')
							textField.setText(textField.getText()+s);
					}
					else if(!s.equals(".") && !s.equals("0"))
						textField.setText(textField.getText()+s);
				}
			
				istEntry=false;
				maxInput++;
				lastOperatorCounter=0;
			
				if(textField.getText().charAt(0)=='0'&&dot<1)
					istEntry=true;
			}
			else 
				;
		}
		else
		{
			currentNumber=Double.parseDouble(textField.getText());
			
			if(s.equals("sqrt")||s.equals("%")||s.equals("I/x")||s.equals("+/-"))
			{
				unaryOperator=s;
				
				if(unaryOperator=="I/x")
					currentNumber=1/currentNumber;
				else if(unaryOperator=="+/-")
					currentNumber=currentNumber*(-1);
				else if(unaryOperator=="%")
					currentNumber=currentNumber*(result/100);
				else if(unaryOperator=="sqrt")
					currentNumber=Math.sqrt(currentNumber);	
				textField.setText(""+currentNumber);	
			}				
			else
			{
				if(lastOperatorCounter<1)
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
					textField.setText(""+result);
					binaryOperator=s;
				}
				else
					binaryOperator=s;
				lastOperatorCounter++;
			}
			istEntry=true;
			maxInput=dot=0;
		}
	}
	
	public static void main (String[] args)
	{
		CalcP frame=new CalcP();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(300,235);
		frame.setVisible(true);
		frame.setLocation(150,150);
	}
	
	private class MenuEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==exitItem)
				System.exit(0);
			else if(e.getSource()==copyItem)
				f=textField.getText();
			else if(e.getSource()==pasteItem)
				{
					textField.setText(f);
					istEntry=false;
					maxInput++;
					lastOperatorCounter=0;
				}
			else if(e.getSource()==aboutItem)
				JOptionPane.showMessageDialog(CalcP.this,"BCE Rox","About CalcP",JOptionPane.PLAIN_MESSAGE);
			
			else if(e.getSource()==cb)
			{
				maxInput=dot=0;
				currentNumber=result=0.0;
				istEntry=true;
				binaryOperator="=";
				unaryOperator="";
				textField.setText("0.");
			}
			else if(e.getSource()==ceb)
			{
				maxInput=dot=0;
				istEntry=true;
				textField.setText("0.");
			}
			else if(e.getSource()==bsb)
			{
				String temp=textField.getText();
				if(temp.length()>1)
					textField.setText(temp.substring(0,temp.length()-1));
				else
				{
					textField.setText("0.");
					istEntry=true;
				}
			}
		}
	}
}