package sound;

import java.awt.*;
import javax.swing.*;

public class Animation {
	
	int x;
	int y;
	MyDrawPanel3 panel;

	public static void main(String[] args) {
		Animation gui=new Animation();
		gui.go();
	}

	public void go() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel =new MyDrawPanel3();
		frame.getContentPane().add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		for(int i=0;i<130;i++) {
			x++;
			y++;
			panel.repaint();
			try {
				Thread.sleep(50);
			}catch(Exception ex) {}
		}
	}
	class MyDrawPanel3 extends JPanel{
		private static final long serialVersionUID=12344;
		public void paintComponent(Graphics g) {
     		g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.orange);
			g.fillOval(x, y, 40, 40);
		}
	}


}
