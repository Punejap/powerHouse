import java.net.URL;
import java.net.URLConnection;

public class OutletScheduleToggleCommand extends Command{
    public OutletScheduleToggleCommand() {
        super("toggle");
    }

    @Override
    public String helpMessage() {
        return "outlet schedule able command issue";
    }

    @Override
    public String run(String cmdInput) {
        int index = cmdInput.indexOf(" ");
        String name = cmdInput.substring(0, index).trim();
        Outlet outlet = PowerHouseServer.outletMap.get(name);
        int timer = Integer.parseInt(cmdInput.substring(index + 1, index + 2));
        String toggle = cmdInput.substring(index + 3);

        try {
            URL con = new URL("http://" + outlet.getIp() + "/cm?cmnd=Timer" + timer + "{\"Enable\":" + toggle + "}");
            URLConnection jcon = con.openConnection();
            jcon.getInputStream();
            return "the schedule has been toggled";
        }
        catch (Exception e){return "failed";}

    }
}
