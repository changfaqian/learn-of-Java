package theswing;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Manager1 {
	ArrayList<JCheckBox> checkboxList;
	JFrame frame;
	JPanel mainPanel;
	String[] instrumentNames= {"Bass Drum","Closed Hi-Bat","Open Hi-Hat","A","C","H","H","H","M","W","L","C","V","L","H","O"};
	

	public static void main(String[] args) {
		Manager1 ma=new Manager1();
		ma.GUI();
	}

	public void GUI() {
		frame=new JFrame("Cyber BeatBox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout=new BorderLayout();
		mainPanel=new JPanel();
		JPanel background=new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		checkboxList=new ArrayList<JCheckBox>();
		Box buttonBox=new Box(BoxLayout.Y_AXIS);
		
		JButton start=new JButton("start");
		start.setPreferredSize(new Dimension(30,30));
		buttonBox.add(start);
		buttonBox.add(Box.createGlue());
		
		JButton stop=new JButton("stop");
		buttonBox.add(stop);
		buttonBox.add(Box.createGlue());
		
		JButton upTempo=new JButton("Tempo Up");
		buttonBox.add(upTempo);
		buttonBox.add(Box.createGlue());
		
		JButton downTempo=new JButton("Tempo Down");
		buttonBox.add(downTempo);
		
		Box nameBox=new Box(BoxLayout.Y_AXIS);
		for(int i=0;i<16;i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}
		BoxLayout lay1=new BoxLayout(nameBox,BoxLayout.Y_AXIS);
		//nameBox.setLayout(lay1);
		
		
		background.add(BorderLayout.EAST,buttonBox);
		background.add(BorderLayout.WEST,nameBox);
		
		frame.getContentPane().add(background);
		GridLayout grid=new GridLayout(16,16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel=new JPanel(grid);
		background.add(BorderLayout.CENTER,mainPanel);
		
		for(int i=1;i<256;i++) {
			JCheckBox c=new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}
		
		
		frame.setBounds(50,50,800,500);
//		frame.pack();
		frame.setVisible(true);
		
	}

}
