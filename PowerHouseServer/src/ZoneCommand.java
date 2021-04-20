public class ZoneCommand extends Command{

    public ZoneCommand() {
        super("zone");
        children.add(new ToggleZoneCommand());
        children.add(new PowerOnZoneCommand());
        children.add(new PowerOffZoneCommand());
        children.add(new NewZoneCommand());
        children.add(new AddToZoneCommand());
        //children.add(new MonitoringDataCommand);
        //children.add(new Status);
    }

    @Override
    public String helpMessage() {
        return "zone command issue";
    }
}
