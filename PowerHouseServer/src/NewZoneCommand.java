import java.util.HashMap;


/**
 * creates zones(groups of components). does not add any components to zone
 * command structure: zone new (zone name)
 */
public class NewZoneCommand extends Command {
    public NewZoneCommand() {
        super("new");
    }


    public String helpMessage() {
        return "new zone issue";
    }

    @Override
    public String run(String cmdInput){
        try {
            String name= cmdInput.trim();
            HashMap<String, Outlet> map = new HashMap<>();
            PowerHouseServer.zoneMap.put(name, map);
            return "zone " + name + " created";
        }
        catch (Exception e){return helpMessage();}
    }

}
