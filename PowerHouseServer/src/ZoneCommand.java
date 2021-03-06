/**
 * adds command classes relevant to zone control to array list
 * input command structure: zone (rest of command)
 */
public class ZoneCommand extends Command {

    public ZoneCommand() {
        super("zone");
        children.add(new ToggleZoneCommand());
        children.add(new PowerOnZoneCommand());
        children.add(new PowerOffZoneCommand());
        children.add(new NewZoneCommand());
        children.add(new AddToZoneCommand());
        children.add(new ListZonesCommand());
        //children.add(new Status);
    }

    @Override
    public String helpMessage() {
        return "zone command issue";
    }
}
