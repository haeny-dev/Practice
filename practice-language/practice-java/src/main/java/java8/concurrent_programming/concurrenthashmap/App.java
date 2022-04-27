package java8.concurrent_programming.concurrenthashmap;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class App {

    private static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, LongAdder> map2 = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        Set<String> words = ConcurrentHashMap.<String>newKeySet();

        words = map.keySet(1L);
        // "Java" 가 이미 존재하지 않으면 "Java" 의 값은 1이 된다.
        words.add("Java");
    }

    private static void bulk_operation() {
        long threshold = 100;

        String searchKey = map.search(threshold, (k, v) -> v > 1000 ? k : null);

        map.forEach(threshold, (k, v) -> System.out.println(k + " -> " + v));

        map.forEach(threshold,
                (k, v) -> k + " -> " + v,   // 변환 함수
                System.out::println);       // 소비 함수

        map.forEach(threshold,
                (k, v) -> v > 1000 ? k + " -> " + v : null, // 필터와 변환을 동시에 하는 경우
                System.out::println);   // null은 소비 함수에 전달되지 않는다.

        Long sum = map.reduceValues(threshold, Long::sum);

        Integer maxLength = map.reduceKeys(threshold,
                String::length, // 변환 함수
                Integer::max);  // 누적 함수

        Long count = map.reduceValues(threshold,
                v -> v > 1000 ? 1L : null,
                Long::sum);

        // int, long, double 을 위한 특화버전
        long longSum = map.reduceValuesToLong(threshold,
                Long::longValue,    // 기본 타입으로 변환하는 함수
                0,      // 비어 있는 맵인 경우 디폴트 값
                Long::sum); // 기본 타입 누적 함수
    }

    private static void putWord(String word) {
        Long oldValue = map.get(word);
        Long newValue = oldValue == null ? 1 : oldValue + 1;
        map.put(word, newValue);
    }

    private static void replaceWord(String word) {
        Long oldValue = null;
        Long newValue = null;
        do {
            oldValue = map.get(word);
            newValue = oldValue == null ? 1 : oldValue + 1;
        } while (!map.replace(word, oldValue, newValue));
    }

    private static void putIfAbsentWord(String word) {
        map2.putIfAbsent(word, new LongAdder());
        map2.get(word).increment();

        map2.putIfAbsent(word, new LongAdder()).increment();
    }

    // Java8
    private static void computeWord(String word) {
        map.compute(word, (k, v) -> v == null ? 1 : v + 1);
    }

    private static void computeIfAbsentWord(String word) {
        map2.computeIfAbsent(word, k -> new LongAdder()).increment();
    }

    private static void mergeWord(String word) {
        map.merge(word, 1L, (existingValue, newValue) -> existingValue + newValue);
        map.merge(word, 1L, Long::sum);
    }
}
