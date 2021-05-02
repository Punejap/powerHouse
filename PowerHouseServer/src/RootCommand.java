public class RootCommand extends Command{

    public RootCommand(){
        super("");
        children.add(new OutletsCommand());
        children.add(new ZoneCommand());
        children.add(new PowerConsumptionCommand());
        children.add(new ScheduleCommand());

    }

    @Override
    public String helpMessage() {
        return "root command issue";
    }
}
