package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyButton {
	JLabel label;
	JButton textbutton;
	JFrame frame;

	public static void main(String[] args) {
	MyButton gui=new MyButton();
	gui.go();

	}

	public void go() {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textbutton=new JButton("changetext");
		textbutton.addActionListener(new Changetext());
		JButton colorbutton=new JButton("changecolor");
		colorbutton.addActionListener(new Changecolor());
		label=new JLabel("I'm a label");
		
		MyDrawPanel panel=new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.EAST,textbutton);
		frame.getContentPane().add(BorderLayout.SOUTH,colorbutton);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.getContentPane().add(BorderLayout.WEST,label);
		
		
		frame.setSize(500,400);
		frame.setVisible(true);
	}
	
	class Changetext implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			label.setText("I've been clicked");
			
		}
	}
	class Changecolor implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frame.repaint();
		}
			
	}
}
