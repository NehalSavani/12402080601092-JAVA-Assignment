import java.io.*;
import java.util.*;

public class Problem5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> wordCount = new TreeMap<>();

        System.out.print("Enter file path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            System.out.println("\nWord Occurrences:");
            for (Map.Entry<String, Integer> e : wordCount.entrySet()) {
                System.out.println(e.getKey() + " : " + e.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check path.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        sc.close();
    }
}