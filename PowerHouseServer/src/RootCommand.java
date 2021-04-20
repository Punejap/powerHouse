public class RootCommand extends Command{

    public RootCommand(){
        super("");
        children.add(new OutletsCommand());
        children.add(new ZoneCommand());

    }

    @Override
    public String helpMessage() {
        return "root command issue";
    }
}
