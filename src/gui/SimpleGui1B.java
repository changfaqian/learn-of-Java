package gui;

import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener{
	JButton button;

	public static void main(String[] args) {
		SimpleGui1B gui=new SimpleGui1B();
		gui.go();
	}
	public void go() {
		JFrame frame =new JFrame();
		button=new JButton("check it!");
		
		button.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.getContentPane().add(button);
		frame.setSize(300,200);
		frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent event) {
		button.setText("I've been clicked!");
	}

}
