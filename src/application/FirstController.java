package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class addes the functionality to the 1st Stage 
 * where pizza order is taken.
 * @author Jishan Desai and Harsh Patel
 *
 */
public class FirstController implements Initializable{

	ObservableList<String> pizza_style = FXCollections.observableArrayList("Build Your Own", "Deluxe", "Hawaiian");
	ObservableList<String> pizza_size = FXCollections.observableArrayList("small(10”)", "medium(12”)", "large(14”)");
	ObservableList<String> topping_options = FXCollections.observableArrayList("Beef", "Cheese", "Chicken", "Green Pepper",
			"Ham", "Mushroom", "Onion", "Pepperoni", "Pinneapple", "Sausage");
	private Image pizza_photo;

	@FXML private Button showOrder;
	@FXML private Button addToOrder;
	@FXML private Button addToppings;
	@FXML private Button removeToppings;
	@FXML private Button clearSelection;
	@FXML private TextArea outputArea;
	@FXML private ListView<String> toppingOptions;
	@FXML private ListView<String> selectedToppings;
	@FXML private ComboBox<String> pizzaStyle;
	@FXML private ComboBox<String> pizzaSize;
	@FXML private ImageView pizzaImage;
	private int numberOfToppings =0;
	PizzaOrder pizzaOrder;
	
	/**
	 * Initialize initial settings at the beginning.
	 * @author Harsh Patel
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//showOrder.setText("Hey There");
		pizza_photo = new Image("application\\BuildYourOwn.jpg");
		pizzaStyle.setValue("Build Your Own");
		pizzaStyle.setItems(pizza_style);
		pizzaSize.setValue("medium(12”)");
		pizzaSize.setItems(pizza_size);
		pizzaImage.setImage(pizza_photo);
		toppingOptions.setItems(topping_options);
		toppingOptions.getSelectionModel().select(0);
		pizzaOrder = new PizzaOrder();
		outputArea.setEditable(false);
	}
	
	/**
	 * Adds the topping selected by user to another ListView for user to see.
	 * Also, makes sure no more than 6 toppings or already selected topping is not added.
	 * @author Jishan Desai
	 */
	public void add_toppings() {
		String selected_topping= toppingOptions.getSelectionModel().getSelectedItem();
		if(selectedToppings.getItems().contains(selected_topping)){
			outputArea.setText("You have already added that topping!\n");
		}else if(!(numberOfToppings<6)){
			outputArea.setText("Sorry, you cannot add more than six toppings!\n");
		}else {
			selectedToppings.getItems().add(selected_topping);
			numberOfToppings++;
		}
	}
	
	/**
	 * Removes the selected topping from ListView where selected toppings are stored.
	 * @author Jishan Desai
	 */
	public void remove_toppings() {
		String toppingToRemove = selectedToppings.getSelectionModel().getSelectedItem();
		if(numberOfToppings==0) {
			outputArea.setText("There are no toppings to be removed\n");
		}else if(toppingToRemove == null) {
			outputArea.setText("No topping is selected to be removed\n");
		}
		else {
			selectedToppings.getItems().remove(selectedToppings.getSelectionModel().getSelectedIndex());
			numberOfToppings--;
		}
	}
	
	/**
	 * Reset's the 1st Stage to it's default mode
	 * which is same as it was set in initialize method.
	 * @author Jishan Desai
	 */
	public void clear_button() {
		selectedToppings.getItems().clear();
		outputArea.clear();
		numberOfToppings = 0;
		pizzaStyle.setValue("Build Your Own");
		pizzaSize.setValue("medium(12”)");
		pizzaStyle.requestFocus();
		pizzaSelection();
	}
	
	/**
	 * adds predetermined toppings of Deluxe Pizza 
	 * to ListView which holds all the selected toppings
	 * @author Jishan Desai
	 */
	public void setDeluxeToppings() {
		selectedToppings.getItems().add("Sausage");
		selectedToppings.getItems().add("Pepperoni");
		selectedToppings.getItems().add("Green Pepper");
		selectedToppings.getItems().add("Onion");
		selectedToppings.getItems().add("Mushroom");

	}
	
