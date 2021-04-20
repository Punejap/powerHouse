import java.util.ArrayList;

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
        ArrayList<Outlet> arrayList = PowerHouseServer.zoneMap.get(name);
        try{
            for(int i = 0; i < arrayList.size(); i++){
                arrayList.get(i).togglePower();
            }
        }
        catch(Exception e){
            return "failed to toggle";
        }
        return "i just toggled zone " + name;
    }
}
