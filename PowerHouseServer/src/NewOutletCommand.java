/**
 * used to create outlet objects representing physical devices and store them in HashMap outletMap
 * input command structure: outlets new (outlet name) (local ip address)
 */
public class NewOutletCommand extends Command {
    public NewOutletCommand(){
        super("new");
    }

    public String helpMessage() {
        return "new outlet class issue";
    }

    //parse name and ip address. store them as key/val in outletMap
    public String run(String cmdInput){
        try {
            String deviceInfo = cmdInput.trim();
            int index = deviceInfo.lastIndexOf(" ");
            String name = deviceInfo.substring(0, index);
            String ip = deviceInfo.substring(index + 1, cmdInput.length());
            Outlet outlet = new Outlet(ip);
            PowerHouseServer.outletMap.put(name, outlet);
            return "outlet " + name + " created";
        }
        catch (Exception e){return helpMessage();}
    }


}
