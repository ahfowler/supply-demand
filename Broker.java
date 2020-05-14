package SupplyDemand;
// begin
import java.util.ArrayList;
// end

/**
 * This is unique broker that serves as a communication buffer between all retailers and all producers. It has the ability to notify subscribers and modify the subscription table as needed.
 */
public class Broker {

	/**
	 * A list of subscriptions with current subscribers.
	 */
	private ArrayList<Subscription> subscriptionTable;

	public Broker() {
		// begin
		subscriptionTable = new ArrayList<Subscription>();
		// end
	}

	/**
	 * If a Retailer or Producer sends a request involving a product category that does not exist, it will create a new Subscription object with the product category name and put it in the subscription table.
	 */
	public void addProductCategory(String productCategory) {
		// begin
		Subscription newSubscription = new Subscription(productCategory);
		subscriptionTable.add(newSubscription);
		// end
	}

	/**
	 * This method takes in a product category name and finds the subscription object category name in the subscription table. Then it creates and returns the output strings with the subscribers associated with the subscription object.
	 */
	public ArrayList<String> notifySubscribers(String productCategory, String brand, String producerName) {
		// begin
		Subscription currentSubscription = null;
		for (int i = 0; i < subscriptionTable.size(); i++) {
			if (subscriptionTable.get(i).getProductCategory().equals(productCategory)) {
				currentSubscription = subscriptionTable.get(i);
				break;
			}
		}

		ArrayList<String> subscribers = currentSubscription.getSubscribers();
		ArrayList<String> output = new ArrayList<String>();
		for (int j = 0; j < subscribers.size(); j++) {
			String currentOutput = subscribers.get(j) + " notified of " + brand + " brand " + productCategory + " from " + producerName;
			currentOutput = currentOutput.replaceAll("\\s+", " ");
			output.add(currentOutput);
		}

		return output;
		// end
		// return null;
	}

	/**
	 * This method takes in a product category and the name of the retailer name that wants to unsubscribe. First, it finds if the product category exists. If it doesn't, then it will add a new product category beforehand. If it does, then it will have access to the Subscription object with the product category. With this object, it will check if the retailer is a current subscriber. If it isn't, then we will just return the output string. If it is, then it will remove it from the subscribers list and then return the output string.
	 */
	public void removeSubscriber(String productCategory, String retailerName) {
		// begin
		Subscription currentSubscription = null;
		for (int i = 0; i < subscriptionTable.size(); i++) {
			if (subscriptionTable.get(i).getProductCategory().equals(productCategory)) {
				currentSubscription = subscriptionTable.get(i);
				break;
			}
		}

		if (currentSubscription.isSubscriber(retailerName)) {
			currentSubscription.getSubscribers().remove(retailerName);
		}
		// end
	}

	/**
	 * This method takes in a product category and the name of the retailer name that wants to subscribe. First, it finds if the product category exists. If it doesn't, then it will add a new product category beforehand. If it does, then it will have access to the Subscription object with the product category. With this object, it will check if the retailer is a current subscriber. If it is, then we will just return the output string. If it isn't, then it will add it to the subscribers list and then return the output string.
	 */
	public void addSubscriber(String productCategory, String retailerName) {
		// begin
		Subscription currentSubscription = null;
		for (int i = 0; i < subscriptionTable.size(); i++) {
			if (subscriptionTable.get(i).getProductCategory().equals(productCategory)) {
				currentSubscription = subscriptionTable.get(i);
				break;
			}
		}

		if (!currentSubscription.isSubscriber(retailerName)) {
			currentSubscription.getSubscribers().add(retailerName);
		}
		// end
	}

	/**
	 * Iterates though subscription table to see if product category exists. Returns true if yes, else, returns false.
	 */
	public boolean productCategoryExists(String productCategory) {
		// begin
		for (int i = 0; i < subscriptionTable.size(); i++) {
			if (subscriptionTable.get(i).getProductCategory().equals(productCategory)) {
				return true;
			}
		}
		return false;
		// end
	}

	/**
	 * Clears the subscription table.
	 */
	public void clearSubscriptionTable() {
		// begin
		subscriptionTable.clear();
		// end
	}
}
