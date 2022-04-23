package java8.stream;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class App {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        String[] strings = {"apple", "banana", "cook", "driver", "element", "float", "grape", "cook"};
        List<String> words = Arrays.asList(strings);

        Stream<Person> people = Stream.of(new Person(1, "홍길동"), new Person(2, "임꺽정"));
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Stream<City> cities = Stream.of(
                new City("서울", "서울", 1000),
                new City("경기도", "성남시", 200),
                new City("경기도", "수원시", 300));



    }

    private static void parallelStream(String[] strings, List<String> words) {
        /**
         * 순차 스트림 -> 병렬 스트림 변환
         */
        Stream<String> parallelWords = Stream.of(strings).parallel();

        /**
         * 멀티 스레드 환경에서 안전하지 않은 코드
         */
        int[] shortWords = new int[12];
        words.stream().parallel().forEach(w -> {
            if (w.length() < 5) {
                shortWords[w.length()]++;
            }
        });

        System.out.println(Arrays.toString(shortWords));

        Stream<String> limit = words.stream().parallel().unordered().limit(3);
    }

    private static void primitiveTypeStream(int[] values, List<String> words) {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        IntStream streamFromArray = Arrays.stream(values, 0, 2);

        IntStream zeroToNinetyNine = IntStream.range(0, 100);
        IntStream zeroToHundred = IntStream.rangeClosed(0, 100);

        IntStream lengths = words.stream().mapToInt(String::length);

        Stream<Integer> boxed = IntStream.range(0, 100).boxed();
    }

    private static void streamGroupingAndPartitioning(Stream<Locale> locales, Stream<City> cities) {
        /**
         * 로케일을 국가별로 묶는 경우
         * 분류함수 -> Locale::getCountry
         */
        Map<String, List<Locale>> countryToLocales = locales.collect(
                groupingBy(Locale::getCountry));

        /**
         * 분류함수가 Predicate<T> 일 떄
         */
        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
                partitioningBy(l -> l.getLanguage().equals("en")));

        List<Locale> englishLocales = englishAndOtherLocales.get(true);

        /**
         * 다운스트림 컬렉터
         */
        // Map의 값으로 List가 아닌 다른 타입을 원하는 경우
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(
                groupingBy(Locale::getCountry, toSet()));

        // 카운팅
        Map<String, Long> countryToLocaleCounts = locales.collect(
                groupingBy(Locale::getCountry, counting()));

        // 합계

        Map<String, Integer> stateToCityPopulation = cities.collect(
                groupingBy(City::getState, summingInt(City::getPopulation)));

        // 최댓값, 최솟값
        Map<String, Optional<City>> stateToLargestCity = cities.collect(
                groupingBy(City::getState,
                        maxBy(Comparator.comparing(City::getPopulation))));

        // mapping
        Map<String, Optional<String>> stateToLongestCityName = cities.collect(
                groupingBy(City::getState,
                        mapping(City::getName,
                                maxBy(Comparator.comparing(String::length)))));

        Map<String, Set<String>> countryToLanguages = locales.collect(
                groupingBy(l -> l.getDisplayCountry(),
                        mapping(l -> l.getDisplayLanguage(),
                                toSet())));

        // summr
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(
                groupingBy(City::getState, summarizingInt(City::getPopulation)));

        // reducing
        Map<String, String> stateToCityNames = cities.collect(
                groupingBy(City::getState,
                        reducing("", City::getName,
                                (s, t) -> s.length() == 0 ? t : s + ", " + t)));

        // 같은 결과
        stateToCityNames = cities.collect(
                groupingBy(City::getState,
                        mapping(City::getName, joining(", "))));
    }

    private static void collectStreamToMap(Stream<Person> people) {
        Map<Integer, String> idToName = people.collect(
                toMap(Person::getId, Person::getName));
        Map<Integer, Person> idToPerson = people.collect(
                toMap(Person::getId, Function.identity()));

        /**
         * 같은 언어가 두 번 나타날 수 있다는 점은 고려하지 않고 그저 첫 번째 항목만 유지한다.
         */
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(
                toMap(
                        l -> l.getDisplayLanguage(),
                        l -> l.getDisplayLanguage(l),
                        (existingValue, newValue) -> existingValue));

        /**
         * 특정 국가에서 사용하는 모든 언어를 알고 싶을 경우
         */
        Map<String, Set<String>> countryLanguageSets = locales.collect(
                toMap(
                        l -> l.getDisplayCountry(),
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> {
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return r;
                        }));

        /**
         * TreeMap을 원하는 경우
         */
        TreeMap<Integer, Person> idToPersonTreeMap = people.collect(
                toMap(
                        Person::getId,
                        Function.identity(),
                        (existingValue, newValue) -> {
                            throw new IllegalStateException();
                        },
                        TreeMap::new));
    }

    private static void collectStream(List<String> words) {
        /**
         * 반복자
         */
        Iterator<String> iterator = words.stream().iterator();

        /**
         * 배열
         */
        Object[] objects = words.stream().toArray();
        String[] toArray = words.stream().toArray(String[]::new);

        /**
         * collect 는 세 가지 인자를 받는다.
         * 1. 공급자(supplier): 대상 객체의 새로운 인스턴스를 만든다.(ex. HashSet 생성자)
         * 2. 누산자(accumulator): 요소를 대상에 추가한다.(ex. add 메서드)
         * 3. 결합자(combiner): 두 객체를 하나로 병합한다.(ex. addAll 메서드)
         */
        HashSet<String> result = words.stream()
                .collect(HashSet::new, HashSet::add, HashSet::addAll);

        /**
         * 세 함수를 제공하는 편리한 Collector 인터페이스와
         * 공통 컬렉터용 팩토리 메서드를 제공하는 Collectors 클래스를 사용하면 된다.
         */
        List<String> toList = words.stream().collect(toList());

        // 특정 컬렉션을 얻고 싶을 때
        TreeSet<String> toTreeSet = words.stream().collect(toCollection(TreeSet::new));

        // 문자열 연결
        String joining = words.stream().collect(joining());
        String joiningWithDel = words.stream().collect(joining(", "));

        // 합계, 평균, 최댓값, 최솟값으로 리듀스
        IntSummaryStatistics summaryStatistics = words.stream()
                .collect(summarizingInt(String::length));
    }

    private static void reduction(List<String> words) {
        /**
         * BinaryOperator
         */
        Stream<Integer> values = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> sum = values.reduce((x, y) -> x + y);

//        Integer identity = values.reduce(0, (x, y) -> x + y);

        /**
         * 누적 함수 -> (total, word) -> total + word.length();
         *
         * 병렬화하면 이와 같은 계싼이 여러개 존재하므로 각각의 결과를 결합해야 한다.
         * -> (total1, total2) -> total1 + total2
         */
        Integer result = words.stream().reduce(0,
                (total, word) -> total + word.length(),
                (total1, total2) -> total1 + total2);

        System.out.println(result);
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
            if (word.length() > 5) count++;
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
