import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * contains methods to get today's power consumption data
 * command input structure: usage today (outlet name)
 */
public class UsageTodayCommand extends Command {

    public UsageTodayCommand() {
        super("today");
    }

    public String run(String cmdInput) throws IOException, ParseException {
        //add validation
        String name = cmdInput.trim();
        //look at server outlets hashmap, find outlet with matching name
        Outlet outlet = PowerHouseServer.outletMap.get(name);
        try {
            return String.valueOf(outlet.getDataUsage("Today") + "kWh");
        }
        catch(Exception e){
            return helpMessage();
        }
    }

    public String helpMessage() {
        return "failed to get usage";
    }
}
