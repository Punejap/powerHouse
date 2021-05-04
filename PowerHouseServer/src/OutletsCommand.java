public class OutletsCommand extends Command{
    public OutletsCommand() {
        super("outlets");
        children.add(new ToggleOutletCommand());
        children.add(new PowerOnOutletCommand());
        children.add(new PowerOffOutletCommand());
        children.add(new NewOutletCommand());
        children.add(new ListOutletCommand());
    }

    @Override
    public String helpMessage() {
        return "outlet classs issue";
    }
}
