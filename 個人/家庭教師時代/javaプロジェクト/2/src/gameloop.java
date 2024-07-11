//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Insets;
//import java.awt.Rectangle;
//import java.awt.font.TextAttribute;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class gameloop {
//	public static void main(String[] args) {
//		GameWindow gw = new GameWindow("テストウィンドウ",400,300);
//		gw.setVisible(true);
//		gw.change(new DrawCanvas());
//		gw.startGameLoop();
//	}
//}
//class GameWindow extends JFrame implements Runnable{
//	private Thread th = null;
//	private double sleepAddTime;
//	private int fps=60;
//	public GameWindow(String title, int width, int height) {
//		super(title);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setSize(width,height);
//		setLocationRelativeTo(null);
//		setLayout(null);
//		setResizable(false);
//		setFps(fps);
//	}
//	public synchronized void change(JPanel p) {
//		getContentPane().removeAll();
//		Insets inset = getInsets();
//		p.setBounds(-inset.left,-inset.top,getWidth(),getHeight());
//		add(p);
//		validate();
//		repaint();
//	}
//	public synchronized void startGameLoop(){
//		if ( th == null ) {
//			th = new Thread(this);
//			th.start();
//		}
//	}
//	public synchronized void stopGameLoop(){
//		if ( th != null ) {
//			th = null;
//		}
//	}
//	public void run(){
//		double nextTime = System.currentTimeMillis() + sleepAddTime;
//		while(th != null){
//			try{
//				long res = (long)nextTime - System.currentTimeMillis();
//				if ( res < 0 ) res = 0;
//				Thread.sleep(res);
//				repaint();
//				nextTime += sleepAddTime;
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
//		}
//	}
//	public void setFps(int fps){
//		if ( fps < 10 || fps > 60 ) {
//			throw new IllegalArgumentException("fpsの設定は10～60の間で指定してください。");
//		}
//		this.fps = fps;
//		sleepAddTime = 8.0 / fps;
//	}
//}
//class DrawCanvas extends JPanel{
//	//矩形内に文字列アニメーションを実装
//	Rectangle rect1 = new Rectangle(50,50,300,50);
//	MessageDrawAnimation md1 = new MessageDrawAnimation(rect1, 95, 10);
// 
//	Rectangle rect2 = new Rectangle(50,120,300,80);
//	MessageDrawAnimation md2 = new MessageDrawAnimation(rect2, 95, 10);
// 
//	Rectangle rect3 = new Rectangle(50,220,300,50);
//	MessageDrawAnimation md3 = new MessageDrawAnimation(rect3, 100, 10);
//	public DrawCanvas() {
//		md1.add("こんにちわ。今日はいい天気ですね。\n一緒にお出かけしませんか？");
// 
//		//任意の属性、フォント、色、アンダーラインを設定
//		MessageDrawAnimation.MDAAttributedString as = new MessageDrawAnimation
//				.MDAAttributedString("雨");
//		as.setAttribute(TextAttribute.FONT, new Font(Font.MONOSPACED, Font.PLAIN, 12));
//		as.setAttribute(TextAttribute.FOREGROUND, Color.RED);
//		as.setAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
// 
//		md2.add("え！？\n",new Font(Font.MONOSPACED, Font.PLAIN, 25), Color.BLACK);
//		md2.add(as);
//		md2.add("降ってますよ。やめておきませんか？", new Font(Font.MONOSPACED, Font.PLAIN, 12), Color.BLACK);
// 
//		md3.add("雨だから行くんじゃないですか。はやく傘を持ってきてください。");
//	}
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.setColor(Color.PINK);
//		md1.update();
//		md1.fillRoundRect(g);
//		md1.drawString(g);
// 
//		//メッセージ1が終了したら開始
//		if ( md1.isEndOfAnimation() ) {
//			g.setColor(Color.CYAN);
//			md2.update();
//			md2.fillRoundRect(g);
//			md2.drawString(g);
//		}
// 
//		//メッセージ2が終了したら開始
//		if ( md2.isEndOfAnimation() ) {
//			g.setColor(Color.PINK);
//			md3.update();
//			md3.fillRoundRect(g);
//			md3.drawString(g);
//		}
//	}
//}
//
////
////
////
////
////
////
//
//
//

