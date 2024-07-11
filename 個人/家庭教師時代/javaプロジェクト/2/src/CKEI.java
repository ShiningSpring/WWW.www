//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Insets;
//import java.awt.Rectangle;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//public class CKEI {
//	public static void main(String[] args) {
//		TestWindow tw = new TestWindow("テスト", 400, 300);
//		tw.change(new DrawCanvas());
//		tw.setVisible(true);
//		tw.startGameLoop();
// 
//	}
//}
////ウィンドウクラス
//class TestWindow extends JFrame implements Runnable{
//	private Thread th = null;
//	private double sleepAddTime;
//	private int fps=14;
//	public TestWindow(String title, int width, int height) {
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
//		if ( fps < 10 || fps > 1500 ) {
//			throw new IllegalArgumentException("fpsの設定は10～60の間で指定してください。");
//		}
//		this.fps = fps;
//		sleepAddTime = 1000.0 / fps;
//	}
//}
//
////移動アニメーション用クラス
//class VertexMove2D{
//	private double x;
//	private double y;
//	private final int[] xpoints;
//	private final int[] ypoints;
//	private final int npoints;
//	private boolean isInvert;
//	private int currentPoint;
//	private int nextPoint;
//	private int speed;
//	private double mx;
//	private double my;
//	private double checkValue;
//	public VertexMove2D(int[] xpoints, int[] ypoints, int npoints, int speed, int initPoint) {
//		this.xpoints = xpoints;
//		this.ypoints = ypoints;
//		this.npoints = npoints;
//		this.speed = Math.abs(speed);
//		this.isInvert = speed < 0;
//		this.currentPoint = isInvert ? initPoint + 1 : initPoint - 1;
//		prepareNext();
//	}
//	private void prepareNext() {
//		if ( isInvert ) {
//			int currentPoint = this.currentPoint - 1;
//			if ( currentPoint < 0 ) currentPoint = npoints - 1;
//			this.currentPoint = currentPoint;
//			int nextPoint = currentPoint - 1;
//			this.nextPoint = nextPoint < 0 ? npoints - 1 : nextPoint;
//		} else {
//			int currentPoint = this.currentPoint + 1;
//			if ( currentPoint >= npoints ) currentPoint = 0;
//			this.currentPoint = currentPoint;
//			this.nextPoint = (currentPoint + 1) % npoints;
//		}
//		int sx = xpoints[currentPoint];
//		int sy = ypoints[currentPoint];
//		int ex = xpoints[nextPoint];
//		int ey = ypoints[nextPoint];
//		int vx = ex - sx;
//		int vy = ey - sy;
//		double rad = Math.atan2(vy, vx);
//		mx = Math.cos(rad) * speed;
//		my = Math.sin(rad) * speed;
//		checkValue = vx * vx + vy * vy;
//		x = sx;
//		y = sy;
//	}
//	public void draw(Graphics g) {
//		g.drawPolygon(xpoints, ypoints, npoints);
//	}
//	public void fill(Graphics g) {
//		g.fillPolygon(xpoints, ypoints, npoints);
//	}
//	public void move() {
//		double xx = x + mx;
//		double yy = y + my;
//
//		int sx = xpoints[currentPoint];
//		int sy = ypoints[currentPoint];
//		double vx = sx - xx;
//		double vy = sy - yy;
//		if ( checkValue <= vx * vx + vy * vy ) {
//			prepareNext();
//		} else {
//			x = xx;
//			y = yy;
//		}
//	}
//	public void invert() {
//		isInvert = !isInvert;
//	}
//	public boolean isInvert() {
//		return isInvert;
//	}
//	public int getSpeed() {
//		return speed;
//	}
//	public void setSpeed(int speed) {
//		if ( speed < 0 ) {
//			invert();
//			speed = -speed;
//		}
//		this.speed = speed;
//	}
//	public double getX() {
//		return x;
//	}
//	public double getY() {
//		return y;
//	}
//}
//class DrawCanvas extends JPanel{
//	int[] x = {60,150,280,340,270,160,90,70};
//	int[] y = {80,200,90,120,150,250,240,260};
//
//	//図形の頂点を移動するオブジェクト。
//	VertexMove2D m1 = new VertexMove2D(
//			x
//			,y
//			,8//頂点の数
//			,2//移動速度
//			,0//配列の0番を開始地点に
//	);
//	//もう一つの図形の頂点を移動するオブジェクト。
//	VertexMove2D m2 = new VertexMove2D(
//			x
//			,y
//			,8//頂点の数
//			,-5//移動速度
//			,4//配列の4番を開始地点に
//	);
//	Rectangle r1 = new Rectangle(100, 100, 50, 50);
//	Rectangle r2 = new Rectangle(100, 100, 50, 50);
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		Graphics2D g2 = (Graphics2D)g;
//		g.setColor(Color.RED);
//		g2.draw(r1);
//		g.setColor(Color.BLUE);
//		g2.draw(r2);
//		g.setColor(Color.GREEN);
//		m1.draw(g2);
//
//		m1.move();
//		r1.x = (int) (m1.getX()-r1.width / 2);
//		r1.y = (int) (m1.getY()-r1.height / 2);
//
//		m2.move();
//		r2.x = (int) (m2.getX()-r2.width / 2);
//		r2.y = (int) (m2.getY()-r2.height / 2);
//
//		g.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
//
//		//矩形同士の当たり判定
//		if ( r1.intersects(r2) ) {
//			g.setColor(Color.RED);
//			g.drawString("当たっています", 50,50);
//		} else {
//			g.setColor(Color.BLUE);
//			g.drawString("当たってません", 50,50);
//		}
//	}
//}