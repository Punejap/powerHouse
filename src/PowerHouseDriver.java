import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class PowerHouseDriver {

    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<String> zone1 = new ArrayList<>();

        //Outlet one = new Outlet("10.0.0.156");
        Outlet two = new Outlet("192.168.1.209");

        //one.togglePower();
        //two.togglePower();
        System.out.println(two.getkWhToday() + "kWh");
        two.kwhLimit = 0.355;
        two.savePower();
    }
}
