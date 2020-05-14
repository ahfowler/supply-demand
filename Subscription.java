package SupplyDemand;
// begin
import java.util.ArrayList;
// end

/**
 * This object represents a product category subscription. It has a list of it's current subscribers, and the ability to to check if a retailer is a current subscriber.
 */
public class Subscription {

	/**
	 * This is the name of the product category.
	 */
	private String productCategory;

	/**
	 * This is the current list of subscribers to this product category.
	 */
	private ArrayList<String> subscribers;

	/**
	 * Instantiates a new Subscription object with a product category name.
	 */
	public Subscription(String productCategory) {
		// begin
		this.productCategory = productCategory;
		this.subscribers = new ArrayList<String>();
		// end
	}

	/**
	 * Returns the product category.
	 */
	public String getProductCategory() {
		// begin
		return productCategory;
		// end
		// return null;
	}

	/**
	 * Returns the subscribers.
	 */
	public ArrayList<String> getSubscribers() {
		// begin
		return subscribers;
		// end
		// return null;
	}

	/**
	 * Takes in a retailer name and returns true is the retailer is a current subscriber to the product category; false otherwise.
	 */
	public boolean isSubscriber(String retailerName) {
		// begin
		return subscribers.contains(retailerName);
		// end
		// return false;
	}

}
