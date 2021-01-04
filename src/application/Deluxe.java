package application;

import java.util.ArrayList;
/**
 * Creates a Deluxe Pizza by adding more attributes to the Pizza object
 * @author Jishan Desai and Harsh Patel
 *
 */
public class Deluxe extends Pizza{
	
	/**
	 * Creates a Deluxe Pizza with given style and size
	 * @param style Style of the pizza
	 * @param size  Size of the pizza
	 * @author Harsh Patel
	 */
	public Deluxe(String style, String size) {
		super(style, size);
		this.toppings = setToppings();
		
	}
	
	/**
	 * Adds predetermined toppings for Deluxe Pizza to the 
	 * ArrayList
	 * @return ArrayList with predefined toppings for Deluxe Pizza
	 * @author Harsh Patel
	 */
	private ArrayList<String> setToppings(){
		ArrayList<String> toppings = new ArrayList<String>();
		toppings.add("Sausage");
		toppings.add("Pepperoni");
		toppings.add("Green Pepper");
		toppings.add("Onion");
		toppings.add("Mushroom");
		return toppings;
	}
	
	/**
	 * represents the String representation of Deluxe Pizza Object
	 * @return String representation of the Deluxe Pizza Object
	 * @author Jishan Desai
	 */
	@Override
	public String toString() {
		return super.toString() + "\nPizza Price: $ " + this.pizzaPrice() + "\n";
	}
	
    /**
     * gets the price of the pizza and returns it
     * @return price of the Pizza as an integer
     * @author Harsh Patel
     */
	@Override
	public int pizzaPrice() {
		if(this.size.equals("small(10”)")){
			return Price.SMALL_DELUXE;
		}else if(this.size.equals("medium(12”)")) {
			return Price.MEDIUM_DELUXE;
		}
		return Price.LARGE_DELUXE;
	}

}
