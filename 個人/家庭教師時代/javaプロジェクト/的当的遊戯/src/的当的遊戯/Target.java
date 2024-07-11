package 的当的遊戯;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import com.nompor.gtk.animation.FadeAnimation;
import com.nompor.gtk.animation.ImageDrawAnimation;
import com.nompor.gtk.animation.ParallelAnimation;
import com.nompor.gtk.animation.RotateAnimation;
import com.nompor.gtk.animation.ScaleAnimation;
import com.nompor.gtk.draw.GraphicsUtil;
import com.nompor.gtk.geom.Circle;

public class Target{
	private Circle circle;
	private ImageDrawAnimation img;
	private int mx;
	private int my;
	private boolean isAlive=true;
	private int lastScorePoint=-1;
	private int sy;
	private int deleteFrame;
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
 

	private ParallelAnimation animation;
	public Target(int x, int y, int mx, int my) {
		
		this.img = new ImageDrawAnimation(AppManager.getTargetImage(),100,100,1);
		animation = new ParallelAnimation(
				new ScaleAnimation(img, 0.005)
				, new FadeAnimation(img, -0.04f)
				, new RotateAnimation(img, 100)
		);
 
		img.setAnimationEndOfLastImageIndex();
		
		circle = new Circle(x+50, y+50, 25);
 
		
		this.mx = mx;
		this.my = my;
	}
 
	
	public boolean isAlive() {
		return isAlive;
	}
	public boolean isDelete() {
		return !isAlive && deleteFrame > 60;
	}
	public void breakProcess() {
		isAlive = false;
	}
 
	public void draw(Graphics g) {
 
 
	
		if ( !isAlive ) {
		
			animation.update();
 
			
			img.update();
 
			deleteFrame++;
		} else {
			circle.cx+=mx;
			circle.cy+=my;
		}

		img.draw(g, circle.getICX()-50, circle.getICY()-50);
 
		if ( lastScorePoint != -1 ) {
			
			sy--;
			g.setColor(Color.WHITE);
			g.setFont(font);
			GraphicsUtil.drawCenteringString(g, ""+lastScorePoint, circle.getICX(), circle.getICY()+sy);
		}
	}
 

	public boolean isHit(Point p, Circle c) {
		return c.contains(p.x, p.y);
	}
	
	public boolean isHit(Point p) {
		return isHit(p, circle);
	}

	public int getScorePoint(Point p) {
	
		double r = circle.getRadius();
		r *= r;
 
		double vx = p.x - circle.cx;
		double vy = p.y - circle.cy;
 
		double r2 = vx*vx+vy*vy;
		int result = (int)Math.round((1.0 - r2 / r) * 100);
 
		lastScorePoint = (result < 0 ? 0 : result);
		return lastScorePoint;
	}

	public int getLeft() {
		return circle.getILeft();
	}
	
	public int getTop() {
		return circle.getITop();
	}

	public int getRight() {
		return circle.getIRight();
	}

	public int getBottom() {
		return circle.getIBottom();
	}
}