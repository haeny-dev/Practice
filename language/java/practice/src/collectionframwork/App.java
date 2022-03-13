package collectionframwork;

import java.util.HashSet;
import java.util.Set;

public class App {


    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add("String");
        set2.add("String");

        System.out.println(set1 == set2);
        System.out.println(set1.equals(set2));
    }
}
