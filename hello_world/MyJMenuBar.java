package jhtp.jutil;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJMenuBar extends JMenuBar implements ActionListener
{
	public JMenu fileMenu;
		public JMenuItem exitItem;
	public JMenu editMenu;
		public JMenuItem cutItem, copyItem, pasteItem, deleteItem;
	public JMenu viewMenu;
	public JMenu helpMenu;
		public JMenuItem aboutItem, aboutAuthorItem;
	
	public MyJMenuBar()
	{
		fileMenu=new JMenu("File");
		fileMenu.setMnemonic('F');
			exitItem=new JMenuItem("Exit", 'x');
			exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,KeyEvent.ALT_MASK));
			exitItem.addActionListener(this);		
		fileMenu.add(exitItem);
		
		editMenu=new JMenu("Edit");
		editMenu.setMnemonic('E');
			cutItem=new JMenuItem("Cut", 't');
			cutItem.setIcon(new ImageIcon("jhtp/pictures/copy.png"));
			cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		editMenu.add(cutItem);
			copyItem=new JMenuItem("Copy",new ImageIcon("jhtp/pictures/copy.png"));
			copyItem.setMnemonic('C');
			copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK));
		editMenu.add(copyItem);
			pasteItem=new JMenuItem("Paste",new ImageIcon("jhtp/pictures/paste.png"));
			pasteItem.setMnemonic('P');
			pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_MASK));
		editMenu.add(pasteItem);
			deleteItem=new JMenuItem("Delet",new ImageIcon("jhtp/pictures/delete.png"));
			deleteItem.setMnemonic('D');
			deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,KeyEvent.VK_0));
		editMenu.add(deleteItem);
		
		viewMenu = new JMenu("View");
		viewMenu.setMnemonic('V');
		
		helpMenu=new JMenu("Help");
		helpMenu.setMnemonic('H');
			aboutItem=new JMenuItem("About", 'A');
		helpMenu.add(aboutItem);
		helpMenu.addSeparator();
			aboutAuthorItem=new JMenuItem("About Authors",'b');
			aboutAuthorItem.addActionListener(this);
		helpMenu.add(aboutAuthorItem);
		
		add(fileMenu);
		add(editMenu);
		add(viewMenu);
		add(helpMenu);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exitItem)
			System.exit(0);
		else if(e.getSource()==aboutAuthorItem)
			JOptionPane.showMessageDialog(exitItem ,
				"Naveed Rasheed      Bce-sp07-34\n",
				"About Authors",JOptionPane.PLAIN_MESSAGE);
	}
}