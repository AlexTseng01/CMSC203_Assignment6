
public class Smoothie extends Beverage {

	private int numOfFruits;
	private boolean addProtein;
	
	Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	// getters
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	public boolean getAddProtein() {
		return addProtein;
	}
	
	// process
	@Override
	public double calcPrice() {
		double total = super.addSizePrice();
		
		if (addProtein == true) {
			total += 1.50;
		}
		
		double additional = numOfFruits * 0.50;
		total += additional;
		
		return total;
	}
	
	@Override
	public String toString() {
		return getBevName() + "," + getSize() + "," + addProtein + "," + numOfFruits + "," + calcPrice();
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		Smoothie temp = (Smoothie)anotherBev;
		
		if (getBevName().equals(temp.getBevName()) && getType().equals(temp.getType()) && getSize().equals(temp.getSize()) && getBasePrice() == temp.getBasePrice() && numOfFruits == temp.numOfFruits && addProtein == temp.addProtein) {
			return true;
		}
		
		return false;
	}
	
}
