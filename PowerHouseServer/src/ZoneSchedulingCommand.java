import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ZoneSchedulingCommand extends Command{
    public ZoneSchedulingCommand() {
        super("zone");
    }

    @Override
    public String helpMessage() {
        return "zone scheduling command issue";}

    @Override
    public String run(String cmdInput) {
        int index = cmdInput.indexOf(" ");
        String name = cmdInput.substring(0, index).trim();
        HashMap<String, Outlet> map = PowerHouseServer.zoneMap.get(name);
        int timer = Integer.parseInt(cmdInput.substring(index + 1));

        try {
            String info = PowerHouseServer.scheduleList.get(timer - 1).createSettings();

                for(Map.Entry<String, Outlet> entry : map.entrySet()){
               Outlet outlet = entry.getValue();

                URL con = new URL("http://" + outlet.getIp() + "/cm?cmnd=Timer" + timer + info);
                URLConnection jcon = con.openConnection();
                jcon.getInputStream();
            }
            return "schedule added to zone";
        }
        catch (Exception e){return "failed";}
    }
}
