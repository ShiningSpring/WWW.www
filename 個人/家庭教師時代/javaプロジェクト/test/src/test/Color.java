package test;

public class Color {
	private String name;
	
	Color(String getName){
		name = getName;
	}
	
	public String getname() {
		return "色は" + this.name;
	}
	
	public void setName(String set) {
		name = set;
	}
}
