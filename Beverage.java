
public abstract class Beverage {

	private String bevName;
	private Type type;
	private Size size;
	final static double BASE_PRICE = 2.0;
	final static double SIZE_PRICE = 1.0;
	
	Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	// getters
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getBevName() {
		return bevName;
	}
	
	public Size getSize() {
		return size;
	}
	
	// processing
	public double addSizePrice() {
		double total = 0.0;
		
		if (size.equals(Size.SMALL)) {
			return BASE_PRICE;
		}
		else if (size.equals(Size.MEDIUM)) {
			return BASE_PRICE + SIZE_PRICE;
		}
		else {
			return BASE_PRICE + SIZE_PRICE + SIZE_PRICE;
		}
	}
	
	@Override
	public String toString() {
		return bevName + "," + size;
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		Beverage temp = (Beverage)anotherBev;
		if (bevName.equals(temp.bevName) && type.equals(temp.type) && size.equals(temp.size)) {
			return true;
		}
		
		return false;
	}
	
	public abstract double calcPrice();
	
}
