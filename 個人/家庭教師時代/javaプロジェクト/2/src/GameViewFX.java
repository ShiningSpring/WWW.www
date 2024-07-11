import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
 
public abstract class GameViewFX extends Group{
	/**
	 * マウスをクリックしたときのイベント処理
	 * 使用する場合はサブクラスでオーバーライドしてください。
	 * @param e
	 */
	public void mouseClicked(MouseEvent e) {}
}