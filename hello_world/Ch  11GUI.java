import java.*;
import javax.*;

1: javax.swing.Icon

	interface used to manipulate images


2: javax.swing.ImageIcon

	load images & implements javax.swing.Icon

	e.g Icon bug=new ImageIcon(getClass().getResource("bug1.gif"));

	getClass(inherited from class Object)
	getResource()   ....returns the location of the image as URL


3: javax.swing.SwingConstants

	an interface declares a commen set of integers

4: javax.swing.JLabel

	for horizontal or vertical Alighnment

	setHorizontalAlighnment();                   setVerticalAlighnment();

	setText("");   set the text of label
	setIcon("f.gif");     load the image

	setHorizontalTextPosition();            setVerticalTextPosition();
	specify the text positon in label

5: javax.swing.text.JTextComponent

	javax.swing.JTextField extends javax.swing.text.JTextComponent
		
		new JTextField("number of columns or text or both seprated by comma")
			setEditable(boolean )....//This method is inherited from JTextomponent
			addActionListner(ActionListner object)//register the event handler for each component
				
		javax.swing.JPasswordField extends javax.swing.JTextField
			
			getPassword(); //return password in form of String 
			
6: java.awt.event.ActionEvent
	getSource()  //it returns a refrence to the event source
	getActionCommand();   //obtain the action
