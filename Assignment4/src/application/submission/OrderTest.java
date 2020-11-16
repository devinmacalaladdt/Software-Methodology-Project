/**
 * JUnit test class for Order.java
 * @author Devin Macalalad, David Gasperini
 */
package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {
	static Order order;

	static Sandwich fish;
	static Sandwich beef;
	static Chicken chicken;
	static OrderLine beefOrder;
	static OrderLine fishOrder;
	static OrderLine chickenOrder;
	
	/**
	 * Initialize 
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		order = new Order();
		fish = new Fish();
		beef = new Beef();
		chicken = new Chicken();
		beefOrder = new OrderLine(beef, beef.price());
		fishOrder = new OrderLine(fish, fish.price());
		chickenOrder = new OrderLine(chicken, chicken.price());
	}

	/**
	 * Unused
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	
	}

	/**
	 * Unused
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
	}

	/**
	 * Unused
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	
	}
	
	/***
	 *Tests the add method 
	 */
	@Test
	void testAdd() {
		Object o = new Object();
		String string = new String("abc");
		assertFalse(order.add(o));
		assertFalse(order.add(string));
		assertFalse(order.add(null));
		assertFalse(order.add(""));
		assertFalse(order.add(beef));
		assertFalse(order.add(fish));
		assertFalse(order.add(chicken));
		assertFalse(order.add(chicken));
		assertTrue(order.add(chickenOrder));
		assertTrue(order.add(chickenOrder));
		assertTrue(order.add(fishOrder));
		assertTrue(order.add(new OrderLine(fish, 12.99)));
		assertTrue(order.add(new OrderLine(chicken, 8.99)));
		assertTrue(order.add(beefOrder));
	}

	/***
	 *Tests the getOrderLine method 
	 */
	@Test
	void testGetOrderLine() {
		ArrayList<OrderLine> lines = order.getOrderLine();
		assertEquals(lines.size(), 6);
		assertEquals(lines.get(0).getSandwich().toString(), "Chicken Sandwich: Fried Chicken, Spicy Sauce, Pickles, Price $8.99");
		assertEquals(lines.get(1).getSandwich().toString(), "Chicken Sandwich: Fried Chicken, Spicy Sauce, Pickles, Price $8.99");
		assertEquals(lines.get(2).getSandwich().toString(), "Fish Sandwich: Grilled Snapper, Cilantro, Lime, Price $12.99");
		assertEquals(lines.get(3).getSandwich().toString(), "Fish Sandwich: Grilled Snapper, Cilantro, Lime, Price $12.99");
		assertEquals(lines.get(4).getSandwich().toString(), "Chicken Sandwich: Fried Chicken, Spicy Sauce, Pickles, Price $8.99");
		assertEquals(lines.get(5).getSandwich().toString(), "Beef Sandwich: Roast Beef, Provolone Cheese, Mustard, Price $10.99");
	}

	/***
	 *Tests the remove method 
	 */
	@Test
	void testRemove() {
		Object o = new Object();
		assertFalse(order.remove(null));
		assertFalse(order.remove(o));
		assertFalse(order.remove(""));
		assertFalse(order.remove(new String("abc")));
		assertFalse(order.remove(fish));
		assertFalse(order.remove(new OrderLine(fish, 12.99)));
		assertFalse(order.remove(new OrderLine(chicken, chicken.price())));
		assertTrue(order.remove(beefOrder));
		assertTrue(order.remove(chickenOrder));
		assertTrue(order.remove(fishOrder));
		assertFalse(order.remove(fishOrder));
		assertTrue(order.remove(chickenOrder));
		assertFalse(order.remove(chickenOrder));
		for(OrderLine ol : order.getOrderLine())
			assertTrue(order.remove(ol));
	}
	
}
