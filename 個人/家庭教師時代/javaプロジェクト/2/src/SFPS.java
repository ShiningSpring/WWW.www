//import java.awt.Color;
//import java.awt.Graphics;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class SFPS {
//	public static void main(String[] args) {
//		GameWindow gw = new GameWindow("テストウィンドウ",400,300);
//		gw.setFps(16);//60fpsを指定します。
//		gw.add(new DrawCanvas());
//		gw.setVisible(true);
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
//		setResizable(false);
//		setFps(fps);
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
//		//60fpsとなるように再描画を呼び出す
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
//		sleepAddTime = 1000.0 / fps;
//	}
//}
////リアルタイムfps測定用クラス
//class FrameRate{
//    private long before;
//    private int count;
//    private float frameRate;
//    private final int updateTimeMillis;
//    public FrameRate(int updateTimeMillis){
//        this.updateTimeMillis = updateTimeMillis;
//        before = System.currentTimeMillis();
//    }
// 
//    public boolean process(){
//        long now = System.currentTimeMillis();
//        count++;
//        if(now - before >= updateTimeMillis){
//            frameRate = (float)(count * 1000) / (float)(now - before);
//            before = now;
//            count = 0;
//            return true;
//        }
//        return false;
//    }
// 
//    public float getFrameRate(){
//        return frameRate;
//    }
//}
//class DrawCanvas extends JPanel{
//	int x = 0;
//	FrameRate fr = new FrameRate(500);
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
// 
//		//実際に何fpsで動いているかリアルタイムで測定
//		fr.process();
//		g.drawString(fr.getFrameRate()+"FPS", 60, 100);
// 
//		g.setColor(Color.BLACK);
//		g.drawString("ゲームループアニメーション", x+=8, 20);
//	}
//}