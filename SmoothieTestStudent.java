import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

	Smoothie s1;
	@BeforeEach
	void setUp() throws Exception {
		s1 = new Smoothie("Smoothie1", Size.SMALL, 1, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		s1 = null;
	}

	@Test
	void testToString() {
		assertEquals("Smoothie1,SMALL,true,1,4.0", s1.toString());
	}

	@Test
	void testEqualsObject() {
		assertTrue(s1.equals(s1));
		assertFalse(s1.equals(new Smoothie("Smoothie2", Size.MEDIUM, 1, false)));
	}

	@Test
	void testCalcPrice() {
		assertEquals(4, s1.calcPrice());
	}

	@Test
	void testSmoothie() {
		assertEquals("Smoothie1", s1.getBevName());
	}

	@Test
	void testGetNumOfFruits() {
		assertEquals(1, s1.getNumOfFruits());
	}

	@Test
	void testGetAddProtein() {
		assertTrue(s1.getAddProtein());
	}

}
