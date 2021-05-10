/**
 * adds top schedule related command classes to array list
 * input command structure: schedule (rest of command)
 */
public class ScheduleCommand extends Command {
    public ScheduleCommand() {
        super("schedule");
        children.add(new NewScheduleCommand());
        children.add(new OutletSchedulingCommand());
       children.add(new OutletScheduleToggleCommand());
       children.add(new ZoneSchedulingCommand());
       children.add(new ZoneScheduleToggleCommand());
       children.add(new ListSchedulesCommand());
    }

    @Override
    public String helpMessage() {
        return "schedule command class issue";
    }
}
