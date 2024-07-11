package 的当的遊戯;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;


public class Block {
	private Rectangle rect;
	private Image img;
	public Block(int x, int y) {
		this.img = AppManager.getBlockImage();
		rect = new Rectangle(x,y,50,50);
	}
	public void draw(Graphics g) {
		g.drawImage(img, rect.x,rect.y, null);	
	}
	public boolean isHit(Point p) {
		return rect.contains(p);
	}
	public boolean isConflictBlock(Block b) {
		return rect.intersects(b.rect);
	}
}
