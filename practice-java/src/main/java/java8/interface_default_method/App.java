package java8.interface_default_method;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        // forEach가 없었을 때
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // forEach가 생성된 후
        list.forEach(System.out::println);

    }
}
