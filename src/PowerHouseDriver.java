import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class PowerHouseDriver {

    public static void createSettings() throws IOException, ParseException {


        JSONObject obj = new JSONObject();
        obj.put("Enable", 1);
        obj.put("Time", "02:23");
        obj.put("Window", 0);
        obj.put("Days", "SMTWTFS");
        obj.put("Repeat", 1);
        obj.put("Output", 1);
        obj.put("Action", 1);
        URL con = new URL("http://192.168.1.209/cm/Timer1" + obj);
        URLConnection Jcon = con.openConnection();
        Jcon.setDoOutput(true);
        OutputStreamWriter op = new OutputStreamWriter(Jcon.getOutputStream());
       // JSONObject data = (JSONObject) Jcon.("Timer1 " + obj);
        System.out.println(obj);
    }
    public static void main(String[] args) throws IOException, ParseException {

        Outlet CarsonOne = new Outlet("10.0.0.156");
        Outlet BenOne = new Outlet("192.168.1.209");
        Outlet BenTwo = new Outlet("192.168.1.224");
        Outlet Tylerben = new Outlet("192.168.1.210");


        createSettings();


        //System.out.println(BenOne.getkWhToday() + "kWh");
        //BenOne.kwhLimit = 0.355;
        //two.savePower();
        //Zone zoneOne = new Zone();
        //zoneOne.list.add(BenOne);
        //zoneOne.list.add(Tylerben);

        //Zone zoneTwo = new Zone();
        //zoneTwo.list.add(BenTwo);


        //BenTwo.togglePower();
        //Tylerben.togglePower();
        //BenOne.togglePower();
        //zoneOne.zoneTogglePower();
        //zoneTwo.zoneTogglePower();
        //zoneTwo.zoneTogglePower();
    }
}
