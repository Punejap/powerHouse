public class RootCommand extends Command{

    public RootCommand(){
        super("");
        children.add(new OutletsCommand());

    }

    @Override
    public String helpMessage() {
        return "root command issue";
    }
}
