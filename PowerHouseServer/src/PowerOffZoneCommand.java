import java.util.HashMap;
import java.util.Map;

/**
 * powers off all existing outlets already added to existing zones
 * input command structure: zone off (zone name)
 */
public class PowerOffZoneCommand extends Command {
    public PowerOffZoneCommand() {
        super("off");
    }


    public String helpMessage() {
        return "power off zone command issue";
    }

    public String run(String cmdInput){
        //add validation
        String name = cmdInput.trim();

        //look at HashMap zoneMap, find zone with matching name. execute outlet.powerOff for each outlet in zone
        try{
            HashMap<String, Outlet> map = PowerHouseServer.zoneMap.get(name);
            for(Map.Entry<String, Outlet> entry : map.entrySet())
                entry.getValue().powerOff();
        }
        catch(Exception e){
            return helpMessage();
        }
        return "i just turned off zone " + name;
    }
}
