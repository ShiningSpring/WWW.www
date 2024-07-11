package test;

public class Add {
	public static void main(String[] args) {
		int ans = add(1,2,3,4,5);
		System.out.println(ans);
	}
	public static int add(int... a ) {
		int ans = 0;
		
		for (int i : a) {
			ans += i;
			
		}
		return ans;
		
		
	}
}
