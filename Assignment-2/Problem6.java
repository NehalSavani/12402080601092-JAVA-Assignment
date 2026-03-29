import java.io.*;
import java.util.*;

public class Problem6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String path = sc.nextLine();

        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {

            File[] files = dir.listFiles();

            System.out.println("\nFiles in directory:");
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getName());
                }
            }

        } else {
            System.out.println("Invalid directory path");
        }

        sc.close();
    }
}