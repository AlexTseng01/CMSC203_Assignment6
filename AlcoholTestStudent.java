import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {

	private Alcohol alcohol1 = new Alcohol("Alcohol-1", Size.LARGE, true);
	private Alcohol alcohol2 = new Alcohol("Alcohol-1", Size.LARGE, true);
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		alcohol1 = alcohol2 = null;
	}

	@Test
	void testToString() {
		assertEquals("Alcohol-1,LARGE,true,4.6", alcohol1.toString());
	}

	@Test
	void testEqualsObject() {
		assertTrue(alcohol1.equals(alcohol2));
	}

	@Test
	void testCalcPrice() {
		assertEquals(4.6, alcohol1.calcPrice());
	}

	@Test
	void testAlcohol() {
		alcohol2 = new Alcohol("Random", Size.MEDIUM, false);
		assertFalse(alcohol2.equals(alcohol1));
		alcohol2 = alcohol1;
		assertTrue(alcohol2.equals(alcohol1));
	}

	@Test
	void testIsWeekend() {
		assertTrue(alcohol1.isWeekend());
	}

}
