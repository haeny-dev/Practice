package basic.stringstringbufferstringbuilder;

public class StringEqualsMethodTest {
    public static void main(String[] args) {
        String pool = "a";
        String pool2 = "a";
        String instance = new String("a");
        String instance2 = new String("a");

        System.out.println(pool == pool2);  // true
        System.out.println(pool == instance);   // false
        System.out.println(instance == instance2);  // false
        System.out.println(instance.equals(pool));  // true
        System.out.println(instance.equals(instance2)); // true
    }
}
