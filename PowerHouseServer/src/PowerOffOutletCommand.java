

public class PowerOffOutletCommand extends Command {

    public PowerOffOutletCommand() {
        super("off");
    }

    @Override
    public String helpMessage() {
        return "power off outlet command class issue";
    }

    @Override
    public String run(String cmdInput){
        //add validation
        String name = cmdInput.trim();
        //look at server outlets hashmap, find outlet with matching name
        Outlet outlet = PowerHouseServer.outletMap.get(name);
        try {
            outlet.powerOff();
        }
        catch(Exception e){
            return helpMessage();
        }
        return "i just turned off " + name;
    }
}
