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

    protected double kWhToday;//our working outlets do provide useage data which can be used to set scenes
    protected double kwhLimit;

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

    public void powerOff() throws IOException{
        URL powerToggle = new URL("http://" + this.getIp() + "/cm?cmnd=Power%20off");
        URLConnection conToggle = powerToggle.openConnection();
        conToggle.getInputStream();
    }

    public void powerOn() throws IOException{
        URL powerToggle = new URL("http://" + this.getIp() + "/cm?cmnd=Power%20ON");
        URLConnection conToggle = powerToggle.openConnection();
        conToggle.getInputStream();
    }

    public void savePower() throws IOException {
        if(kWhToday > kwhLimit) {
            this.powerOff();
            System.out.println("you done used too much power");
        }
    }

    public double getkWhToday() throws IOException, ParseException {
        URL usageData = new URL("http://" + this.getIp() + "/cm?cmnd=Status%208");

        URLConnection conUsageData = usageData.openConnection();
        String jsonstring = new Scanner(conUsageData.getInputStream()).next();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonstring);

        JSONObject data = (JSONObject) json.get("StatusSNS");
        data = (JSONObject) data.get("ENERGY");

        kWhToday = (double) data.get("Today");
        return kWhToday;
    }

    public void setkWhToday(double kWhToday) {
        this.kWhToday = kWhToday;
    }

    public double getKwhLimit() {
        return kwhLimit;
    }

    public void setKwhLimit(double kwhLimit) {
        this.kwhLimit = kwhLimit;
    }

    public String getIp() {
        return ip;
    }

}
