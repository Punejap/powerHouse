import org.json.simple.parser.ParseException;

import java.io.IOException;

public class UsageTotalCommand extends Command{

    public UsageTotalCommand() {
        super("total");
    }

    @Override
    public String run(String cmdInput) throws IOException, ParseException {
        //add validation
        String name = cmdInput.trim();
        //look at server outlets hashmap, find outlet with matching name
        Outlet outlet = PowerHouseServer.outletMap.get(name);
        try {
            return outlet.getDataUsage("Total");
        }
        catch(Exception e){
            return "failed to get usage";
        }
    }

    @Override
    public String helpMessage() {
        return null;
    }
}
