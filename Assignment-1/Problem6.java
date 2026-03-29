import java.util.Scanner;

abstract class Cipher {
    abstract String encrypt(String text);
    abstract String decrypt(String text);
}

class CaesarCipher extends Cipher {
    int key = 3;

    String encrypt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result += (char)(ch + key);
        }
        return result;
    }

    String decrypt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result += (char)(ch - key);
        }
        return result;
    }
}

public class Problem6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        Cipher obj = new CaesarCipher();

        String encrypted = obj.encrypt(input);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = obj.decrypt(encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}