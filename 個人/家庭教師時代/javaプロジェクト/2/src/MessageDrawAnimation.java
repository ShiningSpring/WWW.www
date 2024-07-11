//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Rectangle;
//import java.awt.font.FontRenderContext;
//import java.awt.font.LineBreakMeasurer;
//import java.awt.font.TextAttribute;
//import java.awt.font.TextLayout;
//import java.text.AttributedCharacterIterator;
//import java.text.AttributedString;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
// 
//public class MessageDrawAnimation{
//	private ArrayList<MDAAttributedString> dataList = new ArrayList<>();
//	private StringBuilder currentText = new StringBuilder();
//	private AttributedString ensureCache;
//	private Rectangle rect;
//	private Position[] posList;
//	private int nextIndex;
//	private int nextTextIndex;
//	private int speed;
//	private int frameCount;
//	private int nextFrameCount;
//	private int outLinePadding=1;
//	private boolean isCompile;
//	private boolean endOfAnimation;
//	public static final int MAX_MESSAGE_SPEED=100;
//	public static final int MIN_MESSAGE_SPEED=1;
// 
//	/**
//	 * 引数の描画領域と設定を利用してメッセージ描画オブジェクトを構築します。
//	 * @param rect 描画領域
//	 * @param speed メッセージスピード
//	 * @param outLinePadding 矩形描画する際の外側に広げる量
//	 */
//	public MessageDrawAnimation(Rectangle rect, int speed, int outLinePadding){
//		if ( speed > 100 || speed < 1 ) throw new IllegalArgumentException("Please set the message speed between 1 and 100");
//		this.rect = rect;
//		this.speed = speed;
//		this.nextFrameCount = Math.abs(speed - 100);
//		this.outLinePadding = 5;
//	}
// 
//	/**
//	 * 引数の描画領域と設定を利用してメッセージ描画オブジェクトを構築します。
//	 * @param rect 描画領域
//	 * @param speed メッセージスピード
//	 */
//	public MessageDrawAnimation(Rectangle rect, int speed){
//		this(rect, speed, 1);
//	}
// 
//	/**
//	 * デフォルトの設定で描画を実行する文字列を追加します。
//	 * @param str
//	 */
//	public void add(String text) {
//		add(text, new Font(Font.MONOSPACED, Font.PLAIN, 12), Color.BLACK);
//	}
// 
//	/**
//	 * 指定されたフォントと色設定で描画を実行する文字列を追加します。
//	 * @param str
//	 */
//	public void add(String text, Font font, Color color) {
//		MDAAttributedString as = new MDAAttributedString(text);
//		as.setAttribute(TextAttribute.FONT, font);
//		as.setAttribute(TextAttribute.FOREGROUND, color);
//		add(as);
//	}
// 
//	/**
//	 * 任意属性付で描画を実行する文字列を追加します。
//	 * @param str
//	 */
//	public void add(MDAAttributedString as) {
//		if ( as == null ) return ;
//		if ( isCompile ) throw new RuntimeException("Already started");
//		dataList.add(as);
//	}
// 
//	/**
//	 * このオブジェクトを1フレーム進行させます。
//	 */
//	public void update() {
//		frameCount++;
//		while ( frameCount > nextFrameCount && nextIndex < dataList.size() ) {
//			MDAAttributedString as = dataList.get(nextIndex);
//			String text = as.getText();
//			if ( nextTextIndex < text.length() ) {
//				currentText.append(text.charAt(nextTextIndex));
//				ensureCache = null;
//				nextTextIndex++;
//				frameCount = 0;
//			} else {
//				nextIndex++;
//				nextTextIndex = 0;
//				if ( nextIndex >= dataList.size() ) endOfAnimation = true;
//			}
//		}
//	}
// 
//	/**
//	 * 現在の設定で確定し、必要な情報を計算します。
//	 * @param g
//	 */
//	public void compile(Graphics g) {
// 
//		final StringBuilder sb = new StringBuilder();
//		int len = dataList.size();
//		int startIndex[] = new int[len];
//		int endIndex[] = new int[len];
//		ArrayList<Map<? extends AttributedCharacterIterator.Attribute, ?>> attrs = new ArrayList<>(len);
//		for ( int i = 0;i < dataList.size();i++ ) {
//			MDAAttributedString as = dataList.get(i);
//			if ( i == 0 ) {
//				startIndex[i] = 0;
//				endIndex[i] = as.text.length();
//			} else {
//				startIndex[i] = endIndex[i-1];
//				endIndex[i] = endIndex[i-1] + as.text.length();
//			}
//			attrs.add(as.getAttributes());
//			sb.append(as.text);
//		}
// 
//		String text = sb.toString();
//		AttributedString as2 = new AttributedString(text);
//		for ( int i = 0;i < len;i++ ) {
//			as2.addAttributes(attrs.get(i), startIndex[i], endIndex[i]);
//		}
//		Graphics2D g2 = (Graphics2D)g;
// 
//		FontRenderContext context = g2.getFontRenderContext();
//		LineBreakMeasurer measurer = new LineBreakMeasurer(as2.getIterator(), context);
// 
//		int position;
//		int wrappingWidth = rect.width;
//		float dy=0;
//		float dx=0;
//		float y = rect.y;
//		float x = rect.x;
// 
//		ArrayList<Position> arr = new ArrayList<>();
// 
//		// 文字列の最後まで
//		while ((position = measurer.getPosition()) < text.length()) {
// 
//			TextLayout layout;
// 
//			// 改行検索
//			int indexOf = text.indexOf("\n", position);
// 
//			if (position <= indexOf && indexOf < measurer.nextOffset(wrappingWidth)) {
//				// 改行位置の手前の分まで取得
//				layout = measurer.nextLayout(wrappingWidth, ++indexOf, false);
//			} else {
//				// 自動で折り返してるとこまで取得
//				layout = measurer.nextLayout(wrappingWidth);
//				indexOf = measurer.getPosition();
//			}
// 
//			if (layout == null) {
//				break;
//			}
// 
//			dy += layout.getAscent();
// 
//			dx = layout.isLeftToRight() ? 0 : (wrappingWidth - layout
//					.getAdvance());
// 
//			// 文字列を書きだす位置情報
//			Position pos = new Position();
// 
//			//描画位置の算出
//			pos.x = x + dx;
//			pos.y = y + dy;
//			pos.idx = indexOf;
//			arr.add(pos);
// 
//			dy += layout.getDescent() + layout.getLeading();
//		}
//		this.posList = arr.toArray(new Position[arr.size()]);
// 
//		isCompile = true;
//	}
// 
//	/**
//	 * 文字列を描画します。
//	 * @param g
//	 */
//	public void drawString(Graphics g) {
//		final Graphics2D g2 = (Graphics2D)g;
//		String text = currentText.toString();
//		if ( text.length() > 0 ) {
//			if ( ensureCache == null ) {
//				AttributedString result = new AttributedString(text);
//				for ( int i = 0,index=0;i < nextIndex+1;i++ ) {
//					MDAAttributedString as = dataList.get(i);
//					int len = as.text.length() + index;
//					if ( len > text.length() ) {
//						len = text.length();
//					}
//					result.addAttributes(as.getAttributes(), index, len);
//					index = len;
//				}
//				ensureCache = result;
//			}
//			_drawString(g2, ensureCache, text);
//		}
//	}
// 
//	private void _drawString(Graphics2D g2, AttributedString as, String text) {
// 
//		if ( text == null || text.length() <= 0 ) return;
// 
//		if ( !isCompile ) {
//			compile(g2);
//		}
// 
//		int wrappingWidth = rect.width;
// 
//		FontRenderContext context = g2.getFontRenderContext();
// 
//		LineBreakMeasurer measurer = new LineBreakMeasurer(as.getIterator(), context);
// 
//		for (int i = 0;(measurer.getPosition()) < text.length();i++) {
//			TextLayout layout;
// 
//			Position pos = posList[i];
// 
//			int indexOf = pos.idx;
// 
//			//次のindexが現在の文字列より長かった場合は文字の長さにする
//			if (text.length() < indexOf) {
//				layout = measurer.nextLayout(wrappingWidth, text.length(), false);
//			}else {
//				layout = measurer.nextLayout(wrappingWidth, indexOf, false);
//			}
// 
//			//取得不能か、矩形領域からはみ出たら処理を終了
//			if (layout == null || pos.y + layout.getDescent()
//			 + layout.getLeading() > rect.y + rect.height) {
//				break;
//			}
// 
//			// 文字列の描画
//			layout.draw(g2, pos.x, pos.y);
//		}
//	}
// 
//	/**
//	 * このメッセージアニメーションの枠を描画します。
//	 * @param g
//	 */
//	public void drawRect(Graphics g) {
//		g.drawRect(
//				rect.x-outLinePadding
//				,rect.y-outLinePadding
//				,rect.width+outLinePadding+outLinePadding
//				,rect.height+outLinePadding+outLinePadding
//		);
//	}
// 
//	/**
//	 * このメッセージアニメーションの枠を塗りつぶします。
//	 * @param g
//	 */
//	public void fillRect(Graphics g) {
//		g.fillRect(
//				rect.x-outLinePadding
//				,rect.y-outLinePadding
//				,rect.width+outLinePadding+outLinePadding
//				,rect.height+outLinePadding+outLinePadding
//		);
//	}
// 
//	/**
//	 * このメッセージアニメーションの枠を角を丸めて描画します。
//	 * @param g
//	 */
//	public void drawRoundRect(Graphics g) {
//		g.drawRoundRect(
//				rect.x-outLinePadding
//				,rect.y-outLinePadding
//				,rect.width+outLinePadding+outLinePadding
//				,rect.height+outLinePadding+outLinePadding
//				, 10
//				, 10
//		);
//	}
// 
//	/**
//	 * このメッセージアニメーションの枠を角を丸めて塗りつぶします。
//	 * @param g
//	 */
//	public void fillRoundRect(Graphics g) {
//		g.fillRoundRect(
//				rect.x-outLinePadding
//				,rect.y-outLinePadding
//				,rect.width+outLinePadding+outLinePadding
//				,rect.height+outLinePadding+outLinePadding
//				, 10
//				, 10
//		);
//	}
// 
//	/**
//	 * メッセージスピードを返します。
//	 * @return
//	 */
//	public int getSpeed() {
//		return speed;
//	}
// 
// 
//	/**
//	 * メッセージアニメーションが終了したかを返します。
//	 * @return
//	 */
//	public boolean isEndOfAnimation() {
//		return endOfAnimation;
//	}
// 
//	/**
//	 * 書式付文字列クラスです。
//	 * 文字列に任意の属性を付加したい場合に利用できます。
//	 */
//	public static class MDAAttributedString{
//		private String text;
//		private Map<AttributedCharacterIterator.Attribute,Object> attributes = new HashMap<>();
//		/**
//		 * 引数の文字を描画するためのAttributedStringオブジェクトを構築します。
//		 * @param text 文字列
//		 */
//		public MDAAttributedString(String text){
//			this.text = text.replaceAll("\\r\\n|\\r","\n");
//		}
//		/**
//		 * 属性を付加します
//		 * @param attr
//		 * @param value
//		 */
//		public void setAttribute(AttributedCharacterIterator.Attribute attr, Object value) {
//			attributes.put(attr, value);
//		}
//		public Object getAttribute(AttributedCharacterIterator.Attribute attr) {
//			return attributes.get(attr);
//		}
//		public Object removeAttribute(AttributedCharacterIterator.Attribute attr) {
//			return attributes.remove(attr);
//		}
//		/**
//		 * 文字列を取得します。
//		 * @return
//		 */
//		public String getText() {
//			return text;
//		}
//		public Map<? extends AttributedCharacterIterator.Attribute,?> getAttributes(){
//			return attributes;
//		}
//	}
//	private class Position{
//		float x;
//		float y;
//		int idx;
//	}
//}