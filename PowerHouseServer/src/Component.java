import java.io.IOException;

//this is the basic, abstract parent class to define the ip address and power toggling for components
//in the system
public abstract class Component {

    protected final String ip;
 //0 for off, 1 for on. Can be a range in case of dimmable bulbs

    public Component(String ip){
        this.ip = ip;
    }

    public abstract void togglePower() throws IOException;

}
