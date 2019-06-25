package gui.sound;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer2{
	MyDrawPanel ml;
	JFrame frame=new JFrame("My first Music Video");

	public static void main(String[] args) {
		MiniMusicPlayer2 gui=new MiniMusicPlayer2();
		gui.go();
	}

	public void go() {
		setgui();
		try {
			Sequencer sequencer=MidiSystem.getSequencer();
			sequencer.open();
			
			int[] eventsIWant= {127};
			sequencer.addControllerEventListener(ml, eventsIWant);
			
			Sequence seq=new Sequence(Sequence.PPQ,4);
			Track track=seq.createTrack();
			
			for(int i=5;i<60;i+=4) {
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(176,1,127,0,i));
				track.add(makeEvent(128,1,i,100,i+2));
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	public void setgui() {
		ml =new MyDrawPanel();
		frame.setContentPane(ml);
		frame.setBounds(200,100,800,500);
		frame.setVisible(true);
		
	}
	
	class MyDrawPanel extends JPanel implements ControllerEventListener{
		private static final long serialVersionUID=12344;
		boolean msg=false;
		
		public void controlChange(ShortMessage event) {
			msg=true;
			repaint();
		}
		
		public void paintComponent(Graphics g) {
			if(msg) {
				Graphics2D g2=(Graphics2D) g;
				
				int r=(int)(Math.random()*250);
				int gr=(int)(Math.random()*250);
				int b=(int)(Math.random()*250);
				g.setColor(new Color(r,gr,b));
				
				int h=(int)(Math.random()*120+10);
				int w=(int)(Math.random()*120+10);
				int x=(int)(Math.random()*40+300);
				int y=(int)(Math.random()*40+175);
				g.fillRect(x, y, w, h);
				msg=false;
			}
			
		}
	}
	
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event=null;
		try {
			ShortMessage a=new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event=new MidiEvent(a,tick);
		}catch(Exception e) {}
		return event;
	}

}
