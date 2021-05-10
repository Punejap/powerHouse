/**
 * Adds existing outlet to existing zones.
 * Finds called outlet in HashMap outletMap and copies key/val to the nested HashMap value of the called key in
 * HashMap 'zoneMap'
 *
 * command structure: "zone add (zone name) (outlet name)
 */
public class AddToZoneCommand extends Command {
    public AddToZoneCommand() {
        super("add");
    }

    public String helpMessage() {
        return "add to zone command issue";
    }

    public String run(String cmdInput){
        //parse and store zone name, outlet name from input
        String deviceInfo = cmdInput.trim();
        int index = deviceInfo.lastIndexOf(" ");
        String zoneName = deviceInfo.substring(0, index);
        String outletName = deviceInfo.substring(index+1, cmdInput.length());
            //search outletMap for inputted outlet name, copy key and value to HashMap nested in zoneMap
           if (PowerHouseServer.outletMap.containsKey(outletName)) {
                PowerHouseServer.zoneMap.get(zoneName).put(outletName, PowerHouseServer.outletMap.get(outletName));
                return outletName + " added to zone " + zoneName;
            }
           else
        {return "failed to add";}
    }
}
