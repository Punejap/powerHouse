import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class ConfigReader {

    public void readFile() {
        try {
            File config = new File("/home/pi/phsconfig.txt");
            Scanner reader = new Scanner(config);
            while (reader.hasNextLine()) {
                String input = reader.nextLine();
                int index = input.indexOf(" ");
                int lastIndex = input.lastIndexOf(" ");

                    if (input.contains("outlet")) {
                        String name = input.substring(index+1, lastIndex).trim();
                        String ip = input.substring(lastIndex).trim();
                        Outlet outlet = new Outlet(ip);
                        PowerHouseServer.outletMap.put(name, outlet);
                    }
                    else if(input.contains("zone")){
                        String zoneName = input.substring(index+1, lastIndex).trim();
                        String outletName = input.substring(lastIndex).trim();
                        HashMap<String, Outlet> map = new HashMap<>();

                        if(!PowerHouseServer.zoneMap.containsKey(zoneName)){
                        PowerHouseServer.zoneMap.put(zoneName, map);
                        }

                        PowerHouseServer.zoneMap.get(zoneName).put(outletName,
                                PowerHouseServer.outletMap.get(outletName));
                    }
                    else if(input.contains("schedule")){
                        NewScheduleCommand s = new NewScheduleCommand();
                        String scheduleParams = input.substring(index + 1);
                        s.run(scheduleParams);
                    }
                }
        } catch (Exception e) {
            System.out.println("failed to read config");
        }
    }
}
