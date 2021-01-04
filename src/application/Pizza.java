package application;

import java.util.ArrayList;
/**
 * Designs a basic Pizza
 * @author Jishan Desai and Harsh Patel
 *
 */

public abstract class Pizza {
	
	protected String style;
	protected String size;
	protected ArrayList<String> toppings;
	
	/**
	 * constructs a pizza with style, size and toppings
	 * @param style Style of the pizza
	 * @param size  Size of the pizza
	 * @param toppings toppings on the pizza
	 * @author Harsh Patel
	 */
	
	public Pizza(String style, String size, ArrayList<String> toppings){
		this(style, size);
		this.toppings = toppings;
	}
	
	/**
	 * constructs a pizza with style and size.
	 * @param style style of the pizza
	 * @param size size of the pizza
	 * @author Harsh Patel
	 */
	public Pizza(String style, String size){
		this.style = style;
		this.size = size;
	}
	
	/**
	 * This method is supposed to be implemented by 
	 * the subclasses of this class.
	 * @return the price of the specific pizza
	 */
	public abstract int pizzaPrice();
	
	/**
	 * returns the String representation of the Object
	 * @return string form of the object
	 * @author Jishan Desai
	 */
	public String toString() { 
		return "Pizza Style: " + this.style + "\n" + "Size: " + this.size + "\n" + "Toppings: " + this.toppings;
	}
}