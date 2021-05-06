import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PowerHouseServer {
    static HashMap<String, Outlet> outletMap = new HashMap<>();
    static HashMap<String, HashMap<String, Outlet>> zoneMap =
            new HashMap<>();
    static ArrayList<Schedule> scheduleList = new ArrayList<>();


    static void startServer(){
        try {
            ServerSocket s1 = new ServerSocket(4999);
            Socket ss = s1.accept();
            Scanner sc = new Scanner(ss.getInputStream());
            PrintStream p = new PrintStream(ss.getOutputStream());
            RootCommand root = new RootCommand();


            while (true) {
                String input = sc.nextLine();
                String output = root.run(input.trim());
                p.println(output);
            }
        }
        catch (Exception e) {
            startServer();
        }
    }

    public static void main(String[] args){
        startServer();
        //Outlet CarsonOne = new Outlet("10.0.0.156");
        //Outlet BenOne = new Outlet("192.168.1.209");
        //Outlet BenTwo = new Outlet("192.168.1.224");
        //Outlet Tylerben = new Outlet("192.168.1.210");
    }
}
