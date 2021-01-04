package application;

import java.util.ArrayList;
/**
 * Designs Hawaiian Pizza by adding attributes 
 * to Pizza 
 * @author Harsh Patel and Jishan Desai
 *
 */
public class Hawaiian extends Pizza{

	/**
	 * constructs a Hawaiian pizza with style and size.
	 * @param style Style of the pizza
	 * @param size  Size of the pizza
	 * @author Harsh Patel
	 */
	public Hawaiian(String style, String size) {
		super(style, size);
		this.toppings = setToppings();
	}
	
	/**
	 * Stores designated toppings for Hawaiian Pizza to the arrayList
	 * @return ArrayList which contains toppings on Hawaiian Pizza
	 * @author Harsh Patel
	 */
	private ArrayList<String> setToppings(){
		ArrayList<String> toppings = new ArrayList<String>(); 
		toppings.add("Ham");
		toppings.add("Pineapple");
		return toppings;
	}
	
	/**
	 * String representation of Hawaiian Pizza Object
	 * @return String form of the Hawaiian Pizza
	 * @author Jishan Desai
	 */
	@Override
	public String toString() {
		return super.toString() + "\nPizza Price: $ " + this.pizzaPrice() + "\n";
	}
	
    /**
     * returns the price of the Hawaiian Pizza based on the size.
     * @return the price as an integer.
     * @author Harsh Patel
     */
	@Override
	public int pizzaPrice() {
		if(this.size.equals("small(10”)")){
			return Price.SMALL_HAWAIIAN;
		}else if(this.size.equals("medium(12”)")) {
			return Price.MEDIUM_HAWAIIAN;
		}
		return Price.LARGE_HAWAIIAN;
	}
}
