import java.util.ArrayList;

public class AddToZoneCommand extends Command{
    public AddToZoneCommand() {
        super("add");
    }

    @Override
    public String helpMessage() {
        return "add to zone command issue";
    }

    @Override
    public String run(String cmdInput){
        String deviceInfo = cmdInput.trim();
        int index = deviceInfo.lastIndexOf(" ");
        String zoneName = deviceInfo.substring(0, index);
        String outletName = deviceInfo.substring(index+1, cmdInput.length());

           if (PowerHouseServer.outletMap.containsKey(outletName)) {
                PowerHouseServer.zoneMap.get(zoneName).put(outletName, PowerHouseServer.outletMap.get(outletName));
                return outletName + " added to zone " + zoneName;
            }
           else
        {return "failed to add to zone";}
    }
}
