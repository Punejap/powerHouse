/**
 * adds power consumption commands to Array List children. used to delineate discrete inputs which use same string
 * command structure: usage (rest of command)
 */
public class PowerConsumptionCommand extends Command {
    public PowerConsumptionCommand() {
        super("usage");
        children.add(new UsageTodayCommand());
        children.add(new UsageTotalCommand());
        children.add(new UsageAverageCommand());
    }

    @Override
    public String helpMessage() {
        return "power consumption error";
    }




}
