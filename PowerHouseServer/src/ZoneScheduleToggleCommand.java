import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ZoneScheduleToggleCommand extends Command{
    public ZoneScheduleToggleCommand() {
        super("zonetoggle");
    }

    @Override
    public String helpMessage() {
        return "zone schedule toggle command issue";
    }

    @Override
    public String run(String cmdInput) {
        int index = cmdInput.indexOf(" ");
        String name = cmdInput.substring(0, index).trim();
        ArrayList<Outlet> list = PowerHouseServer.zoneMap.get(name);
        int timer = Integer.parseInt(cmdInput.substring(index + 1, index + 2));
        String toggle = cmdInput.substring(index + 3);
        System.out.println(timer + " " + toggle);

        try {
            for (Outlet outlet : list) {
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
