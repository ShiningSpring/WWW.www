import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class GameWindowFX {
 
	private static final GameWindowFX gw = new GameWindowFX();
	private Stage wnd;
	private Scene scene;
	private GameViewFX current;
	private boolean isChangeAnimation;
	private boolean isInit;
 
	private GameWindowFX() {}
 
	/**
	 * ゲーム用ウィンドウとして初期化します。
	 * @param stage ウィンドウオブジェクト
	 * @param width ウィンドウの表示領域の横幅
	 * @param height ウィンドウの表示領域の縦幅
	 * @param initView 初期表示対象の画面
	 * @return
	 */
	public static synchronized void init(Stage stage, double width, double height, GameViewFX initView) {
		if ( gw.isInit ) throw new RuntimeException("既に初期化されています。");
		gw.scene = new Scene(initView, width, height);
		stage.setScene(gw.scene);
		gw.wnd = stage;
		gw.current = initView;
		gw.scene.setOnMouseClicked(e -> gw.current.mouseClicked(e));
		gw.isInit = true;
	}
 
	/**
	 * ウィンドウを表示します。
	 */
	public static synchronized void show() {
		if ( !gw.wnd.isShowing() ) {
			gw.wnd.show();
		}
	}
 
	/**
	 * ウィンドウを閉じます。
	 */
	public static synchronized void close() {
		if ( gw.wnd.isShowing() ) {
			gw.wnd.close();
		}
	}
 
	/**
	 * 指定した引数の画面へ暗転処理とともに遷移します。
	 * 画面遷移命令を実行できた場合はtrueを返します。
	 * @param view
	 */
	public static synchronized boolean changeWithAnimation(GameViewFX view) {
		if ( gw.isChangeAnimation ) return false;
		Rectangle rect = new Rectangle(0,0,gw.scene.getWidth(),gw.scene.getHeight());
		rect.setFill(Color.BLACK);
		rect.setViewOrder(Long.MIN_VALUE);
		rect.setOpacity(0);
		gw.current.getChildren().add(rect);
 
		//フェードインフェードアウトアニメーションを実行
		FadeTransition fadeIn = new FadeTransition(Duration.millis(400), rect);
		fadeIn.setFromValue(0);
		fadeIn.setToValue(1);
		fadeIn.setOnFinished(e -> {
			gw.current.getChildren().remove(rect);
			view.getChildren().add(rect);
			GameWindowFX._change(view);
		});
		FadeTransition fadeOut = new FadeTransition(Duration.millis(400), rect);
		fadeOut.setFromValue(1);
		fadeOut.setToValue(0);
		fadeOut.setOnFinished(e -> {
			view.getChildren().remove(rect);
			gw.isChangeAnimation = false;
		});
		SequentialTransition animation = new SequentialTransition(fadeIn, fadeOut);
		gw.isChangeAnimation = true;
		animation.play();
		return true;
	}
 
	/**
	 * 指定した引数の画面へ遷移します。
	 * 画面遷移に成功した場合はtrueを返します。
	 * @param view
	 */
	public static synchronized boolean change(GameViewFX view) {
		if ( gw.isChangeAnimation ) return false;
		_change(view);
		return true;
	}
 
	private static void _change(GameViewFX view) {
		gw.scene.setRoot(view);
		gw.current = view;
	}
}