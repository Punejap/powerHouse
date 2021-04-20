import java.util.ArrayList;

public class PowerOnZoneCommand extends Command{


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
        ArrayList<Outlet> arrayList = PowerHouseServer.zoneMap.get(name);
        try{
            for(int i = 0; i < arrayList.size(); i++){
                arrayList.get(i).powerOn();
            }
        }
        catch(Exception e){
            return "failed to toggle";
        }
        return "i just turned on zone " + name;
    }
}
