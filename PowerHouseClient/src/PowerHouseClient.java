import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PowerHouseClient {
    public static void main(String[] args) throws IOException {
        String ip, temp;
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("192.168.1.175", 4999);

        InputStreamReader sc1 = new InputStreamReader(s.getInputStream());
        BufferedReader read = new BufferedReader(sc1);
        System.out.println("enter ip");
        ip = sc.next();

        PrintStream p = new PrintStream(s.getOutputStream());
        p.println(ip);
        temp = read.readLine();
        System.out.println(temp);

    }
}
