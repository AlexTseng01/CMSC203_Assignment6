import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeverageTestStudent {

	private Order order;
	@BeforeEach
	void setUp() throws Exception {
		order = new Order(9, Day.FRIDAY, new Customer("Alex", 20));
		order.addNewBeverage("Bev1", Size.SMALL);
		order.addNewBeverage("Bev2", Size.LARGE);
	}

	@AfterEach
	void tearDown() throws Exception {
		order = null;
	}

	@Test
	void testBeverage() {
		assertEquals(Size.SMALL,order.getBeverage(0).getSize());
	}

	@Test
	void testGetBasePrice() {
		assertEquals(2, order.getBeverage(0).getBasePrice());
	}

	@Test
	void testGetType() {
		assertEquals(Type.ALCOHOL, order.getBeverage(0).getType());
	}

	@Test
	void testGetBevName() {
		assertEquals("Bev1", order.getBeverage(0).getBevName());
	}

	@Test
	void testGetSize() {
		assertEquals(Size.SMALL, order.getBeverage(0).getSize());
	}

	@Test
	void testAddSizePrice() {
		assertEquals(2, order.getBeverage(0).addSizePrice());
	}

	@Test
	void testToString() {
		assertEquals("Bev1,SMALL,false,2.0", order.getBeverage(0).toString());
	}

	@Test
	void testEqualsObject() {
		assertFalse(order.getBeverage(0).equals(order.getBeverage(1)));
	}

	@Test
	void testCalcPrice() {
		assertEquals(2, order.getBeverage(0).calcPrice());
	}

}
