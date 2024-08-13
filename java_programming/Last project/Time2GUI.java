import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;

public class Time2GUI extends JFrame
{
	private Time2 time;
	private JComboBox itemList,itemNumber;
	private String items[]={"Hour","Minute","Second","Day","Month","Year"};
	private String count[]=new String[60];
	private JTextField timeField;
	private Random ranGen=new Random();
	private Calendar c=Calendar.getInstance();
	private Timer t;
	private JPanel panel,panel2;
	private Container container=new Container();
	private ClockTickAction handler;
	private JButton buttons[];
	private String buttonNames[]={"Start","Stop","Change Time","Local Time","Alarm","About Timer"};
	
	public Time2GUI()
	{
		super("Timer of BCE");
		setResizable(false);
		setVisible(true);
		//setAlwaysOnTop(true);
		setDefaultCloseOperation(super.EXIT_ON_CLOSE);
		
		panel2=new JPanel(new GridLayout(1,2,7,7));
		
		itemList=new JComboBox(items);
		itemList.setMaximumRowCount(4);
		
		for(int i=0;i<count.length;i++)
			count[i]=String.valueOf(i+1);
		
		itemNumber=new JComboBox(count);
		itemNumber.setMaximumRowCount(12);
		
		panel2.add(itemNumber);
		panel2.add(itemList);
		
		panel=new JPanel(new GridLayout(2,3));
		
		timeField=new JTextField();
		timeField.setColumns(15);
		timeField.setFont(new Font("serif",Font.ITALIC+Font.BOLD,35));
		timeField.setHorizontalAlignment(SwingConstants.CENTER);
		timeField.setEditable(false);
		timeField.setToolTipText("This is a one second timer");
		add(timeField);
		
		time=new Time2(23,59,50,28,2,2004);
		
		buttons=new JButton[buttonNames.length];
		for(int i=0;i<buttonNames.length;i++)
		{
			buttons[i]=new JButton(buttonNames[i]);
			panel.add(buttons[i]);
		}
		add(panel,BorderLayout.SOUTH);
		add(panel2,BorderLayout.NORTH);
		
		handler=new ClockTickAction();
		
		for(JButton currentbutton : buttons)
			currentbutton.addActionListener(handler);
		
		t=new Timer(1000,handler);
		t.start();
	}
	
	private class ClockTickAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String res=event.getActionCommand();
			if(res==buttonNames[0])
			{
				t.start();
				buttons[0].setEnabled(false);
				buttons[1].setEnabled(true);
			}
			else if(res==buttonNames[1])
			{
				t.stop();
				buttons[1].setEnabled(false);
				buttons[0].setEnabled(true);
			}
			else if(res==buttonNames[2])
			{
				t.stop();
				String s=JOptionPane.showInputDialog(null,"Enter Hour");
				int h=Integer.parseInt(s);
				time.setHour(h);
				t.start();				
			}
			else if(res==buttonNames[3])
			{
				t.start();
				int h=c.get(c.HOUR_OF_DAY);
				int m=c.get(c.MINUTE);
				int s=c.get(c.SECOND);
				int d=c.get(c.DAY_OF_MONTH);
				int mon=1+c.get(c.MONTH);
				int y=c.get(c.YEAR);
				
				time=new Time2(h,m,s,d,mon,y);
			}
			else if(res==buttonNames[4])
			{
				JOptionPane.showMessageDialog(null,"Under Construction","Sorry",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(res==buttonNames[5])
			{
				JOptionPane.showMessageDialog(null,"This timer is created by Naveed Rasheed of BCE-11"+
					".\n It display time with different colors & fonts."+
						"\n Instructor : Sir Atif Saeed",
					"BCE Rox",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				for(JButton currentButton : buttons)
				{
					currentButton.setForeground(new Color(ranGen.nextInt(256),ranGen.nextInt(256),ranGen.nextInt(256)));
					currentButton.setFont(new Font("Arial",Font.BOLD+ranGen.nextInt(100),15));
				}
				//timeField.setBackground(new Color(ranGen.nextInt(256),ranGen.nextInt(256),ranGen.nextInt(256)));
				timeField.setForeground(new Color(ranGen.nextInt(256),ranGen.nextInt(256),ranGen.nextInt(256)));
				time.tick();
			}
			timeField.setText(time.toString());
			container.validate();
		}
	}
}