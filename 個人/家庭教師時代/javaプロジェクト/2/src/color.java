//import java.awt.AlphaComposite;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.Toolkit;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class color {
//	public static void main(String[] args) {
//		GameWindow gw = new GameWindow("テストウィンドウ",400,300);
//		DrawCanvas dc = new DrawCanvas();
//		gw.add(dc);
//		gw.setVisible(true);
//	}
//}
//class GameWindow extends JFrame{
//	 
//	public GameWindow(String title, int width, int height) {
//		super(title);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setSize(width,height);
//		setLocationRelativeTo(null);
//		setResizable(false);
//	}
//}
//class DrawCanvas extends JPanel{
//	Image img = Toolkit.getDefaultToolkit().getImage("sample.png");
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
// 
//		Graphics2D g2 = (Graphics2D)g;
// 
//		//透明度を50%に設定する
//		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
//		g2.setComposite(ac);
// 
//		g2.drawImage(img, 0, 0, this);
//	}
//}
//
