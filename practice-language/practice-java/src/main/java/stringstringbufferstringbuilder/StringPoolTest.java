package stringstringbufferstringbuilder;

public class StringPoolTest {
    public static void main(String[] args) {
        String pool = "문자열";
        String reusePool = "문자열";
        String newInstance = new String("문자열");

        System.out.println(pool == reusePool);  // true
        System.out.println(pool == newInstance);    // false
    }

    private static void extracted() {
        String str1 = "문자열";
        System.out.println(str1.hashCode());
        str1 += "더하기";
        System.out.println(str1.hashCode());
    }
}
