import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PowerHouseClient {
    public static void main(String[] args) throws IOException {
        String command, temp;
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("10.0.0.28", 4999);
        InputStreamReader sc1 = new InputStreamReader(s.getInputStream());
        BufferedReader read = new BufferedReader(sc1);

        while(true){
            command = sc.nextLine();
            PrintStream p = new PrintStream(s.getOutputStream());
            p.println(command);
            temp = read.readLine();
            System.out.println(temp);
        }


    }
}
