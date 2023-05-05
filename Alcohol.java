
public class Alcohol extends Beverage {

	private boolean isWeekend;
	
	Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	// getters
	public boolean isWeekend() {
		return isWeekend;
	}
	
	// process
	@Override
	public double calcPrice() {
		double total = super.addSizePrice();
		
		if (isWeekend()) {
			total += 0.60;
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		return getBevName() + "," + getSize() + "," + isWeekend + "," + calcPrice();
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		Alcohol temp = (Alcohol)anotherBev;
		
		if (getBevName().equals(temp.getBevName()) && getType().equals(temp.getType()) && getSize().equals(temp.getSize()) && getBasePrice() == temp.getBasePrice() && isWeekend == temp.isWeekend) {
			return true;
		}
		
		return false;
	}
	
}
