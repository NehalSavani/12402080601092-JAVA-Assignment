import java.util.*;
import java.util.concurrent.*;

class PrimeUtil {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

class ThreadPrime extends Thread {
    int start, end;

    ThreadPrime(int s, int e) {
        start = s;
        end = e;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (PrimeUtil.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}

class RunnablePrime implements Runnable {
    int start, end;

    RunnablePrime(int s, int e) {
        start = s;
        end = e;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (PrimeUtil.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}

public class Problem1 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter start number: ");
        int start = sc.nextInt();

        System.out.print("Enter end number: ");
        int end = sc.nextInt();

        System.out.println("\nUsing Thread class:");
        ThreadPrime t1 = new ThreadPrime(start, end);
        t1.start();
        t1.join();

        System.out.println("\n\nUsing Runnable interface:");
        Thread t2 = new Thread(new RunnablePrime(start, end));
        t2.start();
        t2.join();

        System.out.println("\n\nUsing Executor Framework:");
        ExecutorService ex = Executors.newSingleThreadExecutor();
        ex.execute(new RunnablePrime(start, end));
        ex.shutdown();

        sc.close();
    }
}