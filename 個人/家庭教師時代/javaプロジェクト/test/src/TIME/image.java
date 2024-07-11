package TIME;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;


	public class image{
		public static void main(String[] args) {
			GameWindow gw = new GameWindow("テストウィンドウ",900,1080);
			DrawCanvas dc = new DrawCanvas();
			gw.add(dc);
			gw.setVisible(true);
		}
	}
	
	class GameWindow extends JFrame{
		public GameWindow(String title, int width, int height) {
			super(title);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(width,height);
			setLocationRelativeTo(null);
			setResizable(false);
		}
	}	
		
	class DrawCanvas extends JPanel{
		Image img = Toolkit.getDefaultToolkit().getImage("gghj.jpg");
		public void paintComponent(Graphics g){
			super.paintComponent(g);
	 
			Graphics2D g2 = (Graphics2D)g;
			AffineTransform at = g2.getTransform();
	 
			
	 
			g2.drawImage(img, 0, 0, this);
		}
	}

	