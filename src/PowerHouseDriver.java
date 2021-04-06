import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class PowerHouseDriver {

    public static void main(String[] args) throws IOException {
        ArrayList<String> zone1 = new ArrayList<>();

        Outlet one = new Outlet("192.168.1.224");
        //hello world
        one.togglePower();
        //hey to you too hmmm
    }
}
