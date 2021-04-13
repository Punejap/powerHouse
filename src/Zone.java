import java.util.ArrayList;

//a zone groups a set of components together - living room, dining room, etc...
//this class will include methods to quickly add various components to multiple (nested) array lists
public class Zone {
    String zoneName;

    public Zone(String ZoneName) {
        zoneName = ZoneName;
    }

    ArrayList<Component> componentList = new ArrayList<>();

}
