import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * contains methods to get average daily power consumption for existing outlet
 * input command structure: usage avg (outlet name)
 */
public class UsageAverageCommand extends Command {

    public UsageAverageCommand() {
        super("avg");
    }

    @Override
    public String run(String cmdInput) throws IOException, ParseException {
        //add validation
        String name = cmdInput.trim();
        //look at server outlets hashmap, find outlet with matching name
        Outlet outlet = PowerHouseServer.outletMap.get(name);
        try {
            double totalkwh = Double.parseDouble(outlet.getDataUsage("Total"));
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime startTime = LocalDateTime.parse(outlet.getDataUsage("TotalStartTime"));
            Duration runTime = Duration.between(startTime, now);
            return ("Average of " + String.format("%.2f",(totalkwh/(runTime.toHours()/24))) + "kWh a day");
        }
        catch(Exception e){
            return helpMessage();
        }
    }

    public String helpMessage() {
        return "failed to get usage";
    }
}
