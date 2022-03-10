package reflection.classinfo;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Clazz clazz = new Clazz();
        Class<Clazz> clazzClass = Clazz.class;

        System.out.println("📍[ Fields ]");
        Arrays.stream(clazzClass.getFields()).forEach(f -> {
            try {
                System.out.println(f + " -> " + f.get(clazz));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("\n📍[ DeclaredFields 조회 ]");
        Arrays.stream(clazzClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.println(f + " -> " + f.get(clazz));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("\n📍[ DeclaredMethods 조회 ]");
        Arrays.stream(clazzClass.getDeclaredMethods()).forEach(System.out::println);

        System.out.println("\n📍[ Constructors 조회 ]");
        Arrays.stream(clazzClass.getConstructors()).forEach(System.out::println);

        System.out.println("\n📍[ SuperClass 조회 ]");
        System.out.println(ExtendedClazz.class.getSuperclass());

        System.out.println("\n📍[ Interface 조회 ]");
        Arrays.stream(ExtendedClazz.class.getInterfaces()).forEach(System.out::println);

        System.out.println("\n📍[ Modifiers 확인 ]");
        Arrays.stream(clazzClass.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println("-> Modifier.isPrivate(modifiers) = " + Modifier.isPrivate(modifiers));
            System.out.println("-> Modifier.isStatic(modifiers) = " + Modifier.isStatic(modifiers));
        });
    }
}
