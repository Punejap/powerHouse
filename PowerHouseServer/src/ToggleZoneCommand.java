import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ToggleZoneCommand extends Command{
    public ToggleZoneCommand() {
        super("toggle");
    }

    @Override
    public String helpMessage() {
        return "zone toggle command issue";
    }

    @Override
    public String run(String cmdInput){
        //add validation
        String name = cmdInput.trim();
        //look at server outlets hashmap, find outlet with matching name
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
