package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();

        sumOfListByWildcard(integerList);
        sumOfListByWildcard(doubleList);
        sumOfListByWildcard(numberList);
    }

    private static void processStringList(List<String> stringList) {
        // ....
    }

    public static double sumOfListByWildcard(List<? extends Number> list) {
        double s = 0;
        for (Number number : list) {
            s += number.doubleValue();
        }
        return s;
    }

    private static Box createBox() {
        return new Box();
    }

    private static void rawTypesTest() {
        // 원시 타입(Raw Type)
        Box rawBox = new Box();

        // 제네릭 타입
        Box<String> stringBox = new Box<>();

        // 경고: 확인되지 않은 변환
        rawBox = new Box();
        Box<Integer> integerBox = rawBox;

        // 할당 허용
        rawBox = stringBox;

        // 경고
        rawBox.setT(8);
    }
}
