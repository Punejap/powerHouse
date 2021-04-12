import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

//this class defines methods and fields for outlet components.
public class Outlet extends Component {

    protected String kwh;//our working outlets do provide useage data which can be used to set scenes

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

    public String getkWhToday() throws IOException, ParseException {
        URL usageData = new URL("http://" + this.getIp() + "/cm?cmnd=Status%208");

        URLConnection conUsageData = usageData.openConnection();
        String jsonstring = new Scanner(conUsageData.getInputStream()).next();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonstring);

        JSONObject data = (JSONObject) json.get("StatusSNS");
        data = (JSONObject) data.get("ENERGY");

        return (data.get("Today").toString() + "kWh");
    }

    public void setKwh(String kwh) {
        this.kwh = kwh;
    }

    public String getIp() {
        return ip;
    }

}
