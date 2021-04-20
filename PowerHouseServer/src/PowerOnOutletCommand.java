public class PowerOnOutletCommand extends Command
{
    public PowerOnOutletCommand() {
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
        Outlet outlet = PowerHouseServer.outletMap.get(name);
        try {
            outlet.powerOn();
        }
        catch(Exception e){
            return "failed to turn on";
        }
        return "i just turned on " + name;
    }
}
