import java.util.HashMap;
import java.util.Map;

public class PowerOnZoneCommand extends Command {


    public PowerOnZoneCommand() {
        super("on");
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
                entry.getValue().powerOn();
        }
        catch(Exception e){
            return helpMessage();
        }
        return "i just turned on zone " + name;
    }

}
