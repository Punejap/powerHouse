import java.io.IOException;

//a zone groups a set of components together - living room, dining room, etc...
public class Zone extends Component{
    public Zone(String ip) {
        super(ip);
    }

    @Override
    public void togglePower() throws IOException {

    }
}
