package quiz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

public class QuizCardBuilder2 {

	private JFrame frame;
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardlist;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizCardBuilder2 window = new QuizCardBuilder2();
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
	public QuizCardBuilder2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Quiz Card Builder");
		frame.setBounds(200,150,500,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Font font=new Font("\u6977\u4F53",0,12);
		cardlist=new ArrayList<QuizCard>();
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(185, 28, 70, 15);
		panel.add(lblNewLabel);
		
		question=new JTextArea(9,20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(font);
		
		JScrollPane scrollPane1 = new JScrollPane(question);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setBounds(40, 50, 400, 200);
		panel.add(scrollPane1);
		
		JLabel label = new JLabel("New label");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(185, 260, 70, 15);
		panel.add(label);
		
		answer=new JTextArea(9,20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(font);
		
		JScrollPane scrollPane2 = new JScrollPane(answer);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(40, 280, 400, 200);
		panel.add(scrollPane2);
		
		JButton nextbutton=new JButton("next");
		nextbutton.addActionListener(new Nextaction());
		nextbutton.setBounds(190, 500, 60, 20);
		panel.add(nextbutton);
		
		JMenuBar mainmenu=new JMenuBar();
		JMenu filemenu=new JMenu("file");
		
		JMenuItem newitem=new JMenuItem("new");
		newitem.addActionListener(new Newaction());
		
		JMenuItem saveitem=new JMenuItem("save");
		saveitem.addActionListener(new Saveaction());
		
		filemenu.add(newitem);
		filemenu.add(saveitem);
		
		mainmenu.add(filemenu);
		frame.setJMenuBar(mainmenu);
	}
	
	
	class Nextaction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			QuizCard card=new QuizCard(question.getText(),answer.getText());
			cardlist.add(card);
			clearCard();
		}
		
	}
	
	class Newaction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			cardlist.clear();
			clearCard();
			
		}

		
	}
	
	class Saveaction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			QuizCard card=new QuizCard(question.getText(),answer.getText());
			cardlist.add(card);
			JFileChooser filesave=new JFileChooser();
			filesave.showSaveDialog(frame);
			if()
			saveFile(filesave.getSelectedFile());
			
		}
	}
	
	public void clearCard() {
		question.setText("");
		answer.setText("");	
		question.requestFocus();
	}
	

	public void saveFile(File file) {
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(file));
			for(QuizCard card:cardlist) {
				writer.write(card.getQuestion()+"/");
				writer.write(card.getAnswer()+"/");
			}
			writer.close();
		}catch(IOException ex) {
			System.out.println("can't writer!");
			ex.printStackTrace();
		}
		
		
		
	}

}
