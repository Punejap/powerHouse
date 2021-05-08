

public class PowerOnOutletCommand extends Command
{
    public PowerOnOutletCommand() {
        super("on");
    }

    @Override
    public String helpMessage() {
        return "failed ";
    }

    @Override
    public String run(String cmdInput){
        //add validation
        String name = cmdInput.trim();
        //look at server outlets hashmap, find outlet with matching name

        try {
            Outlet outlet = PowerHouseServer.outletMap.get(name);
            outlet.powerOn();
        }
        catch(Exception e){
            return helpMessage();
        }
        return "i just turned on " + name;
    }
}
