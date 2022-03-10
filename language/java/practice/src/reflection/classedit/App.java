package reflection.classedit;

import reflection.classinfo.Clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Clazz> clazzClass = Clazz.class;

        Constructor<Clazz> constructor = clazzClass.getConstructor(null);
        Clazz clazz = constructor.newInstance();

        Constructor<Clazz> constructor1 = clazzClass.getConstructor(String.class, String.class, String.class, String.class);
        Clazz anotherClazz = constructor1.newInstance("string1", "string2", "string3", "string4");

        Field field2 = Clazz.class.getDeclaredField("field2");
        System.out.println("field2.get(null) = " + field2.get(clazz));
        
        field2.set(clazz, "newValue");
        System.out.println("field2.get(clazz) = " + field2.get(clazz));

        Field field1 = clazz.getClass().getDeclaredField("field1");
        field1.setAccessible(true);
        System.out.println("field1.get(clazz) = " + field1.get(clazz));

        field1.set(clazz, "newPrivateValue");
        System.out.println("field1.get(clazz) = " + field1.get(clazz));

        Method sum = clazz.getClass().getDeclaredMethod("sum", int.class, int.class);
        int result = (int) sum.invoke(clazz, 1, 2);
        System.out.println("result = " + result);
    }
}
