import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class PowerHouseDriver {

    public static void main(String[] args) throws IOException, ParseException {

        //Outlet CarsonOne = new Outlet("10.0.0.156");
        Outlet BenOne = new Outlet("192.168.1.209");
        Outlet BenTwo = new Outlet("192.168.1.224");
        Outlet Tylerben = new Outlet("192.168.1.210");
        //one.togglePower();
        //BenOne.togglePower();
        System.out.println(BenOne.getkWhToday() + "kWh");
        BenOne.kwhLimit = 0.355;
        //two.savePower();
        Zone zoneOne = new Zone();
        zoneOne.componentList.add(BenOne);
        zoneOne.componentList.add(Tylerben);

        Zone zoneTwo = new Zone();
        zoneTwo.componentList.add(BenTwo);

        //Tylerben.togglePower();
        //BenOne.togglePower();
        zoneOne.zoneTogglePower();
    }
}
