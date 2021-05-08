import org.json.simple.JSONObject;

public class ListZonesCommand extends Command {

    public ListZonesCommand() {
        super("list");
    }

    @Override
    public String helpMessage() {
        return "list zone command issue";
    }

    public String run(String cmdInput) {
        return JSONObject.toJSONString(PowerHouseServer.zoneMap);
    }

    }


