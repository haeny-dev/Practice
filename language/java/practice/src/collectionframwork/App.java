package collectionframwork;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class App {

    public static void main(String[] args) {
    }

    private static void linkedHashMap() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", "valueA");
        linkedHashMap.put("b", "valueB");
        linkedHashMap.put("c", "valueC");

        linkedHashMap.forEach((key, value) -> System.out.println(key));

        linkedHashMap.put("a", "newValue");

        linkedHashMap.forEach((key, value) -> System.out.println(key));
    }

    private static void set() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add("String");
        set2.add("String");

        System.out.println(set1 == set2);
        System.out.println(set1.equals(set2));
    }
}
