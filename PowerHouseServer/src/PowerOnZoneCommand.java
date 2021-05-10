import java.util.HashMap;
import java.util.Map;

/**
 * enables power output to all existing outlets in existing zone
 * input command structure: zone off (zone name)
 */
public class PowerOnZoneCommand extends Command {

    public PowerOnZoneCommand() {
        super("on");
    }

    public String helpMessage() {
        return null;
    }

    public String run(String cmdInput){
        //add validation
        String name = cmdInput.trim();

        //look at server zones hashmap, find zone with matching name, execute outlet.powerOn for each outlet
        try{
            HashMap<String, Outlet> map = PowerHouseServer.zoneMap.get(name);
            for(Map.Entry<String, Outlet> entry : map.entrySet())
                entry.getValue().powerOn();
        }
        catch(Exception e){
            return helpMessage();
        }
        return "i just turned on zone " + name;
    }

}
