import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class ButtonPanelTest extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton buttons[];
	private String buttonNames[]={"Start","Stop","Change","Alarm"};
	
	public ButtonPanelTest()
	{
		super("Testing Button on Panel");
		setResizable(false);
		panel=new JPanel(new GridLayout(1,4,5,5));
		
		buttons=new JButton[buttonNames.length];
		for(int i=0;i<buttonNames.length;i++)
		{
			buttons[i]=new JButton(buttonNames[i]);
			panel.add(buttons[i]);
		}
		add(panel,BorderLayout.SOUTH);
		
		for(JButton currentbutton : buttons)
			currentbutton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event)
	{
		for (JButton currentbutton : buttons)
		{
			if(event.getActionCommand()==currentbutton.getActionCommand())
				currentbutton.setVisible(false);
			else
				currentbutton.setVisible(true);
		}
	}
	public static void main (String[] args)
	{
		ButtonPanelTest frame=new ButtonPanelTest();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(400,150);
		frame.setVisible(true);
	}
}