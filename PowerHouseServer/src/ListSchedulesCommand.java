import java.util.HashMap;
import java.util.Map;

/**
 * used to list all schedules and their parameters
 * input command structure: schedule list
 */
public class ListSchedulesCommand extends Command {
    public ListSchedulesCommand() {
        super("list");
    }

    public String helpMessage() {
        return "schedule list command";
    }

    public String run(String cmdInput) {
        //create new HashMap holding schedule number and parameters called from HashmapSchedule
        HashMap<Integer, String> map = new HashMap<>();
        try {
            for (Map.Entry<Integer, Schedule> entry : PowerHouseServer.scheduleMap.entrySet())
                map.put(entry.getKey(), entry.getValue().createSettings());
            return map.toString();
        }
        catch(Exception e){
            return helpMessage();
        }
    }
}
