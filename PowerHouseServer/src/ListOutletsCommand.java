import org.json.simple.JSONObject;

/**
 * used to return a list of all outlet names and their ip addresses in JSON format
 * input command structureL outlets list
 */
public class ListOutletsCommand extends Command {
    public ListOutletsCommand() {
        super("list");
    }

    public String helpMessage() {
        return "outlets list class issue";
    }

    public String run(String cmdInput){
        return JSONObject.toJSONString(PowerHouseServer.outletMap);
    }
}
