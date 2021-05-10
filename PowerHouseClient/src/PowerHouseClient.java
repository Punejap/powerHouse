import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client connects to server, two way communication
 */
public class PowerHouseClient {
    public static void main(String[] args) throws IOException {
        String command, temp;
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("192.168.1.175", 4999);
        InputStreamReader sc1 = new InputStreamReader(s.getInputStream());
        BufferedReader read = new BufferedReader(sc1);
        PrintStream p = new PrintStream(s.getOutputStream());

        while(true){
            command = sc.nextLine();
            p.println(command);
            temp = read.readLine();
            System.out.println(temp);
        }
    }
}
