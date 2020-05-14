package SupplyDemand;
// begin
import java.util.*;
// end

/**
 * This class would be the point of interaction of your system - it accepts input and provides aggregated output.
 */
public class SupplyDemand {

	/**
	 * This is a list of outputs generated by publish, subscribe, and unsubscribe events.
	 */
	private ArrayList<String> aggregatedOutput;

	/**
	 * This is only the broker that is going to be used as a communication buffer between all of the retailers and all of the producers.
	 */
	private Broker broker;

	/**
	 * This is the current list of producers.
	 */
	private ArrayList<Retailer> retailers;

	/**
	 * This is the current list of retailers.
	 */
	private ArrayList<Producer> producers;

	/**
	 * Class constructor - you may set up any needed objects and data here. Specification of constructor is optional - it is acceptable if you leave it blank.
	 */
	public SupplyDemand() {
		// begin
		producers = new ArrayList<Producer>();
		retailers = new ArrayList<Retailer>();
		broker = new Broker();
		aggregatedOutput = new ArrayList<String>();
		// end
	}

	/**
	 * This method accepts a single command and carry out the instruction given. You do not need to (and probably shouldn't) do everything in this method - delegate responsibilities to other classes.
	 * 
	 * If the command is a publish, then it will check to see if the Producer exists in the broker's list. If it exists, then it will call publish() on that producer. The return value of publish() will be added to the aggregatedOutput.
	 * 
	 * If the command is a subscribe or unsubscribe, then it will check to see if the Retailer exists in the broker's list. If it exists, then it will call subscribe() or unsubscribe() appropriately on that retailer. The return value of the chosen method will be added to the aggregatedOutput.
	 * 
	 * 
	 */
	public void processInput(String command) {
		// begin
		String commandList[] = command.split(",");
		if (commandList.length == 3 || commandList.length == 4) {
			String commandName = commandList[0];

			if (commandName.equals("publish") && commandList.length == 4) {
				String producerName = commandList[1];
				Producer currentProducer = findProducer(producerName);
				currentProducer.publish(commandList[3], commandList[2]);
				aggregatedOutput.addAll(currentProducer.getPublishOutput());
			} else if (commandName.equals("subscribe") && commandList.length == 3) {
				String retailerName = commandList[1];
				Retailer currentRetailer = findRetailer(retailerName);
				currentRetailer.subscribe(commandList[2]);
			} else if (commandName.equals("unsubscribe") && commandList.length == 3) {
				String retailerName = commandList[1];
				Retailer currentRetailer = findRetailer(retailerName);
				currentRetailer.unsubscribe(commandList[2]);
			} else {
				// Invalid command.
			}
		} else {
			// Invalid command.
		}
		//end
	}

	/**
	 * After each round of execution, this method would be called to fetch all output lines, if there are any. The lines must be ordered by the time they are received.
	 */
	public ArrayList<String> getAggregatedOutput() {
		// begin
		return aggregatedOutput;
		// end
		// return null;
	}

	/**
	 * Finally, this method would be called to clear all saved information in the system, so that information from previous round would not be carried to next round. After calling this method the system should be effectively starting anew.
	 */
	public void reset() {
		// begin
		producers.clear();
		retailers.clear();
		broker.clearSubscriptionTable();
		aggregatedOutput.clear();
		// end
	}

	/**
	 * Takes in the producer's name as a string and returns a Producer object with a matching producer name. If the producer does not exist, then a new Producer object is created and returned.
	 */
	public Producer findProducer(String producerName) {
		// begin
		if (!producers.isEmpty()) {
			for (int i = 0; i < producers.size(); i++) {
				if (producers.get(i).getProducerName().equals(producerName)) {
					return producers.get(i);

				}
			}
		}

		Producer newProducer = new Producer(producerName, broker);
		producers.add(newProducer);
		return newProducer;
		// end
		// return null;
	}

	/**
	 * Takes in the retailer's name as a string and returns a Retailer object with a matching retailer name. If the retailer does not exist, then a new Retailer object is created and returned.
	 */
	public Retailer findRetailer(String retailerName) {
		// begin
		if (!retailers.isEmpty()) {
			for (int i = 0; i < retailers.size(); i++) {
				if (retailers.get(i).getRetailerName().equals(retailerName)) {
					return retailers.get(i);
				}
			}
		}

		Retailer newRetailer = new Retailer(retailerName, broker);
		retailers.add(newRetailer);
		return newRetailer;
		// end
		// return null;
	}

}