	/**
	 * Disables add and remove Topping buttons and ListView 
	 * that provides list of available toppings from the Stage if
	 * value passed in is true. Otherwise, enables the buttons and ListView
	 * @param value value based on which enabling and disabling has to occur
	 * @author Jishan Desai
	 */
	public void enable_disable_addAndRemove_options(boolean value) {
		addToppings.setDisable(value);
		removeToppings.setDisable(value);
		toppingOptions.setDisable(value);
	}
	
	/**
	 * adds predetermined toppings of Hawaiian Pizza 
	 * to ListView which holds all the selected toppings
	 * @author Jishan Desai
	 */
	public void setHawaiianToppings() {
		selectedToppings.getItems().add("Ham");
		selectedToppings.getItems().add("Pineapple");
	}
	
	/**
	 * Converts selectedToppings ListView to an ArrayList
	 * @return arrayList where the ListView is stored
	 * @author Jishan Desai
	 */
	public ArrayList<String> ListViewToArrayList(){
		ArrayList<String> toppings = new ArrayList<String>();
		Iterator<String> listView_iterate = selectedToppings.getItems().iterator();
		while(listView_iterate.hasNext()) {
			toppings.add(listView_iterate.next().toString());
		}
		return (toppings);
	}
	
	/**
	 * Adds selected Pizza to the order
	 * @author Jishan Desai
	 */
	public void add_to_order() {

		if(selectedToppings.getItems().isEmpty()) {
			outputArea.setText("You cannot add without any toppings!\n");
			return;
		}
		Pizza pizza;
		String pizza_style = pizzaStyle.getSelectionModel().getSelectedItem();
		String pizza_size = pizzaSize.getSelectionModel().getSelectedItem();
		if(pizza_style.equals("Deluxe")) {
			pizza = new Deluxe(pizza_style,pizza_size);
		}else if(pizza_style.equals("Hawaiian")) {
			pizza = new Hawaiian(pizza_style,pizza_size);
		}else {
			ArrayList<String>order_toppings = ListViewToArrayList();
			pizza = new BuildYourOwn(pizza_style,pizza_size,order_toppings);
		}
		pizzaOrder.add(pizza);
		clear_button();
		outputArea.setText("Your pizza is successfully added to your order.");


	}
	
	/**
	 * Based on the Pizza Selection in the ComboBox, 
	 * Pizza images and related attributes are set
	 * @author Jishan Desai and Harsh Patel
	 */
	@FXML
	public void pizzaSelection() {
		// pizzaOrder = new PizzaOrder();
		if(pizzaStyle.getValue().equals("Deluxe")) {
			selectedToppings.getItems().clear();
			pizza_photo = new Image("application\\DeluxePizza.jpg");
			pizzaImage.setImage(pizza_photo);
			setDeluxeToppings();
			enable_disable_addAndRemove_options(true);
		}else if(pizzaStyle.getValue().equals("Hawaiian")) {
			selectedToppings.getItems().clear();
			pizza_photo = new Image("application\\HawaiianPizza.jpg");
			pizzaImage.setImage(pizza_photo);
			setHawaiianToppings();
			enable_disable_addAndRemove_options(true);
		}else {
			selectedToppings.getItems().clear();
			pizza_photo = new Image("application\\BuildYourOwn.jpg");
			pizzaImage.setImage(pizza_photo);
			enable_disable_addAndRemove_options(false);
			toppingOptions.setItems(topping_options);
			toppingOptions.getSelectionModel().select(0);

		}
	}
	
	/**
	 * Set's up a new Stage and passes pizza order details to second controller.
	 * @author Jishan Desai and Harsh Patel
	 */
	@FXML
	public void showOrder() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondFXML.fxml"));
			Parent root = (Parent)loader.load();
			SecondController controller2 = loader.getController();
			controller2.printOrder(pizzaOrder);
			controller2.clearOrder(this);
			Stage secondaryStage = new Stage();
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondaryStage.setTitle("Final Order Details");
			secondaryStage.setScene(scene);
			secondaryStage.setResizable(false);
			secondaryStage.initModality(Modality.APPLICATION_MODAL);
			secondaryStage.show();
			outputArea.clear();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
}



