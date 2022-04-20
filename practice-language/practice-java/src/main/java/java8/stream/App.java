package java8.stream;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "cook", "driver", "element", "float", "grape", "cook"};
        List<String> words = Arrays.asList(strings);
    }

    private static void basicReductionStream(List<String> words) {
        Optional<String> largest = words.stream().max(String::compareToIgnoreCase);
        if (largest.isPresent()) {
            System.out.println("largest: " + largest.get());
        }

        /**
         * findFirst 메서드는 비어 있지 않은 컬렉션에서 첫 번째 값을 리턴한다.
         */
        Optional<String> startsWithE = words.stream().filter(w -> w.startsWith("e")).findFirst();

        /**
         * findAny 이 메서드는 스트림을 병렬화할 때 유용한데,
         * 이 경우 조사 대상 세그먼트(segment)들에서 처음 일치가 발경되면 계산을 완료하기 때문이다.
         */
        Optional<String> startsWithC = words.stream().filter(w -> w.startsWith("c")).findAny();

        /**
         * 단순 일치하는 요소의 경우 anyMatch를 사용한다.
         * Predicate<T> 를 인자로 받기 때문에 filter가 필요없다.
         */
        boolean hasWordStartsWithA = words.parallelStream().anyMatch(w -> w.startsWith("a"));
    }

    private static void statefulTransformationStream(String[] strings, List<String> words) {
        Stream<String> uniqueWords = Stream.of(strings).distinct();
        Stream<String> longestFirst = words.stream().sorted(Comparator.comparing(String::length).reversed());
    }

    private static void extractionAndMergeStream() {
        /**
         * 추출 -> limit, skip, peek
         * 결합 -> concat
         */
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
        Stream<Double> skipRandoms = Stream.generate(Math::random).skip(100);
        Stream<Character> combined = Stream.concat(characterStream("Hello"), characterStream("World"));
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20)
                .toArray();
    }

    private static void statelessTransformationStream(List<String> words) {
        /**
         * filter와 map의 일반적인 사용
         */
        Stream<String> filterAndMapOperationStream = words.stream()
                .filter(w -> w.length() > 5)
//                .map(w -> w.toUpperCase())
                .map(String::toUpperCase);

        /**
         * Stream의 Stream을 리턴하는 경우
         * [['a','p','p','l','e'],['b','a','n','a','n','a'],...]
         *
         * flatMap 사용
         * ['a','p','p','l','e','b','a','n','a','n','a',...] 으로 펼쳐짐
         */
        Stream<Stream<Character>> result = words.stream().map(App::characterStream);
        Stream<Character> letters = words.stream().flatMap(App::characterStream);
    }

    private static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }

    private static void generateStream(String[] strings, List<String> words) {
        /**
         * 기본적인 스트림 생성 방식
         */
        Stream<String> collectionStream = words.stream();
        Stream<String> arrayStreamByStaticMethod = Stream.of(strings);
        Stream<String> arrayStreamByArrays = Arrays.stream(strings);
        Stream<Object> emptyStream = Stream.empty();

        /**
         * 무한 스트림
         */
        // generate 메서드 -> Supplier<T> 활용
        Stream<String> echos = Stream.generate(() -> "Echo");
        Stream<Double> randoms = Stream.generate(Math::random);

        // iterate 메서드 -> UnaryOperator<T> 활용
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
    }

    private static void iteratorAndStream(List<String> words) {
        /**
         * 반복자를 통한 연산
         */
        long start = System.nanoTime();
        int count = 0;
        for (String word : words) {
            if(word.length() > 5) count++;
        }
        long time = System.nanoTime() - start;
        System.out.println("단어의 길이가 5보다 긴 단어의 수는 " + count + "개 입니다. -> " + time);

        /**
         * 스트림을 통한 연산
         */
        start = System.nanoTime();
        long count1 = words.stream().filter(w -> w.length() > 5).count();
        time = System.nanoTime() - start;
        System.out.println("단어의 길이가 5보다 긴 단어의 수는 " + count1 + "개 입니다. -> " + time);

        /**
         * 병렬 스트림을 통한 연산
         */
        start = System.nanoTime();
        long count2 = words.parallelStream().filter(w -> w.length() > 5).count();
        time = System.nanoTime() - start;
        System.out.println("단어의 길이가 5보다 긴 단어의 수는 " + count2 + "개 입니다. -> " + time);
    }
}
