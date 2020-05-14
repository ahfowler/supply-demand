package SupplyDemand;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class PersonalTestCases {

    private static SupplyDemand sd;

    // Create SupplyDemand object to test with
    @BeforeClass
    public static void setupSupplyDemand() {
        sd = new SupplyDemand();
    }

    @Test
    public void publishEvent() {
        sd.processInput("subscribe, Target, banana");
        sd.processInput("publish, Dole, banana, Dole");
        ArrayList<String> output = sd.getAggregatedOutput();

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }
}

