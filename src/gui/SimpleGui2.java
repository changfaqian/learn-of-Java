package gui;                                      //暂未解决按钮无法改变颜色得问题

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class SimpleGui2 implements ActionListener{
	JFrame frame;
	JButton button;

	public static void main(String[] args) {
		SimpleGui2 gui=new SimpleGui2();
		gui.go1();
	}
	public void go1() {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button =new JButton("check it!");
     	button.addActionListener(this);
     	
     	MyDrawPanel panel=new MyDrawPanel();
     	
     	frame.getContentPane().add(BorderLayout.SOUTH,button);
     	frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setBackground(Color.blue);
	}
	public void actionPerformed(ActionEvent event) {
		
		button.setBackground(Color.blue);
		
	}

}

