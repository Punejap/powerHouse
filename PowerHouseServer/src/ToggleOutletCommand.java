import java.io.IOException;

public class ToggleOutletCommand extends Command{

    public ToggleOutletCommand() {
        super("toggle");
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
        Outlet outlet = PowerHouseServer.outletMap.get(name);
        try {
            outlet.togglePower();
        }
        catch(Exception e){
            return "failed to toggle";
        }
        return "i just toggled outlet " + name;
    }
}
