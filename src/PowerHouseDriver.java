import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class PowerHouseDriver {

    public static void main(String[] args) throws IOException {

        Outlet one = new Outlet("192.168.1.224");

        one.togglePower();
    }
}
