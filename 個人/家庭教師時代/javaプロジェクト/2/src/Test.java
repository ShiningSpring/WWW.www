import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.nompor.gtk.GTKManager;
import com.nompor.gtk.GameView;
import com.nompor.gtk.animation.LBAMessageDrawAnimation;
 
 
public class Test{
	public static void main(String[] args) {
		GTKManager.start(400, 300, new GameView(){
 
			LBAMessageDrawAnimation mda =
					new LBAMessageDrawAnimation(
							new Rectangle(50,50,300,200)
							, 1
							, 5
					);
 
			{
				mda.add("こんにちわ。\nコマンドラインでjarライブラリのクラスを呼び出しているよ。\n");
				mda.add("ホンマか？\n", new Font(Font.MONOSPACED,Font.ITALIC,20), Color.GREEN);
				mda.add("はい。", new Font(Font.MONOSPACED,Font.ITALIC,20), Color.BLUE);
				mda.add("呼び出せています。", new Font(Font.MONOSPACED,Font.ITALIC,15), Color.RED);
			}
 
			@Override
			public void draw(Graphics g) {
				mda.update();
				g.setColor(Color.WHITE);
				mda.fillRoundRect(g);
				mda.draw(g);
			}
		});
	}
}