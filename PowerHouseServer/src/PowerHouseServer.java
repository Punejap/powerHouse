import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class PowerHouseServer {
    public static void main(String[] args) throws IOException {

        ServerSocket s1 = new ServerSocket(4999);
        Socket ss = s1.accept();
        Scanner sc = new Scanner(ss.getInputStream());
        Outlet one = new Outlet(sc.next());

        one.togglePower();

        PrintStream p = new PrintStream(ss.getOutputStream());
        p.println("I toggled power");

    }
}
