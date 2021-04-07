import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

//this will be used to test control. currently, Ben's outlet does toggle power using this program
public class PowerHouseDriver {

    public static void main(String[] args) throws IOException {
        ArrayList<String> zone1 = new ArrayList<>();

        Outlet one = new Outlet("192.168.1.224");

        one.togglePower();

    }
}
