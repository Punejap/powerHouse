import java.net.URL;
import java.net.URLConnection;

/**
 * applies existing schedule to outlet
 * input command structure: schedule outlet (outlet name) (schedule number)
 */
public class OutletSchedulingCommand extends Command {
    public OutletSchedulingCommand() {
        super("outlet");
    }

    public String helpMessage() {
        return "outlet scheduling command class issue";
    }

    public String run(String cmdInput) {
        int index = cmdInput.indexOf(" ");
            String name = cmdInput.substring(0, index).trim();
            Outlet outlet = PowerHouseServer.outletMap.get(name);
            int timer = Integer.parseInt(cmdInput.substring(index + 1));

            try {
                String info = PowerHouseServer.scheduleMap.get(timer).createSettings();
                URL con = new URL("http://" + outlet.getIp() + "/cm?cmnd=Timer" + timer + info);
                URLConnection jcon = con.openConnection();
                jcon.getInputStream();
                return "schedule added to outlet";
            }
            catch (Exception e){return helpMessage();}
        }
}
