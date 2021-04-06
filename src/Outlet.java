import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

//this class defines methods and fields for outlet components.
public class Outlet extends Component {

    protected String kwh;

    public Outlet(String ip) {
        super(ip);
    }

    @Override
    public void togglePower() throws IOException {
        //method to toggle power

        URL powerToggle = new URL("http://" + this.getIp() + "/cm?cmnd=Power%20TOGGLE");
        URLConnection conToggle = powerToggle.openConnection();
        conToggle.getInputStream();

    }

    protected String readKwhData(){

        return kwh;
    }

    public String getKwh() {
        return kwh;
    }

    public void setKwh(String kwh) {
        this.kwh = kwh;
    }

    public String getIp() {
        return ip;
    }

}
