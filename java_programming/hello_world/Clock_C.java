import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Calendar;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

public class Clock_C extends JTextField implements ActionListener
{
	Random renGen;
	Timer t;
	Calendar c;
	JTextField tf;
	String months[]={"January","February","March","April","May","June","July","August",
						"September","October","November","December"};
	
	public Clock_C()
	{
		setColumns(10);
		setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		setEditable(false);
		setForeground(Color.DARK_GRAY);
		
		renGen=new Random();
		
		t=new Timer(1000,this);
		t.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		c=Calendar.getInstance();
		int h, m, s, d,mo, ye;
		h=c.get(Calendar.HOUR_OF_DAY);
		String f=h<12? "AM" :"PM"  ;
		h=(h==12 ||h==0) ? 12 : h%12 ;
		m=c.get(Calendar.MINUTE);
		s=c.get(Calendar.SECOND);
		d=c.get(Calendar.DATE);
		mo=c.get(Calendar.MONTH);
		ye=c.get(Calendar.YEAR);
		setText("" +h + ":" + m + ":" + s+" "+f +"                 "+months[mo]+" , "+d+" , "+ye);
		setForeground(new Color(renGen.nextInt(255), renGen.nextInt(255), renGen.nextInt(255)));
	}
}