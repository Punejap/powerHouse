import java.net.URL;
import java.net.URLConnection;

/**
 * enables or disables existing schedules in single outlets
 * input command structure: schedule toggle (outlet name) (schedule number) (0 to disable OR 1 to enable)
 */
public class OutletScheduleToggleCommand extends Command {
    public OutletScheduleToggleCommand() {
        super("toggle");
    }

    public String helpMessage() {
        return "outlet schedule toggle command issue";
    }

    //parse input to get outlet name, schedule number, desired command
    public String run(String cmdInput) {
        try {
        int index = cmdInput.indexOf(" ");
        String name = cmdInput.substring(0, index).trim();
        Outlet outlet = PowerHouseServer.outletMap.get(name);
        //specific parsing - input must be exact
        int timer = Integer.parseInt(cmdInput.substring(index + 1, index + 2));
        String toggle = cmdInput.substring(index + 3);

        //send commands via http request to outlet
        URL con = new URL("http://" + outlet.getIp() + "/cm?cmnd=Timer" + timer + "{\"Enable\":" + toggle + "}");
        URLConnection jcon = con.openConnection();
        jcon.getInputStream();
        return "the schedule has been toggled";
        }
        catch (Exception e){return helpMessage();}
    }
}
