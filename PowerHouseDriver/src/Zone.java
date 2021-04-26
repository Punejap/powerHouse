import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

//a zone groups a set of components together - living room, dining room, etc...
//this class will include methods to quickly add various components to multiple (nested) array lists
public class Zone {
    ArrayList<Component> list = new ArrayList<>();

    public void zoneTogglePower() throws IOException {
        for(int i = 0; i < list.size(); i++){
            URL powerToggle = new URL("http://" + list.get(i).ip + "/cm?cmnd=Power%20TOGGLE");
            URLConnection conToggle = powerToggle.openConnection();
            conToggle.getInputStream();
        }
    }

    public Zone() {

    }

    public ArrayList<Component> getList() {
        return list;
    }

    public void setList(ArrayList<Component> list) {
        this.list = list;
    }

    public Zone(ArrayList<Component> list){
        this.list = list;
    }
}
