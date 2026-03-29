class Outer {
    int x = 10;

    class MemberInner {
        void show() {
            System.out.println("Member Inner Class: x = " + x);
        }
    }

    void display() {

        class LocalInner {
            void show() {
                System.out.println("Local Inner Class: x = " + x);
            }
        }

        LocalInner obj = new LocalInner();
        obj.show();
    }
}

interface Test {
    void show();
}

public class Problem7 {
    public static void main(String[] args) {

        Outer outer = new Outer();

        Outer.MemberInner m = outer.new MemberInner();
        m.show();

        outer.display();

        Test t = new Test() {
            public void show() {
                System.out.println("Anonymous Inner Class");
            }
        };
        t.show();
    }
}