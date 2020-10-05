/**
 * 
 */
package transaction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dlg42
 *
 */
class CheckingTest {
	Checking[] checking = new Checking[10];
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
		checking[0] = new Checking(new Profile("person", "0"), 250, new Date("01/01/2000"), true);
		checking[1] = new Checking(new Profile("person", "1"), 250, new Date("01/01/2000"), false);
		checking[2] = new Checking(new Profile("person", "2"), 1500, new Date("01/01/2000"), true);
		checking[3] = new Checking(new Profile("person", "3"), 1500, new Date("01/01/2000"), false);
		checking[4] = new Checking(new Profile("person", "4"), -250, new Date("01/01/2000"), true);
		checking[5] = new Checking(new Profile("person", "5"), -250, new Date("01/01/2000"), false);
		checking[6] = new Checking(new Profile("person", "6"), 0, new Date("01/01/2000"), true);
		checking[7] = new Checking(new Profile("person", "0"), 0, new Date("01/01/2000"), false);
		checking[8] = new Checking(new Profile("person", "0"), 5000, new Date("01/01/2000"), true);
		checking[9] = new Checking(new Profile("person", "0"), 5000, new Date("01/01/2000"), false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link transaction.Checking#monthlyInterest()}.
	 */
	@Test
	void testMonthlyInterest() {
		//fail("Not yet implemented");
		assertEquals(checking[0].monthlyInterest(),0.0005);
		assertEquals(checking[1].monthlyInterest(),0.0005);
		assertEquals(checking[2].monthlyInterest(),0.0005);
		assertEquals(checking[3].monthlyInterest(),0.0005);
		assertEquals(checking[4].monthlyInterest(),0.0005);
		assertEquals(checking[5].monthlyInterest(),0.0005);
		assertEquals(checking[6].monthlyInterest(),0.0005);
		assertEquals(checking[7].monthlyInterest(),0.0005);
		assertEquals(checking[8].monthlyInterest(),0.0005);
		assertEquals(checking[9].monthlyInterest(),0.0005);
	}

	/**
	 * Test method for {@link transaction.Checking#monthlyFee()}.
	 */
	@Test
	void testMonthlyFee() {
		//fail("Not yet implemented");
		assertEquals(checking[0].monthlyFee(),0);
		assertEquals(checking[1].monthlyFee(),25);
		assertEquals(checking[2].monthlyFee(),0);
		assertEquals(checking[3].monthlyFee(),0);
		assertEquals(checking[4].monthlyFee(),0);
		assertEquals(checking[5].monthlyFee(),25);
		assertEquals(checking[6].monthlyFee(),0);
		assertEquals(checking[7].monthlyFee(),25);
		assertEquals(checking[8].monthlyFee(),0);
		assertEquals(checking[9].monthlyFee(),0);
	}

}
