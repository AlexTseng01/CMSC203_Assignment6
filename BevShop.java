import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface {

	private ArrayList<Order> orders = new ArrayList();
	
	public BevShop() {
		
	}

	@Override
	public boolean isValidTime(int time) {
		// inclusive
		if (time <= MAX_TIME && time >= MIN_TIME) {
			return true;
		}
		
		return false;
	}

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > MAX_FRUIT) {
			return true;
		}
		
		return false;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		int count = 0;
		
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getBeverage(i).getType().equals(Type.ALCOHOL)) {
				count++;
			}
		}
		
		if (count < MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}
		
		return false;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		int count = 0;
		
		for (int i = 0; i < orders.size(); i++) {
			count += orders.get(i).findNumOfBeveType(Type.ALCOHOL);
		}
		
		return count;
	}

	@Override
	public boolean isValidAge(int age) {
		if (age >= MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		
		return false;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		// create a customer
		Customer customer = new Customer(customerName, customerAge);
		// add customer's order
		orders.add(new Order(time, day, customer));
	}

	// orders.size() - 1 refers to last element of ArrayList (AKA the current order)
	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orders.get(orders.size() - 1).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		orders.get(orders.size() - 1).addNewBeverage(bevName, size);
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		orders.get(orders.size() - 1).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		
		return 0;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double total = 0.0;
		for (int i = 0; i < orders.size(); i++) {
			total += orders.get(i).calcOrderTotal();
		}
		
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		return orders.get(orders.size() - 1);
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	@Override
	public void sortOrders() {
		Order small, big;
		
		for (int i = 0; i < orders.size(); i++) {
			for (int j = 0; j < orders.size(); j++) {
				if (orders.get(i).calcOrderTotal() > orders.get(j).calcOrderTotal()) {
					//Collections.swap(orders, i, j);
					small = orders.get(j);
					big = orders.get(i);
					
					orders.remove(i);
					orders.add(small);
					orders.remove(j);
					orders.add(big);
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String temp = "";
		for (int i = 0; i < orders.size(); i++) {
			temp += orders.get(i) + ",";
		}
		return temp + totalMonthlySale();
	}
}
