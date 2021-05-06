import org.json.simple.JSONObject;

public class ScheduleListCommand extends Command{
    public ScheduleListCommand() {
        super("list");
    }

    @Override
    public String helpMessage() {
        return "schedule list command issue";
    }

    public String run(String cmdInput) {
        JSONObject obj = new JSONObject();
        for (int i = 0; i < PowerHouseServer.scheduleList.size(); i++) {
            obj.put("Timer" + i+1 , PowerHouseServer.scheduleList.get(i).createSettings());
        }
        return JSONObject.toJSONString(obj);
    }
}
