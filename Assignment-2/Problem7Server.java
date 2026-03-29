import java.io.*;
import java.net.*;

public class Problem7Server {
    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is running and waiting for client...");

            Socket socket = server.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String msg;

            while ((msg = in.readLine()) != null) {
                System.out.println("Client: " + msg);
                out.println("Echo: " + msg);
            }

            socket.close();
            server.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}