package SupplyDemand;

/**
 * An interface for Publishers, who publish new contents to Subscribers via a Broker.
 */
public interface IPublisher {

	/**
	 * Publish a message about products available.
	 * @return
	 */
	public abstract void publish(String brand, String prodCat);

}
