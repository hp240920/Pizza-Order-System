package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * Adds the functionality to the 2nd Stage where order is displayed
 * @author Jishan Desai and Harsh Patel
 */
public class SecondController implements Initializable{
	 PizzaOrder order;
	 @FXML private TextArea orderArea;
	 @FXML private Button back;
	 @FXML private Button clear;

	/**
	 * stores the pizza order details from the first controller
	 * into this controller
	 * @param controller1 instance of FirstController
	 * @author Harsh Patel
	 */
    void clearOrder(FirstController controller1) {
    	order = controller1.pizzaOrder; 
	 }
    
    /**
     * prints the order details on Stage.
     * @param order order that is to be displayed to user
     * @author Jishan Desai
     */
	public void printOrder(PizzaOrder order) {
		//System.out.println(order.isEmpty());
		if(order.isEmpty()) {
			orderArea.setText("Your order is empty.\n");
			return;
		}
		orderArea.setText(order.toString());
		orderArea.appendText(">>>>>>>>>>>>>>>>>>>> Total Price: " + order.totalPrice() + " <<<<<<<<<<<<<<<<<<<<\n");
	 }
	
	/**
	 * Closes the stage when back button is pressed
	 * @author Jishan Desai 
	 */
     @FXML
	 public void pressedBack() {
		Stage stage = (Stage)back.getScene().getWindow();
		stage.close();
	 }
     
	 /**
	  * clears the order from the Stage and from the PizzaOrder object
	  * @author Jishan Desai
	  */
	 @FXML
	 public void pressedClear() {
		 orderArea.clear();
		 order.makeEmpty(); 
	 }
	
	 /**
	  * Initialize initial settings at the beginning.
	  * @author Harsh Patel
	  */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		orderArea.setWrapText(true);
		orderArea.setEditable(false);
	}	
}
