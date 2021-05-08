import java.util.HashMap;
import java.util.Map;

public class PowerOffZoneCommand extends Command {
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
