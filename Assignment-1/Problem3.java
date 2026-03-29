import java.util.*;

public class Problem3 {
    public static void main(String[] args) {

        int a = 10;
        double b = 20.5;

        Integer obj1 = Integer.valueOf(a);
        Double obj2 = Double.valueOf(b);

        System.out.println("Wrapper Objects:");
        System.out.println("Integer Object = " + obj1);
        System.out.println("Double Object = " + obj2);

        int x = obj1.intValue();
        double y = obj2.doubleValue();

        System.out.println("Back to Primitive:");
        System.out.println("int value = " + x);
        System.out.println("double value = " + y);

        String s = "Hello";
        s.concat(" World");
        System.out.println("String after concat = " + s);

        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println("StringBuffer after append = " + sb);
    }
}