/**
 * powers off single, existing outlets.
 * command input structure: outlets off (outlet name)
 */
public class PowerOffOutletCommand extends Command {

    public PowerOffOutletCommand() {
        super("off");
    }


    public String helpMessage() {
        return "power off outlet command issue";
    }


    public String run(String cmdInput){
        //add validation
        String name = cmdInput.trim();
        //search HashMap outletMap for
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
