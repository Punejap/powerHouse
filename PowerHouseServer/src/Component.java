/**
 *represents real-world IoT Components
 */
public abstract class Component {

    protected final String ip;

    /**
     * @param ip the local ip address of the component
     */
    public Component(String ip){
        this.ip = ip;
    }
}
