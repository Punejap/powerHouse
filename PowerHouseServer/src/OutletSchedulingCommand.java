import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class OutletSchedulingCommand extends Command{
    public OutletSchedulingCommand() {
        super("outlet");
    }

    @Override
    public String helpMessage() {
        return "outlet scheduling command class issue";
    }


    @Override
    public String run(String cmdInput) {
        int index = cmdInput.indexOf(" ");
            String name = cmdInput.substring(0, index).trim();
            Outlet outlet = PowerHouseServer.outletMap.get(name);
            int timer = Integer.parseInt(cmdInput.substring(index + 1));

            try {
                String info = PowerHouseServer.scheduleList.get(timer - 1).createSettings();
                URL con = new URL("http://" + outlet.getIp() + "/cm?cmnd=Timer" + timer + info);
                URLConnection jcon = con.openConnection();
                jcon.getInputStream();
                return "schedule added to outlet";
            }
            catch (Exception e){return helpMessage();}
        }
}
