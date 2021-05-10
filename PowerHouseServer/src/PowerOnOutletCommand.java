/**
 * enables power output for existing outlet
 * command input structure: outlets on (outlet name)
 */
public class PowerOnOutletCommand extends Command
{
    public PowerOnOutletCommand() {
        super("on");
    }

    public String helpMessage() {
        return "failed to turn off outlet";
    }

    @Override
    public String run(String cmdInput){
        //add validation
        String name = cmdInput.trim();

        //look at server outlets hashmap, find outlet with matching name, execute outlet.powerOff
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
