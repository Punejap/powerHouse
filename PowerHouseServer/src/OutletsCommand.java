/**
 * adds outlet commands to Array List children. used to delineate discrete inputs which use same string
 * command structure: outlets (rest of command)
 */
public class OutletsCommand extends Command {
    public OutletsCommand() {
        super("outlets");
        children.add(new ToggleOutletCommand());
        children.add(new PowerOnOutletCommand());
        children.add(new PowerOffOutletCommand());
        children.add(new NewOutletCommand());
        children.add(new ListOutletsCommand());
    }

    @Override
    public String helpMessage() {
        return "outlets command issue";
    }
}
