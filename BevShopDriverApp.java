import java.util.Scanner;

public class BevShopDriverApp {

	public static void main(String[] args) {
		
		// create a BevShop
		BevShop bevShop = new BevShop();
		
		System.out.println(BevShopInterface.MAX_ORDER_FOR_ALCOHOL);
		
		System.out.println(BevShopInterface.MIN_AGE_FOR_ALCOHOL);
		
		System.out.println("Start a new order");
		
		bevShop.startNewOrder(9, Day.TUESDAY, "John", 23);
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println(bevShop.getCurrentOrder().getCustomer().getName());
		System.out.println(bevShop.getCurrentOrder().getCustomer().getAge());
		
		System.out.println(bevShop.getCurrentOrder().isWeekend());
		
		System.out.println("Add alcohol drink");
		
		bevShop.getCurrentOrder().addNewBeverage("Something", Size.SMALL);
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println(bevShop.getCurrentOrder().isWeekend());
		
		System.out.println("Add second alcohol drink");
		
		bevShop.getCurrentOrder().addNewBeverage("Something", Size.LARGE);
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println(bevShop.getCurrentOrder().findNumOfBeveType(Type.ALCOHOL));
		
		System.out.println("Add third alcohol drink");
		
		bevShop.getCurrentOrder().addNewBeverage("Something", Size.SMALL);
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println(bevShop.getCurrentOrder().findNumOfBeveType(Type.ALCOHOL));
		
		System.out.println("Maximum alcohol drink for this order");
		
		System.out.println("Add a COFFEE to order");
		
		bevShop.getCurrentOrder().addNewBeverage("Something", Size.SMALL, true, true);
		
		System.out.println(bevShop.getCurrentOrder().findNumOfBeveType(Type.ALCOHOL));
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Start a new order");
		
		bevShop.startNewOrder(7, Day.SUNDAY, "Joe", 0);
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Add a SMOOTHIE to order");
		
		bevShop.getCurrentOrder().addNewBeverage("Something", Size.SMALL, 9, false);
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Add a COFFEE to order");
		
		bevShop.getCurrentOrder().addNewBeverage("Something", Size.SMALL, true, true);
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println(bevShop.getCurrentOrder().getCustomer().getAge());
		
		System.out.println("Age not appropriate for alcohol drink!!");
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		bevShop.getCurrentOrder().addNewBeverage("Something", Size.SMALL, 6, true);
		
		System.out.println("Maximum number of fruits\n");
		
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Total amount for all orders:" + bevShop.totalMonthlySale());
	}
}
