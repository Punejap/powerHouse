public class PowerOffOutletCommand extends Command{

    public PowerOffOutletCommand() {
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
        Outlet outlet = PowerHouseServer.outletMap.get(name);
        try {
            outlet.powerOff();
        }
        catch(Exception e){
            return "failed to turn off";
        }
        return "i just turned off " + name;
    }
}
