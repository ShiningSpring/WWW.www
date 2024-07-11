package test;

public class Car {
	String make;
	
	public Car (String make) {
		this.make = make;
		
	}
	
	public String getMake() {
		return make;
	}
	
	 class Door{
		
		String make;
		
		
		public String getMake() {
			return Car.this.make;
		}
	}
}
