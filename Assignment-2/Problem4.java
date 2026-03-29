import java.util.*;

class Book implements Comparable<Book> {
    int id;
    String name;
    double price;

    Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int compareTo(Book b) {
        return this.id - b.id;
    }

    public String toString() {
        return id + " " + name + " " + price;
    }
}

class PriceComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        if (b1.price > b2.price)
            return 1;
        else if (b1.price < b2.price)
            return -1;
        else
            return 0;
    }
}

public class Problem4 {
    public static void main(String[] args) {

        ArrayList<Book> list = new ArrayList<>();

        list.add(new Book(3, "Java", 500));
        list.add(new Book(1, "Python", 300));
        list.add(new Book(2, "C++", 400));

        System.out.println("Sorted by ID (Comparable):");
        Collections.sort(list);
        for (Book b : list) {
            System.out.println(b);
        }

        System.out.println("\nSorted by Price (Comparator):");
        Collections.sort(list, new PriceComparator());
        for (Book b : list) {
            System.out.println(b);
        }
    }
}