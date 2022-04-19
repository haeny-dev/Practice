package basic.stringstringbufferstringbuilder;

public class StringBufferTest {
    private static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] values = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

        for (int i = 0; i < names.length; i++) {
            int j = i;
            Thread thread = new Thread(() -> addProperty(names[j], values[j]));
            thread.start();
        }

        new Thread(() -> System.out.println(sb)).start();
    }

    private synchronized static void addProperty(String name, String value) {
        if (name != null && !name.isEmpty() && value != null && !value.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }

            sb.append(name).append("=").append(value);
        }
    }
}
