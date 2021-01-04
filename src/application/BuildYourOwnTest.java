package application;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * JUnit Testing for the pizzaPrice method in BuildYourOwn class.
 * @author Harsh Patel and Jishan Desai
 *
 */
public class BuildYourOwnTest {

	/**
	 * Test method for {@link application.BuildYourOwn#pizzaPrice()}.
	 */
	@Test
	public void testPizzaPrice() {
		ArrayList<String> toppings = new ArrayList<>();
		ArrayList<String> toppings1 = new ArrayList<>();
		ArrayList<String> toppings2 = new ArrayList<>();
		ArrayList<String> toppings3 = new ArrayList<>();
		ArrayList<String> toppings4 = new ArrayList<>();
		ArrayList<String> toppings5 = new ArrayList<>();
		
		Pizza build_your_own = new BuildYourOwn("Build Your Own", "small(10”)", toppings);
		assertEquals(5, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "medium(12”)", toppings);
		assertEquals(7, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "large(14”)", toppings);
		assertEquals(9, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		toppings.add("Cheese"); 
		toppings1.add("Cheese"); toppings1.add("Onion");
		toppings2.add("Cheese"); toppings2.add("Onion"); toppings2.add("Green Pepper");
		toppings3.add("Cheese"); toppings3.add("Onion"); toppings3.add("Green Pepper"); toppings3.add("Mushroom"); 
		toppings4.add("Cheese"); toppings4.add("Onion"); toppings4.add("Green Pepper"); toppings4.add("Mushroom"); toppings4.add("Olives"); 
		toppings5.add("Cheese"); toppings5.add("Onion"); toppings5.add("Green Pepper"); toppings5.add("Mushroom"); toppings5.add("Olives"); toppings5.add("Jalopeno");
 		
		//small
		
		build_your_own = new BuildYourOwn("Build Your Own", "small(10”)", toppings);
		assertEquals(7, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "small(10”)", toppings1);
		assertEquals(9, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "small(10”)", toppings2);
		assertEquals(11, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "small(10”)", toppings3);
		assertEquals(13, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "small(10”)", toppings4);
		assertEquals(15, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "small(10”)", toppings5);
		assertEquals(17, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		// medium
		
		build_your_own = new BuildYourOwn("Build Your Own", "medium(12”)", toppings);
		assertEquals(9, build_your_own.pizzaPrice());
		assertNotEquals(11, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "medium(12”)", toppings1);
		assertEquals(11, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "medium(12”)", toppings2);
		assertEquals(13, build_your_own.pizzaPrice());
		assertNotEquals(11, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "medium(12”)", toppings3);
		assertEquals(15, build_your_own.pizzaPrice());
		assertNotEquals(11, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "medium(12”)", toppings4);
		assertEquals(17, build_your_own.pizzaPrice());
		assertNotEquals(11, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "medium(12”)", toppings5);
		assertEquals(19, build_your_own.pizzaPrice());
		assertNotEquals(11, build_your_own.pizzaPrice());
		
		//large 
		
		build_your_own = new BuildYourOwn("Build Your Own", "large(14”)", toppings);
		assertEquals(11, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "large(14”)", toppings1);
		assertEquals(13, build_your_own.pizzaPrice());
		assertNotEquals(10, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "large(14”)", toppings2);
		assertEquals(15, build_your_own.pizzaPrice());
		assertNotEquals(11, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "large(14”)", toppings3);
		assertEquals(17, build_your_own.pizzaPrice());
		assertNotEquals(11, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "large(14”)", toppings4);
		assertEquals(19, build_your_own.pizzaPrice());
		assertNotEquals(11, build_your_own.pizzaPrice());
		
		build_your_own = new BuildYourOwn("Build Your Own", "large(14”)", toppings5);
		assertEquals(21, build_your_own.pizzaPrice());
		assertNotEquals(11, build_your_own.pizzaPrice());
	}

}
