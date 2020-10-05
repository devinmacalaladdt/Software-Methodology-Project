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
class MoneyMarketTest {
	MoneyMarket[] moneyMarket = new MoneyMarket[10];
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
		int x;
		moneyMarket[0] = new MoneyMarket(new Profile("person", "0"), 250, new Date("01/01/2000"));//0 withdrawal
		moneyMarket[1] = new MoneyMarket(new Profile("person", "1"), 250, new Date("01/01/2000"));//6 withdrawal
		for(x=0;x<6;x++) moneyMarket[1].incrementWithdrawals();
		moneyMarket[2] = new MoneyMarket(new Profile("person", "2"), 2500, new Date("01/01/2000"));//0
		moneyMarket[3] = new MoneyMarket(new Profile("person", "3"), 2500, new Date("01/01/2000"));//6
		for(x=0;x<6;x++) moneyMarket[3].incrementWithdrawals();
		moneyMarket[4] = new MoneyMarket(new Profile("person", "4"), 2500, new Date("01/01/2000"));//1
		for(x=0;x<1;x++) moneyMarket[4].incrementWithdrawals();
		moneyMarket[5] = new MoneyMarket(new Profile("person", "5"), 2500, new Date("01/01/2000"));//7
		for(x=0;x<7;x++) moneyMarket[5].incrementWithdrawals();
		moneyMarket[6] = new MoneyMarket(new Profile("person", "6"), 2499, new Date("01/01/2000"));//3
		for(x=0;x<3;x++) moneyMarket[6].incrementWithdrawals();
		moneyMarket[7] = new MoneyMarket(new Profile("person", "0"), 2499, new Date("01/01/2000"));//9
		for(x=0;x<9;x++) moneyMarket[7].incrementWithdrawals();
		moneyMarket[8] = new MoneyMarket(new Profile("person", "0"), 5000, new Date("01/01/2000"));//0
		moneyMarket[9] = new MoneyMarket(new Profile("person", "0"), 5000, new Date("01/01/2000"));//7
		for(x=0;x<7;x++) moneyMarket[9].incrementWithdrawals();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link transaction.MoneyMarket#monthlyInterest()}.
	 */
	@Test
	void testMonthlyInterest() {
		//fail("Not yet implemented");
		assertEquals(moneyMarket[0].monthlyInterest(),0.0065);
		assertEquals(moneyMarket[1].monthlyInterest(),0.0065);
		assertEquals(moneyMarket[2].monthlyInterest(),0.0065);
		assertEquals(moneyMarket[3].monthlyInterest(),0.0065);
		assertEquals(moneyMarket[4].monthlyInterest(),0.0065);
		assertEquals(moneyMarket[5].monthlyInterest(),0.0065);
		assertEquals(moneyMarket[6].monthlyInterest(),0.0065);
		assertEquals(moneyMarket[7].monthlyInterest(),0.0065);
		assertEquals(moneyMarket[8].monthlyInterest(),0.0065);
		assertEquals(moneyMarket[9].monthlyInterest(),0.0065);
	}

	/**
	 * Test method for {@link transaction.MoneyMarket#monthlyFee()}.
	 */
	@Test
	void testMonthlyFee() {
		//fail("Not yet implemented");
		assertEquals(moneyMarket[0].monthlyFee(),12);
		assertEquals(moneyMarket[1].monthlyFee(),12);
		assertEquals(moneyMarket[2].monthlyFee(),0);
		assertEquals(moneyMarket[3].monthlyFee(),0);
		assertEquals(moneyMarket[4].monthlyFee(),0);
		assertEquals(moneyMarket[5].monthlyFee(),12);
		assertEquals(moneyMarket[6].monthlyFee(),12);
		assertEquals(moneyMarket[7].monthlyFee(),12);
		assertEquals(moneyMarket[8].monthlyFee(),0);
		assertEquals(moneyMarket[9].monthlyFee(),12);

	}

}
