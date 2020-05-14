package SupplyDemand;
// begin
import java.util.ArrayList;
// end

/**
 * This class is for producers (e.g. Dole, Chiquita, etc.) to call publish() events.
 */
public class Producer implements IPublisher {

	/**
	 * This is the name of the Producer. (e.g. Dole, Chiquita, etc.)
	 */
	private String producerName;

	/**
	 * This is a "reference" to the Broker object in SupplyDemand. 
	 */
	private Broker broker;

	/**
	 * This stores the output given by a publish event.
	 */
	private ArrayList<String> publishOutput;

	/**
	 * Instantiates a new Producer object with a "reference" to the same broker in SupplyDemand and initializes the producer name.
	 */
	public Producer(String prodName, Broker broker) {
		// begin
		this.producerName = prodName;
		this.broker = broker;
		// end
	}

	/**
	 * Returns the Producer's name.
	 */
	public String getProducerName() {
		// begin
		return producerName;
		// end
		// return null;
	}

	/**
	 * Takes in the brand name and product category. First, it figures out if the product category exists. If not, then it will ask the Broker to add the product category before notifying the subscribers. If yes, then it will just notify the Broker to notify the subscribers. This returns the output string given by broker.notifySubscribers.
	 * @return
	 */
	public void publish(String brand, String prodCat) {
		// begin
		if (!broker.productCategoryExists(prodCat)) {
			broker.addProductCategory(prodCat);
		}

		this.publishOutput = broker.notifySubscribers(prodCat, brand, producerName);
		// end
		// return null;
	}

	/**
	 * Returns publish output list of strings.
	 */
	public ArrayList<String> getPublishOutput() {
		// begin
		return publishOutput;
		// end
		// return null;
	}

}
