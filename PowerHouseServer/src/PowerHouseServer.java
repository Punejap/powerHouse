import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

/**
 * this is the main driver for PowerHouseServer. This program is used to control tasmota based components by
 * accepting inputs from a connected client and executing the relevant commands.
 * Commands directly affecting the components are sent via HTTP request utilizing tasmota api.
 * It can store component information, create schedules and zones, return power monitoring data, and more.
 * It can read and store data from a configuration file, allowing presets for stored outlets, schedules, and zones.
 */
public class PowerHouseServer {
    //these maps store user defined instantiations of various objects
    static HashMap<String, Outlet> outletMap = new HashMap<>();
    static HashMap<String, HashMap<String, Outlet>> zoneMap = new HashMap<>();
    static HashMap<Integer, Schedule> scheduleMap = new HashMap<>();

    static void startServer(){

        //start server socket, create input/output streams and use inputs to call methods
        try {
            ServerSocket s1 = new ServerSocket(4999);
            Socket ss = s1.accept();
            Scanner sc = new Scanner(ss.getInputStream());
            PrintStream p = new PrintStream(ss.getOutputStream());
            RootCommand root = new RootCommand();

            //server will run continuously unless it either crashes or the user terminates
            while (true) {
                String input = sc.nextLine();
                String output = root.run(input.trim());
                p.println(output);
            }
        }
        //if server fails to create a socket, it will retry until success
        catch (Exception e) {
            startServer();
        }
    }

    //method call to read configuration file
    static void configure(){
        try{
            ConfigReader configReader = new ConfigReader();
            configReader.readFile();
            System.out.println("configuration successful");
        }catch(Exception e){
            System.out.println("configuration error");
        }
    }

    public static void main(String[] args){
        configure();
        startServer();
    }
}
