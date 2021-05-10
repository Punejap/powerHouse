import org.json.simple.JSONObject;

/**
 * returns all keys, values of HashMap zoneMap in JSON format
 * input command structure: zone list
 */
public class ListZonesCommand extends Command {

    public ListZonesCommand() {
        super("list");
    }

    public String helpMessage() {
        return "list zone command issue";
    }//currently never called

    public String run(String cmdInput) {
        return JSONObject.toJSONString(PowerHouseServer.zoneMap);
    }
}


