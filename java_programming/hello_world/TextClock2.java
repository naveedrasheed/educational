// File:   textclock/TextClock2.java
// Description: Application / Applet for a simple text clock.
// Author: Fred Swartz
// Date:   2005-02-15, 1999-05-01, 2001-11-02, 2002-11-07

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

///////////////////////////////////////////////////////////// TextClock2
public class TextClock2 extends JApplet {

    //====================================================== constructor
    public TextClock2() {
        add(new Clock());
    }

    //============================================================= main
    public static void main(String[] args) {
        JFrame window = new JFrame("Time of Day");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setContentPane(new Clock());

        window.pack();
        window.setVisible(true);
        System.out.println(window.getContentPane().size());
    }
}

