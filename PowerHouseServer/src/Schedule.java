//this class will contain methods and fields to create custom schedules for components based on time
//ex. set schedule for outdoor lights, turn specific components off during sleeping hours

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Schedule implements Settable {
    String ip;
    //schedules could be considered scenes, but a scene contains much more info
    @Override
    public void createSettings() throws IOException {
        URL con = new URL("http://" + this.ip + "/cs?");
        URLConnection Jcon = con.openConnection();
        OutputStreamWriter op = new OutputStreamWriter(Jcon.getOutputStream());
        JSONObject obj = new JSONObject();
        obj.put("Enable", 1);
        obj.put("Time", "02:23");
        obj.put("window", 0);
        obj.put("days", "1111111");
        obj.put("Repeat", 0);
        obj.put("Output", 1);
        obj.put("Action", 1);
        op.write("Timer1" + obj);
    }



    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
