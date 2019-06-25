package sound;

import java.awt.*;
import javax.swing.*;

public class Snake {
	
	int x;
	int y;
	MyDrawPanel3 panel;

	public static void main(String[] args) {
		Snake gui=new Snake();
		gui.go();
		gui.path();
	}

	public void go() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel =new MyDrawPanel3();
		frame.getContentPane().add(panel);
		frame.setSize(800,500);
		frame.setVisible(true);
			
	}
	public void path() {
		double t;
		double x1;
		for(int i=0;i<8;i++) {

		for(t=0;t<30;t=t+1) {
			x=-(int)(Math.cos(t*Math.PI/30)*30)+70+60*i;
			y=(int)(Math.pow(-1,i+1)*Math.sin(t*Math.PI/30)*30)+70;
			panel.repaint();
			try {
				Thread.sleep(50);
			}catch(Exception ex) {}
		}
		}
		for(t=0;t<30;t=t+1) {
			x=-(int)(Math.cos(t*Math.PI/60)*30)+70+60*8;
			y=-(int)(Math.sin(t*Math.PI/60)*30)+70;
			panel.repaint();
			try {
				Thread.sleep(50);
			}catch(Exception ex) {}
		}
		for(int i=0;i<90;i=i+1) {
			x=70+60*8+i;
			y=70-30;
			panel.repaint();
			try {
				Thread.sleep(50);
			}catch(Exception ex) {}
		}
		for(t=0;t<60;t=t+1) {
			x=-(int)(Math.cos(t*Math.PI/60+Math.PI/2)*20)+70+60*8+90;
			y=-(int)(Math.sin(t*Math.PI/60+Math.PI/2)*20)+60;
			panel.repaint();
			try {
				Thread.sleep(50);
			}catch(Exception ex) {}
		}
		for(int i=0;i<40;i=i+1) {
			x=70+60*8+90-i;
			y=60+20;
			panel.repaint();
			try {
				Thread.sleep(50);
			}catch(Exception ex) {}
		}
		
	}
	class MyDrawPanel3 extends JPanel{
		private static final long serialVersionUID=12344;
		public void paintComponent(Graphics g) {
//     		g.setColor(Color.white);
//			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.orange);
			g.fillOval(x, y, 40, 40);
		}
	}


}
