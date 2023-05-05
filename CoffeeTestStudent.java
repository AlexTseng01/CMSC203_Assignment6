import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	Coffee c1;
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Coffee("Coffee1", Size.MEDIUM, true, false);
	}

	@AfterEach
	void tearDown() throws Exception {
		c1 = null;
	}

	@Test
	void testToString() {
		assertEquals("Coffee1,MEDIUM,true,false,3.5", c1.toString());
	}

	@Test
	void testEqualsObject() {
		assertTrue(c1.equals(c1));
		assertFalse(c1.equals(new Coffee("Coffee2", Size.MEDIUM, true, false)));
	}

	@Test
	void testCalcPrice() {
		assertEquals(3.5, c1.calcPrice());
	}

	@Test
	void testCoffee() {
		assertEquals("Coffee1", c1.getBevName());
	}

	@Test
	void testGetExtraShot() {
		assertTrue(c1.getExtraShot());
	}

	@Test
	void testGetExtraSyrup() {
		assertFalse(c1.getExtraSyrup());
	}

}
