import java.util.ArrayList;

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
        ArrayList<Outlet> arrayList = PowerHouseServer.zoneMap.get(name);
        try{
            for(int i = 0; i < arrayList.size(); i++){
                arrayList.get(i).powerOff();
            }
        }
        catch(Exception e){
            return "failed to toggle";
        }
        return "i just turned off zone " + name;
    }
}
