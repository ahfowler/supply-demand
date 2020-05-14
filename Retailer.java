package SupplyDemand;

/**
 * This class is for retailers (e.g. Target, Walmart, etc.) to call subscribe() and unsubscribe() events.
 */
public class Retailer implements ISubscriber {

	/**
	 * This is the name of the Retailer. (e.g. Target, Walmart, etc.)
	 */
	private String retailerName;

	/**
	 * This is a "reference" to the Broker object in SupplyDemand.
	 */
	private Broker broker;

	/**
	 * Instantiates a new Retailer object with a "reference" to the same broker in SupplyDemand and initializes the retailer name.
	 */
	public Retailer(String retName, Broker broker) {
		// begin
		this.retailerName = retName;
		this.broker = broker;
		// end
	}

	/**
	 * Returns the Retailer's name.
	 */
	public String getRetailerName() {
		// begin
		return retailerName;
		// end
		// return null;
	}

	/**
	 * Takes in the product category. First, it figures out if the product category exists. If not, then it will ask the Broker to add the product category before adding a new subscriber. If yes, then it will just ask the Broker to add a new subscriber. This returns the output string given by broker.addSubscriber().
	 */
	public void subscribe(String prodCat) {
		// begin
		if (!broker.productCategoryExists(prodCat)) {
			broker.addProductCategory(prodCat);
		}

		broker.addSubscriber(prodCat,retailerName);
		// end
	}

	/**
	 * Takes in the product category. First, it figures out if the product category exists. If not, then it will ask the Broker to add the product category before removing a subscriber. If yes, then it will just ask the Broker to remove a subscriber. This returns the output string given by broker.removeSubscriber().
	 */
	public void unsubscribe(String prodCat) {
		// begin
		if (!broker.productCategoryExists(prodCat)) {
			broker.addProductCategory(prodCat);
		}

		broker.removeSubscriber(prodCat,retailerName);
		// end
	}

}
