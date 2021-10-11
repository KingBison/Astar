package main;



import java.awt.Canvas;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Window extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Window(Launcher l){
		JFrame frame = new JFrame("A*");
		frame.setPreferredSize(new Dimension(765,789));
		frame.setMinimumSize(new Dimension(765,789));
		frame.setMaximumSize(new Dimension(765,789));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(l);
		frame.setVisible(true);
		l.start();
		
		
		
	}
	
	
}
