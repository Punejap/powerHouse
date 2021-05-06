import org.json.simple.JSONObject;

public class ListOutletCommand extends Command{
    public ListOutletCommand() {
        super("list");
    }

    @Override
    public String helpMessage() {
        return "start command class issue";
    }

    @Override
    public String run(String cmdInput){
        return JSONObject.toJSONString(PowerHouseServer.outletMap);

    }
}
