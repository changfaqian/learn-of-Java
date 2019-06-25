package theswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

import java.util.*;
import javax.sound.midi.*;
import java.awt.event.*;
import javax.swing.UIManager;

public class GUI2 {
	
	private ArrayList<JCheckBox> checkboxlist;
	private Sequencer sequencer;
	private JFrame frame;
	private Track track;
	private int[] instrument= {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	private Sequence seq;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u97F3\u4E50\u751F\u6210\u8F6F\u4EF6");
		frame.setBackground(SystemColor.textHighlightText);
		frame.setBounds(100, 100, 575, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		checkboxlist=new ArrayList<JCheckBox>();
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				JCheckBox checkBox = new JCheckBox("");
				checkBox.setBounds(65+25*j, 5+20*i, 20, 15);
				checkBox.setSelected(false);
				frame.getContentPane().add(checkBox);
				checkboxlist.add(checkBox);
			}
		}
		
		JButton Button_0 = new JButton("\u5F00\u59CB");
		Button_0.setFont(new Font("YouYuan", Font.PLAIN, 12));
		Button_0.setBounds(470, 20, 80, 25);
		Button_0.addActionListener(new Startaction());
		frame.getContentPane().add(Button_0);
		
		JButton button_1 = new JButton("\u505C\u6B62");
		button_1.setFont(new Font("YouYuan", Font.PLAIN, 12));
		button_1.setBounds(470, 60, 80, 25);
		button_1.addActionListener(new Stopaction());
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u52A0\u901F");
		button_2.setFont(new Font("YouYuan", Font.PLAIN, 12));
		button_2.setBounds(470, 100, 80, 25);
		button_2.addActionListener(new Fastaction());
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u51CF\u901F");
		button_3.setFont(new Font("YouYuan", Font.PLAIN, 12));
		button_3.setBounds(470, 140, 80, 25);
		button_3.addActionListener(new Slowaction());
		frame.getContentPane().add(button_3);
		
		Font font=new Font("¿¬Ìå",0,12);	
		JLabel label_0 = new JLabel("\u4F4E\u97F3\u9F13");
		label_0.setFont(font);
		label_0.setHorizontalAlignment(SwingConstants.CENTER);
		label_0.setVerticalAlignment(SwingConstants.TOP);
		label_0.setBackground(SystemColor.textHighlightText);
		label_0.setBounds(10, 5, 50, 15);
		frame.getContentPane().add(label_0);
		
		JLabel label_1 = new JLabel("\u95ED\u9572");
		label_1.setFont(font);
		label_1.setForeground(SystemColor.windowText);
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(10, 25, 50, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u5F00\u9572");
		label_2.setFont(font);
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(10, 45, 50, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u519B\u9F13");
		label_3.setFont(font);
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(9, 65, 50, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u5F3A\u97F3\u9572");
		label_4.setFont(font);
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(10, 85, 50, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u62CD\u624B");
		label_5.setFont(font);
		label_5.setVerticalAlignment(SwingConstants.TOP);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(9, 105, 50, 15);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u6876\u9F13");
		label_6.setFont(font);
		label_6.setVerticalAlignment(SwingConstants.TOP);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(10, 125, 50, 15);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u9AD8\u97F3\u5C0F\u9F13");
		label_7.setFont(font);
		label_7.setVerticalAlignment(SwingConstants.TOP);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBackground(Color.WHITE);
		label_7.setBounds(10, 145, 50, 15);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u6C99\u7403");
		label_8.setFont(font);
		label_8.setVerticalAlignment(SwingConstants.TOP);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBackground(Color.WHITE);
		label_8.setBounds(10, 165, 50, 15);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\u53E3\u54E8");
		label_9.setFont(font);
		label_9.setVerticalAlignment(SwingConstants.TOP);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBackground(Color.WHITE);
		label_9.setBounds(10, 185, 50, 15);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("\u5EB7\u52A0\u9F13");
		label_10.setFont(font);
		label_10.setVerticalAlignment(SwingConstants.TOP);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBackground(Color.WHITE);
		label_10.setBounds(10, 205, 50, 15);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("\u725B\u94C3");
		label_11.setFont(font);
		label_11.setVerticalAlignment(SwingConstants.TOP);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBackground(Color.WHITE);
		label_11.setBounds(10, 225, 50, 15);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("\u6447\u68D2");
		label_12.setFont(font);
		label_12.setVerticalAlignment(SwingConstants.TOP);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBackground(Color.WHITE);
		label_12.setBounds(10, 245, 50, 15);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("\u4F4E\u97F3\u4E2D\u9F13");
		label_13.setFont(font);
		label_13.setVerticalAlignment(SwingConstants.TOP);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBackground(Color.WHITE);
		label_13.setBounds(10, 265, 50, 15);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("\u9AD8\u97F3\u649E\u94C3");
		label_14.setFont(font);
		label_14.setVerticalAlignment(SwingConstants.TOP);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBackground(Color.WHITE);
		label_14.setBounds(10, 285, 50, 15);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("\u7A7A\u5FC3\u5EB7\u52A0\u9F13");
		label_15.setFont(font);
		label_15.setVerticalAlignment(SwingConstants.TOP);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBackground(Color.WHITE);
		label_15.setBounds(5, 305, 60, 15);
		frame.getContentPane().add(label_15);
		
		JLabel label = new JLabel("\u62CD\u6570:");
		label.setFont(font);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 347, 54, 15);
		frame.getContentPane().add(label);
		
		for(int j=0;j<16;j++) {
			JLabel label1 = new JLabel((j+1)+"");
			label1.setFont(font);
			label1.setBounds(69+25*j, 347, 20, 15);
			frame.getContentPane().add(label1);
		}
		
		setmidi();
		
	}

	public void setmidi() {
		try {
			sequencer=MidiSystem.getSequencer();
			sequencer.open();
			seq=new Sequence(Sequence.PPQ,4);
			track=seq.createTrack();
		}catch(Exception e) {}
		
	}
	
	public void setandstart() {
		int[] tracklist=null;
		
		seq.deleteTrack(track);
		track=seq.createTrack();
		for(int i=0;i<16;i++) {
			tracklist=new int[16];
			int key=instrument[i];
			for(int j=0;j<16;j++) {
				JCheckBox ch=(JCheckBox) checkboxlist.get((i*16)+j);
				if(ch.isSelected()) {
					tracklist[j]=key;
				}else {
					tracklist[j]=0;
				}
			}
			
			maketrack(tracklist);
		}
		
		track.add(makeevent(192,9,127,0,15));
		try {
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(120);
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
	}
	
	class Startaction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			setandstart();
			
		}
		
	}
	
	class Stopaction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			sequencer.stop();
		}
		
	}
	
	class Fastaction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			float fast=sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(fast*1.03));
		}
		
	}
	
	class Slowaction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			float slow=sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(slow*0.97));
		}
		
	}
	
	
	public void maketrack(int[] maketrack) {
		for(int i=0;i<16;i++) {
			if(maketrack[i]!=0) {
				track.add(makeevent(144,9,maketrack[i],100,i));
				track.add(makeevent(128,9,maketrack[i],100,i+1));
			}
		}
		
	}

	public MidiEvent makeevent(int a,int b,int c,int d,int e) {
		MidiEvent event=null;
		try {
			ShortMessage a1=new ShortMessage();
			a1.setMessage(a,b,c,d);
			event=new MidiEvent(a1,e);
		}catch(Exception e1) {e1.printStackTrace();}
		
		return event;
	}
}
