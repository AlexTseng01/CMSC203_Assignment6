import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {

	private Order order;
	@BeforeEach
	void setUp() throws Exception {
		order = new Order(5, Day.MONDAY, new Customer("John", 74));
		order.addNewBeverage("Coffee", Size.LARGE, false, true);
		order.addNewBeverage("Smoothie", Size.MEDIUM, 1, false);
	}

	@AfterEach
	void tearDown() throws Exception {
		order = null;
	}

	@Test
	void testOrder() {
		assertEquals(8, order.calcOrderTotal());
	}

	@Test
	void testGenerateOrder() {
		String temp = order.generateOrder() + "";
		char[] arr = temp.toCharArray();
		assertEquals(5, arr.length);
	}

	@Test
	void testGetOrderTime() {
		assertEquals(5, order.getOrderTime());
	}

	@Test
	void testSetOrderTime() {
		order.setOrderTime(6);
		assertEquals(6, order.getOrderTime());
	}

	@Test
	void testGetOrderDay() {
		assertEquals(Day.MONDAY, order.getOrderDay());
	}

	@Test
	void testGetCustomer() {
		assertEquals("John", order.getCustomer().getName());
	}

	@Test
	void testGetTotalItems() {
		assertEquals(2, order.getTotalItems());
	}

	@Test
	void testIsWeekend() {
		assertFalse(order.isWeekend());
	}

	@Test
	void testGetBeverage() {
		assertEquals("Smoothie", order.getBeverage(1).getBevName());
	}

	@Test
	void testAddNewBeverage() {
		order.addNewBeverage("Alcohol1", Size.SMALL);
		assertEquals(Size.SMALL, order.getBeverage(2).getSize());
		order.addNewBeverage("Smoothie1", Size.MEDIUM, 3, true);
		assertEquals(Size.MEDIUM, order.getBeverage(3).getSize());
		assertEquals(Size.LARGE, order.getBeverage(0).getSize());
	}

	@Test
	void testCalcOrderTotal() {
		assertEquals(8, order.calcOrderTotal());
	}

	@Test
	void testFindNumOfBeveType() {
		assertEquals(0, order.findNumOfBeveType(Type.ALCOHOL));
		assertEquals(1, order.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
	}

	@Test
	void testCompareTo() {
		Order temp = order;
		assertEquals(0, order.compareTo(temp));
	}

	@Test
	void testToString() {
		assertEquals("0,5,MONDAY,74,Coffee,Smoothie,", order.toString());
	}

}
