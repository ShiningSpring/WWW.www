package test;

	public class mado{
		public static void main(String[] args){
			MagicalGirl[] girls = getAgreementGirls();
			//それぞれの魔法少女の行動を5回見てみます。
			for ( int i = 0;i < 5;i++ ) {
				System.out.println("===   "+(i+1)+"回目開始   ===");
				for ( int j = 0;j < girls.length;j++ ) {
					System.out.println(girls[j].name+"の行動");
					girls[j].action();
					System.out.println();
				}
				System.out.println("===   "+(i+1)+"回目終了   ===\n");
			}
		}
		static MagicalGirl[] getAgreementGirls(){
			return new MagicalGirl[]{
				new PinkGirl()
				,new YellowGirl()
				,new BlackGirl()
			};
		}
	 
	}
	class MagicalGirl{
		String name;
		int hp=100;
		int mp=100;
		void action(){}
	}
	class PinkGirl extends MagicalGirl{
		PinkGirl(){
			super.name="まど〇";
		}
		void action(){
			System.out.println("　こんなの絶対おかしいよ！！");
		}
	}
	class YellowGirl extends MagicalGirl{
		YellowGirl(){
			super.name="マ〇";
		}
		void action(){
			if ( hp <= 0 ) {
				System.out.println("　既にマ〇られ済");
			} else {
				if ( mp >= 40 ) {
					System.out.println("　ティロ・フィナー〇発動");
					mp-=40;
				} else {
					//MPがもうないから魔法が使えない
					System.out.println("　ティロ・フィナー〇はもう使えない！！");
					System.out.println("　マ〇は50のダメージを受けた。");
					hp -= 50;
				}
			}
		}
	}
	class BlackGirl extends MagicalGirl{
		int bp=100;
		BlackGirl(){
			super.name = "ほむ〇";
		}
		void action(){
			if ( bp <= 0 ) {
				System.out.println("　銃弾がない！！");
			} else {
				System.out.println("　銃を50発発射");
				bp-=50;
			}
			if ( bp <= 0 ) {
				//弾がなかったら時間停止して補充しに行きます。
				if ( mp >= 100 ) {
					System.out.println("　時間停止魔法を発動");
					System.out.println("　補充完了");
					bp+=100;
					mp-=100;
				} else {
					//MPがもうないから魔法が使えない
					System.out.println("　時間停止魔法はもう使えない！！");
				}
			}
		}
	}


