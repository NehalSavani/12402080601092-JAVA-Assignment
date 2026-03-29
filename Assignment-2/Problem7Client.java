import java.io.*;
import java.net.*;
import java.util.*;

public class Problem7Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server!");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);
            String msg;

            while (true) {
                System.out.print("Enter message: ");
                msg = sc.nextLine();

                out.println(msg);

                String response = in.readLine();
                System.out.println("Server: " + response);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}