import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * used to return total power consumption for outlet
 * input command structure: usage total (outlet name)
 */
public class UsageTotalCommand extends Command {

    public UsageTotalCommand() {
        super("total");
    }

    public String run(String cmdInput) throws IOException, ParseException {
        //add validation
        String name = cmdInput.trim();
        //look at server outlets hashmap, find outlet with matching name
        Outlet outlet = PowerHouseServer.outletMap.get(name);
        try {
            return outlet.getDataUsage("Total") + "kWh";
        }
        catch(Exception e){
            return helpMessage();
        }
    }
    public String helpMessage() {
        return "failed to get usage";
    }
}
