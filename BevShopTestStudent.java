import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {

	private BevShop bevShop = new BevShop();
	
	@BeforeEach
	void setUp() throws Exception {
		bevShop.startNewOrder(7, Day.MONDAY, "Joe", 80);
		bevShop.getCurrentOrder().addNewBeverage("Alcohol-1", Size.LARGE);
		bevShop.getCurrentOrder().addNewBeverage("Coffee-1", Size.MEDIUM, true, false);
		bevShop.getCurrentOrder().addNewBeverage("Smoothie-1", Size.SMALL, 5, true);
		
		bevShop.startNewOrder(10, Day.MONDAY, "John", 70);
		bevShop.getCurrentOrder().addNewBeverage("Alcohol-2", Size.MEDIUM);
		bevShop.getCurrentOrder().addNewBeverage("Coffee-2", Size.SMALL, true, true);
		bevShop.getCurrentOrder().addNewBeverage("Smoothie-2", Size.LARGE, 5, false);
	}

	@AfterEach
	void tearDown() throws Exception {
		bevShop = null;
	}

	@Test
	void testBevShop() {
		assertFalse(bevShop.getCurrentOrder().isWeekend());
	}

	@Test
	void testIsValidTime() {
		assertFalse(bevShop.isValidTime(bevShop.getOrderAtIndex(0).getOrderTime()));
		assertTrue(bevShop.isValidTime(bevShop.getOrderAtIndex(1).getOrderTime()));
	}

	@Test
	void testGetMaxNumOfFruits() {
		assertEquals(5, bevShop.getMaxNumOfFruits());
	}

	@Test
	void testGetMinAgeForAlcohol() {
		assertEquals(21, bevShop.getMinAgeForAlcohol());
	}

	@Test
	void testIsMaxFruit() {
		assertTrue(bevShop.isMaxFruit(9));
	}

	@Test
	void testGetMaxOrderForAlcohol() {
		assertEquals(3, bevShop.getMaxOrderForAlcohol());
	}

	@Test
	void testIsEligibleForMore() {
		assertTrue(bevShop.isEligibleForMore());
	}

	@Test
	void testGetNumOfAlcoholDrink() {
		assertEquals(2, bevShop.getNumOfAlcoholDrink());
	}

	@Test
	void testIsValidAge() {
		assertTrue(bevShop.isValidAge(22));
		assertFalse(bevShop.isValidAge(18));
	}

	@Test
	void testStartNewOrder() {
		bevShop.startNewOrder(7, Day.MONDAY, "Joe", 200);
		assertEquals(200, bevShop.getCurrentOrder().getCustomer().getAge());
	}

	@Test
	void testProcessCoffeeOrder() {
		bevShop.processCoffeeOrder("A", Size.SMALL, false, false);
		assertEquals(Type.COFFEE, bevShop.getCurrentOrder().getBeverage(3).getType());
	}

	@Test
	void testProcessAlcoholOrder() {
		bevShop.processAlcoholOrder("A", Size.SMALL);
		assertEquals(Type.ALCOHOL, bevShop.getCurrentOrder().getBeverage(3).getType());
	}

	@Test
	void testProcessSmoothieOrder() {
		bevShop.processSmoothieOrder("A", Size.LARGE, 5, true);
		assertEquals(Type.SMOOTHIE, bevShop.getCurrentOrder().getBeverage(3).getType());
	}

	@Test
	void testFindOrder() {
		assertEquals(0, bevShop.findOrder(bevShop.getCurrentOrder().getOrderNo()));
	}

	@Test
	void testTotalOrderPrice() {
		assertEquals(12.5, bevShop.getCurrentOrder().calcOrderTotal());
	}

	@Test
	void testTotalMonthlySale() {
		assertEquals(26, bevShop.totalMonthlySale());
	}

	@Test
	void testTotalNumOfMonthlyOrders() {
		assertEquals(2, bevShop.totalNumOfMonthlyOrders());
	}

	@Test
	void testGetCurrentOrder() {
		assertEquals(Day.MONDAY, bevShop.getCurrentOrder().getOrderDay());
	}

	@Test
	void testGetOrderAtIndex() {
		assertEquals(Day.MONDAY, bevShop.getOrderAtIndex(0).getOrderDay());
	}

	@Test
	void testSortOrders() {
		bevShop.sortOrders();
		assertEquals("John", bevShop.getOrderAtIndex(0).getCustomer().getName());
	}

	@Test
	void testToString() {
		assertEquals("0,7,MONDAY,80,Alcohol-1,Coffee-1,Smoothie-1,,0,10,MONDAY,70,Alcohol-2,Coffee-2,Smoothie-2,,26.0", bevShop.toString());
	}

}
