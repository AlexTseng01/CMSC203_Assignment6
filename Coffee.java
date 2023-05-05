
public class Coffee extends Beverage {

	private boolean extraShot;
	private boolean extraSyrup;
	
	Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	// getters
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	// process
	@Override
	public double calcPrice() {
		double total = super.addSizePrice();
		
		if (extraShot == true) {
			total += 0.50;
		}
		
		if (extraSyrup == true) {
			total += 0.50;
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		return getBevName() + "," + getSize() + "," + extraShot + "," + extraSyrup + "," + calcPrice();
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		Coffee temp = (Coffee)anotherBev;
		
		if (getBevName().equals(temp.getBevName()) && getType().equals(temp.getType()) && getSize().equals(temp.getSize()) && calcPrice() == temp.calcPrice() && extraShot == temp.extraShot && extraSyrup == temp.extraSyrup) {
			return true;
		}
		
		return false;
	}
	
}
