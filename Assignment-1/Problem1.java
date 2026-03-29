import java.util.*;

class Operations {
    int arr[];
    int n;

    Operations(int size) {
        n = size;
        arr = new int[n];
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    void display() {
        System.out.print("Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void reverseArray() {
        System.out.print("Reversed Array: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void sortArray() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Array Sorted.");
    }

    void search(int key) {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at position: " + (i + 1));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element not found.");
        }
    }

    void average() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double avg = (double) sum / n;
        System.out.println("Average = " + avg);
    }

    void maximum() {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum = " + max);
    }

    void reverseString(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        System.out.println("Reversed String: " + rev);
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        Operations obj = new Operations(size);

        obj.input();
        obj.display();

        obj.reverseArray();

        obj.sortArray();
        obj.display();

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        obj.search(key);

        obj.average();
        obj.maximum();

        sc.nextLine();
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        obj.reverseString(str);
    }
}