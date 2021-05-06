import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PowerOffZoneCommand extends Command{
    public PowerOffZoneCommand() {
        super("off");
    }

    @Override
    public String helpMessage() {
        return null;
    }

    @Override
    public String run(String cmdInput){
        //add validation
        String name = cmdInput.trim();
        //look at server outlets hashmap, find outlet with matching name
        HashMap<String, Outlet> map = PowerHouseServer.zoneMap.get(name);
        try{
            for(Map.Entry<String, Outlet> entry : map.entrySet())
                entry.getValue().powerOff();
        }
        catch(Exception e){
            return "failed to power off";
        }
        return "i just turned off zone " + name;
    }
}
