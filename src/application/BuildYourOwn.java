package application;

import java.util.ArrayList;
/**
 * Creates BuildYourOwn version of Pizza by adding 
 * more attributes to Pizza class
 * @author Jishan Desai and Harsh Patel
 *
 */
public class BuildYourOwn extends Pizza{
	
	/**
	 * Creates a pizza based on style, size and toppings
	 * @param style Style of the pizza
	 * @param size  Size of the pizza
	 * @param toppings toppings on the pizza
	 * @author Harsh Patel
	 */
	public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
	}
	
	/**
	 * Represents the String representation of the BuildYourOwn Pizza Object
	 * @return returns the string representation of BuildYourOwn Pizza Object
	 * @author Jishan Desai
	 */
	@Override
	public String toString() {
		return super.toString() + "\nPizza Price: $ " + this.pizzaPrice() + "\n";
	}
	
    /**
     * Calculates and returns the price of the pizza.
     * @return price of the pizza as an integer
     * @author Harsh Patel
     */
	@Override
	public int pizzaPrice() {
		if(this.size.equals("small(10”)")){
			return Price.SMALL_BUILD_YOUR_OWN + this.toppings.size() * Price.PER_TOPPING_PRICE;
		}else if(this.size.equals("medium(12”)")) {
			return Price.MEDIUM_BUILD_YOUR_OWN + this.toppings.size() * Price.PER_TOPPING_PRICE;
		}
		return Price.LARGE_BUILD_YOUR_OWN + this.toppings.size() * Price.PER_TOPPING_PRICE;
	}
}
