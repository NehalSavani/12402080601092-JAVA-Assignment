class Buffer {
    private int data;
    private boolean available = false;

    synchronized void produce(int value) {
        try {
            while (available) {
                wait();
            }
            data = value;
            System.out.println("Produced: " + data);
            available = true;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void consume() {
        try {
            while (!available) {
                wait();
            }
            System.out.println("Consumed: " + data);
            available = false;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer extends Thread {
    Buffer buffer;

    Producer(Buffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
        }
    }
}

class Consumer extends Thread {
    Buffer buffer;

    Consumer(Buffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
        }
    }
}

public class Problem2 {
    public static void main(String[] args) {

        Buffer b = new Buffer();

        Producer p = new Producer(b);
        Consumer c = new Consumer(b);

        p.start();
        c.start();
    }
}