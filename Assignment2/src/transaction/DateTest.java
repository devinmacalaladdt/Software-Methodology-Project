/**
 * JUnit Test class for the Date class
 */
package transaction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  @author Devin Macalalad, David Gasperini
 *
 */
class DateTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link transaction.Date#isValid()}.
	 */
	@Test
	void testIsValid() {
		//fail("Not yet implemented");
		Date[] date = new Date[12];
		date[0] = new Date("10/31/2019");
		date[1] = new Date("11/31/2019");
		date[2] = new Date("12/31/2020");
		date[3] = new Date("50/30/2018");
		date[4] = new Date("01/01/2001");
		date[5] = new Date("1/1/2001");
		date[6] = new Date("20502013");
		date[7] = new Date("aw/g/2013");
		date[8] = new Date("10/32/2010");
		date[9] = new Date("0001/10/02013");
		date[10] = new Date("02/01/10/02013");
		date[11] = new Date("0/6/2009");
		
		assertTrue(date[0].isValid());
		assertFalse(date[1].isValid());
		assertTrue(date[2].isValid());
		assertFalse(date[3].isValid());
		assertTrue(date[4].isValid());
		assertTrue(date[5].isValid());
		assertFalse(date[6].isValid());
		assertFalse(date[7].isValid());
		assertFalse(date[8].isValid());
		assertTrue(date[9].isValid());
		assertFalse(date[10].isValid());
		assertFalse(date[11].isValid());
		
	}

}
