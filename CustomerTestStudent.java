import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {
	
	private Customer cust;
	@BeforeEach
	void setUp() throws Exception {
		cust = new Customer("Alex Tseng", 20);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		cust = null;
	}

	@Test
	void testCustomer() {
		assertEquals(20, cust.getAge());
	}

	@Test
	void testGetName() {
		assertEquals("Alex Tseng", cust.getName());
	}

	@Test
	void testSetName() {
		cust.setName("AT");
		assertEquals("AT", cust.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(20, cust.getAge());
	}

	@Test
	void testSetAge() {
		cust.setAge(21);
		assertEquals(21, cust.getAge());
	}

	@Test
	void testToString() {
		assertEquals("Alex Tseng,20", cust.toString());
	}

}
