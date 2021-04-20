import java.util.ArrayList;

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
        ArrayList<Outlet> arraylist = new ArrayList<>();
        PowerHouseServer.zoneMap.put(name, arraylist);
        return "zone " + name + " created";
    }

}
