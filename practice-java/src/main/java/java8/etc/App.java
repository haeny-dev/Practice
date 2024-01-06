package java8.etc;

public class App {
    public static void main(String[] args) {



    }

    private static void stringMethod() {
        final String DELIMITER = "/";
        String joined = String.join(DELIMITER, "local", "test", "stg", "prd");
    }
}
