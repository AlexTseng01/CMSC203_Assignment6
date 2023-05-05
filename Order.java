import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order> {

	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private int orderNumber;
	// stores the order or beverages
	private ArrayList<Beverage> beverages = new ArrayList();

	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
	}
	
	public int generateOrder() {
		int max = 90000;
		int min = 10000;
		int range = max - min + 1;
		
		int codeNum = (int)(Math.random() * range) + min;
		
		return codeNum;
	}
	
	// getters and setters
	public int getOrderNo() {
		this.orderNumber = generateOrder();
		return orderNumber;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public Customer getCustomer() {
		// deep copy
		Customer temp = new Customer(cust.getName(), cust.getAge());
		return temp;
	}
	
	public int getTotalItems() {
		return beverages.size();
	}

	@Override
	public boolean isWeekend() {
		if (orderDay.equals(Day.SATURDAY) || orderDay.equals(Day.SUNDAY)) {
			return true;
		}
		
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return beverages.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName, size, isWeekend()));
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}

	@Override
	public double calcOrderTotal() {
		double total = 0.0;
		for (int i = 0; i < beverages.size(); i++) {
			total += beverages.get(i).calcPrice();
		}
		
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for (int i = 0; i < beverages.size(); i++) {
			if (beverages.get(i).getType().equals(type)) {
				count++;
			}
		}
		
		return count;
	}
	
	@Override
	public int compareTo(Order anotherOrder) {
		if (orderNumber == anotherOrder.orderNumber) {
			return 0;
		}
		else if (orderNumber > anotherOrder.orderNumber) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		String temp = "";
		// append to standard String
		for (int i = 0; i < beverages.size(); i++) {
			temp += beverages.get(i).getBevName() + ",";
		}
		
		return orderNumber + "," + orderTime + "," + orderDay + "," + cust.getAge() + "," + temp;
	}
}
