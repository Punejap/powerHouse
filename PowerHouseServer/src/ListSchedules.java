import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ListSchedules extends Command{
    public ListSchedules() {
        super("list");
    }

    @Override
    public String helpMessage() {
        return "schedule list command issue";
    }


    public String run(String cmdInput) {
        HashMap<Integer, String> map = new HashMap<>();
        try {
            for (Map.Entry<Integer, Schedule> entry : PowerHouseServer.scheduleMap.entrySet())
                map.put(entry.getKey(), entry.getValue().createSettings());

            return map.toString();
        }
        catch(Exception e){
            return "failed to list";
        }


    }
}
