import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.Duration;


/**
 * represents physical IoT outlets. Contains method for power toggling and monitoring.
 */
public class Outlet extends Component {

    protected double kWhToday;
    protected double kwhLimit;

    /**
     * @param ip local ip address of component
     */
    public Outlet(String ip) {
        super(ip);
    }

    //sends http request to toggle outlet power output
    public void togglePower() throws IOException {
        URL con = new URL("http://" + this.getIp() + "/cm?cmnd=Power%20TOGGLE");
        URLConnection conToggle = con.openConnection();
        conToggle.getInputStream();
    }

    //sends http request to enable outlet power output
    public void powerOn() throws IOException{
        URL con = new URL("http://" + this.getIp() + "/cm?cmnd=Power%20On");
        URLConnection conToggle = con.openConnection();
        conToggle.getInputStream();
    }

    //sends http request to disable outlet power output
    public void powerOff() throws IOException{
        URL con = new URL("http://" + this.getIp() + "/cm?cmnd=Power%20off");
        URLConnection conToggle = con.openConnection();
        conToggle.getInputStream();
    }

    //used to terminate outlet power output when conditional usage limit is exceeded
    public void savePower() throws IOException {
        if(kWhToday > kwhLimit) {
            this.powerOff();
            System.out.println("you done used too much power");
        }
    }

    //send http request to return status information from outlet in JSON format, parse and return relevant information
    public String getDataUsage(String key) throws IOException, ParseException {
        URL usageData = new URL("http://" + this.getIp() + "/cm?cmnd=Status%208");

        URLConnection conUsageData = usageData.openConnection();
        String jsonstring = new Scanner(conUsageData.getInputStream()).next();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonstring);

        JSONObject data = (JSONObject) json.get("StatusSNS");
        data = (JSONObject) data.get("ENERGY");
        return String.valueOf(data.get(key));
    }

    //return daily average kwh consumption of outlet
    public double getAvgDailykWh() throws IOException, ParseException {
        double avgDailykWh;
        LocalDateTime startTime = LocalDateTime.parse(getDataUsage("TotalStartTime").toString());
        Duration duration = Duration.between(startTime, LocalDateTime.now());
        System.out.println(duration.toDays());
        return duration.toHours();
    }

    @Override
    public String toString(){
        return "\""+this.ip+"\"";
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
