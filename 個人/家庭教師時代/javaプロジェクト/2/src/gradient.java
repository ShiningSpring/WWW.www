//import javax.swing.JFrame;
//
//public class gradient {
//	public static void main(String[] args) {
//		GameWindow gw = new GameWindow("テストウィンドウ",400,300);
//		gw.add(new DrawCanvas());
//		gw.setVisible(true);
//	}
//}
//class GameWindow extends JFrame{
//	public GameWindow(String title, int width, int height) {
//		super(title);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setSize(width,height);
//		setLocationRelativeTo(null);
//		setResizable(false);
//	}
//}
// 
//class DrawCanvas extends JPanel{
//	LinearGradientPaint p = new LinearGradientPaint(
//			0
//			, 0
//			, 300
//			, 200
//			, new float[] {
//					0.0f
//					, 1.0f
//					
//			}
//			, new Color[] {
//					new Color(0, 0, 0, 0)
//					
//					, Color.BLUE
//			}
//	);
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		
//		Graphics2D g2 = (Graphics2D)g;
// 
//		g2.setPaint(p);
// 
//		g.fillOval(0, 0, 233, 270);
//	}
//class DrawCanvas extends JPanel{
//	Image img = Toolkit.getDefaultToolkit().getImage("sample.png");
//	RadialGradientPaint p = new RadialGradientPaint(
//			200
//			, 150
//			, 100
//			, new float[] {
//					0.0f
//					, 0.5f
//					, 1.0f
//			}
//			, new Color[] {
//					new Color(0, 0, 0, 0)
//					, new Color(0, 0, 0, 100)
//					, Color.BLACK
//			}
//	);
//	public void paintComponent(Graphics g){
//	
//		
//		super.paintComponent(g);
//		
//		Graphics2D g2 = (Graphics2D)g;
//		g.drawImage(img, 0, 0, this);
//		g2.setPaint(p);
//		
//		g2.fillRect(0,0,400,300);
//		
//	}
//}
//
//
//
//
//



















