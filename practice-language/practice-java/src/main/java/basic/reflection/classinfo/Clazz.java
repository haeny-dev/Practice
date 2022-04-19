package basic.reflection.classinfo;

import basic.reflection.annotation.AnotherAnnotation;
import basic.reflection.annotation.MyAnnotation;

@MyAnnotation
public class Clazz {

    @AnotherAnnotation
    String field4 = "default field";
    public String field2 = "public field";
    private String field1 = "private field";
    protected String field3 = "protected field";

    public static String field5 = "public static field";
    private static String field6 = "private static field";
    private static final String field7 = "private static final field";

    public Clazz() {}

    @AnotherAnnotation
    public Clazz(String field4, String field2, String field1, String field3) {
        this.field4 = field4;
        this.field2 = field2;
        this.field1 = field1;
        this.field3 = field3;
    }

    @AnotherAnnotation
    private void method1(){
        System.out.println("private method");
    }

    public void method2() {
        System.out.println("public method");
    }

    public String method3() {
        return "return type string method";
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
