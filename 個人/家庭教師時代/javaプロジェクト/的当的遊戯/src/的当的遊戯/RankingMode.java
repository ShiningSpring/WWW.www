package 的当的遊戯;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.nompor.gtk.GameView;
import com.nompor.gtk.draw.GraphicsUtil;

import 的当的遊戯.GameFileManager.DataInfo;
 
public class RankingMode extends GameView{
 Font f = new Font(Font.MONOSPACED,Font.BOLD,20);
	public void mouseClicked(MouseEvent e) {
		AppManager.change(ViewType.TITLE);
	}
 
 
 
 
 
 public void draw(Graphics g) {
	 GraphicsUtil.setTextAntialiasing(g, true);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,AppManager.getW(),AppManager.getH());
		g.setColor(Color.WHITE);
		g.setFont(f);
		ArrayList<DataInfo> dataList = GameFileManager.get();
		g.drawString("名前",150,30);
		g.drawString("スコア",300,30);
		g.drawString("ランク",420,30);
		g.drawString("日時",600,30);
		for (int i = 0;i < dataList.size();i++) {
		GameFileManager.DataInfo r = dataList.get(i);
		g.drawString(r.no, 30, 50*i+80);
		g.drawString(r.name, 70, 50*i+80);
		g.drawString(r.score, 305, 50*i+80);
		g.drawString(r.rank, 445, 50*i+80);
		g.drawString(r.datetime, 520, 50*i+80);
	}
}
}