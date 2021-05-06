import java.util.ArrayList;
import java.util.HashMap;

public class NewZoneCommand extends Command{
    public NewZoneCommand() {
        super("new");
    }

    @Override
    public String helpMessage() {
        return "new zone issue";
    }

    @Override
    public String run(String cmdInput){
        String name= cmdInput.trim();
        HashMap<String, Outlet> map = new HashMap<>();
        PowerHouseServer.zoneMap.put(name,map);
        return "zone " + name + " created";
    }

}
