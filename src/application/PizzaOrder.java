package application;
/**
 * Creates a PizzaOrder object and updates 
 * it as required
 * @author Harsh Patel and Jishan Desai
 */
public class PizzaOrder {
	
	private final int START_OR_GROW_SIZE = 4; //initial and grow size
	private Pizza [] list;
	private int numPizza;
	
   /**
    * creates an order. 
    * @author Harsh Patel
    */
	public PizzaOrder()
	{
		//this is the default constructor
		this.list = new Pizza[START_OR_GROW_SIZE];
		this.numPizza = 0;
	}
	
    /**
     * increases the size of the List where
     * pizza are stored
     * @author Harsh Patel
     */
	private void grow()
	{
		int newSize = this.numPizza + START_OR_GROW_SIZE;
		Pizza[] newlistArray = new Pizza[newSize];
		for(int i = 0; i < this.numPizza; i++) {
			newlistArray[i] = this.list[i];
		}
		this.list = newlistArray;
	}
	
    /**
     * returns true if list is empty otherwise false.
     * @return true if the list where pizza are stored is empty
     * otherwise false.
     *  @author Harsh Patel
     */
	public boolean isEmpty()
	{
		if(this.list[0] == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * empties the list of pizza and returns true
	 * @return true if the List was emptied successfully
	 *  @author Harsh Patel
	 */
	public boolean makeEmpty() {
		//this.list = null;
		this.list = new Pizza[START_OR_GROW_SIZE];
		this.numPizza = 0;
		return true;
	}
	
    /**
     * Adds the given pizza into the list
     * @param m Pizza to add to the order
     *  @author Harsh Patel
     */
	public void add(Pizza m)
	{    
		if(this.numPizza == list.length) {
			grow();
			list[this.numPizza] = m;
			this.numPizza++;
		}else {
			list[this.numPizza] = m;
			this.numPizza++;
			//System.out.println(numPizza);
		}
	}
	
    /**
     * Prints the order to the console
     * @author Harsh Patel
     */
	public void print()
	{
		
		//set up a for loop and call the toString() method
		for(int i = 0; i < this.numPizza; i++) {
			System.out.println(this.list[i].toString());
		}
	}
	
	/**
	 * string representation of PizzaOrder object
	 * @return  string form of this object
	 * @author Harsh Patel 
	 */
	public String toString() {
		
		String str = "";
		for(int i = 0; i < this.numPizza; i++) {
			str += "#"+(i+1)+". "+ this.list[i].toString() + "\n";
			
		}
		return str;
	}
	
	/**
	 * calculates the price of the order.
	 * @return  the price as a String
	 * @author Harsh Patel 
	 */
	public String totalPrice() {
		
		int price = 0;
		for(int i = 0; i < this.numPizza; i++) {
			price += this.list[i].pizzaPrice();
		}
		return "$" + price ;
   }
	
}
