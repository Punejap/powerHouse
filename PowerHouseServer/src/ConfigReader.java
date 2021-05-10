import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * contains methods to read existing configurations in existing configuration file.
 * executes relevant methods to store objects
 */
public class ConfigReader {

    public void readFile() throws FileNotFoundException {

        //find txt file, parse the text
        File config = new File("/home/pi/phsconfig.txt");
        Scanner reader = new Scanner(config);
        while (reader.hasNextLine()) {
            String input = reader.nextLine();
            int index = input.indexOf(" ");
            int lastIndex = input.lastIndexOf(" ");
            //look for matching strings, parse relevant information and store it
            if (input.contains("outlet")) {
                String name = input.substring(index + 1, lastIndex).trim();
                String ip = input.substring(lastIndex).trim();
                Outlet outlet = new Outlet(ip);
                PowerHouseServer.outletMap.put(name, outlet);
            } else if (input.contains("zone")) {
                String zoneName = input.substring(index + 1, lastIndex).trim();
                String outletName = input.substring(lastIndex).trim();
                HashMap<String, Outlet> map = new HashMap<>();

                if (!PowerHouseServer.zoneMap.containsKey(zoneName)) {//avoids overwrites
                    PowerHouseServer.zoneMap.put(zoneName, map);
                }

                PowerHouseServer.zoneMap.get(zoneName).put(outletName,
                        PowerHouseServer.outletMap.get(outletName));
            } else if (input.contains("schedule")) {
                NewScheduleCommand s = new NewScheduleCommand();
                String scheduleParams = input.substring(index + 1);
                s.run(scheduleParams);
            }
        }
    }
}

