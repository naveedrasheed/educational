package jhtp.ch_8.gui;

import jhtp.ch_8.console.Time2;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Time2GUI extends JTextField
{
	private Time2 time;
	private Timer t;
	
	public Time2GUI()
	{
		setColumns(15);
		setFont(new Font("serif",Font.ITALIC+Font.BOLD,35));
		setHorizontalAlignment(SwingConstants.CENTER);
		time=new Time2(23,59,50,31,12,2004);
		
		t=new Timer(1000,new ClockTickAction());
		t.start();
	}
	
	private class ClockTickAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			time.tick();
			setText(time.toString());
			setToolTipText("This is a one second timer");
		}
	}
}