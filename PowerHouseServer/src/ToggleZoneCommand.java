import java.util.HashMap;
import java.util.Map;

/**
 * contains methods to toggle existing outlets added to existing zones
 * input command structure: zone toggle (zone name)
 */
public class ToggleZoneCommand extends Command {
    public ToggleZoneCommand() {
        super("toggle");
    }

    public String helpMessage() {
        return "zone toggle command issue";
    }

    public String run(String cmdInput){
        //add validation
        String name = cmdInput.trim();
        //look at HashMap zoneMap, find zone with matching name. execute outlet.toggle for each outlet in zone
        HashMap<String, Outlet> map = PowerHouseServer.zoneMap.get(name);
        try{
           for(Map.Entry<String, Outlet> entry : map.entrySet())
               entry.getValue().togglePower();
            }
        catch(Exception e){
            return "failed to toggle";
        }
        return "i just toggled zone " + name;
    }
}
