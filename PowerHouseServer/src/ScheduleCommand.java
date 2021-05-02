public class ScheduleCommand extends Command{
    public ScheduleCommand() {
        super("schedule");
        children.add(new CreateScheduleCommand());
        children.add(new OutletSchedulingCommand());
       children.add(new OutletScheduleToggleCommand());
       children.add(new ZoneSchedulingCommand());
       children.add(new ZoneScheduleToggleCommand());
    }

    @Override
    public String helpMessage() {
        return "schedule command class issue";
    }
}
