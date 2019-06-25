package gui;

import javax.swing.*;

public class SimpleGui1 {

	public static void main(String[] args) {
		JFrame frame =new JFrame();
		JButton button=new JButton("Ç®²ý·¢");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.getContentPane().add(button);
		frame.setSize(400,500);
		frame.setVisible(true);
	}

}
