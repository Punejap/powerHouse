import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * enables or disables applied schedule to zone
 * input command structure:schedule zone toggle (zone name) (schedule number)
 */
public class ZoneScheduleToggleCommand extends Command {
    public ZoneScheduleToggleCommand() {
        super("toggle");
    }

    public String helpMessage() {
        return "zone schedule toggle command issue";
    }

    //parse zone name, get info from hashmap, execute outlet.toggle(); for each outlet in zone
    public String run(String cmdInput) {
        int index = cmdInput.indexOf(" ");
        String name = cmdInput.substring(0, index).trim();
        HashMap<String, Outlet> map = PowerHouseServer.zoneMap.get(name);
        int timer = Integer.parseInt(cmdInput.substring(index + 1, index + 2));
        String toggle = cmdInput.substring(index + 3);
        System.out.println(timer + " " + toggle);

        try {
            for (Map.Entry<String, Outlet> entry : map.entrySet()) {
                Outlet outlet = entry.getValue();
                URL con = new URL("http://" + outlet.getIp() + "/cm?cmnd=Timer" + timer
                        + "{\"Enable\":" + toggle + "}");
                URLConnection jcon = con.openConnection();
                jcon.getInputStream();
            }
            return "schedule has been toggled";
        }
        catch (Exception e){return "failed";}
    }
}
