package java8.concurrent_programming.arrays_operation;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        String[] words = {"java", "spring", "springboot", "intelliJ", "jpa"};
        int[] values = {1, 2, 3, 4, 5};

        Arrays.parallelSort(words);

        // 범위 지정
        Arrays.parallelSort(values, values.length / 2, values.length);

        // i -> i % 10 한 값으로 채운다 여기서 i 는 인덱스
        Arrays.parallelSetAll(values, i -> i % 10);

        // [1, 1 * 2, 1 * 2 * 3, 1 * 2 * 3 * 4, ...]
        Arrays.parallelPrefix(values, (x, y) -> x * y);

    }
}
