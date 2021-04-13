import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

//a zone groups a set of components together - living room, dining room, etc...
//this class will include methods to quickly add various components to multiple (nested) array lists
public class Zone {


    static ArrayList<Component> componentList = new ArrayList<>();

    public void zoneTogglePower() throws IOException {
        for(int i = 0; i < componentList.size(); i++){
            URL powerToggle = new URL("http://" + componentList.get(i).ip + "/cm?cmnd=Power%20TOGGLE");
            URLConnection conToggle = powerToggle.openConnection();
            conToggle.getInputStream();
        }
    }


}
