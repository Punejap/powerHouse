import java.io.IOException;

//this class will contain methods to create custom schedules for however many components and however many
//parameters the user declares
public class Schedule extends Component implements CreateScene {

    protected String timeOn;
    protected String timeOff;

    public Schedule(String ip) {
        super(ip);
    }

    @Override
    public void togglePower() throws IOException {

    }

    //schedules could be considered scenes, but a scene containts mmuch more info
    @Override
    public void executeScene() {

    }
}
