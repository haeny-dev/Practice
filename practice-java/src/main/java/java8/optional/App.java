package java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class App {
    public static void main(String[] args) {

        String[] values = {
                "lambda", "stream", "optional", "interfaceDefaultMethod", "interfaceStaticMethod", "FunctionalInterface"};

        List<String> list = Arrays.asList(values);

        Optional<String> optionalValue = list.stream()
                .filter(w -> w.equals("optional"))
                .findAny();

        Double doubleValue = 3.14;

        Optional<Double> result = Optional.of(-4.0)
                .flatMap(App::inverse)
                .flatMap(App::squareRoot);
    }

    private static void generateOptionalValue(Double doubleValue) {
        Optional<Double> inverseValue = inverse(doubleValue);

        /**
         * Optional.ofNullable(obj)는 obj가 null이 아니면 Optional.of(obj)를,
         * null이면 Optional.empty() 를 리턴한다.
         */
        Object obj = null;
        Optional<Object> OptionalObj = Optional.ofNullable(obj);
    }

    private static Optional<Double> inverse(Double v) {
        return v == 0 ? Optional.empty() : Optional.of(1 / v);
    }

    private static Optional<Double> squareRoot(Double v) {
        return v < 0 ? Optional.empty() : Optional.of(Math.sqrt(v));
    }

    private static void valueControl(Optional<String> optionalValue) {
        /**
         * 값이 있을 때 해당 값을 이용한 함수 실행
         */
        optionalValue.ifPresent(System.out::println);

        /**
         * 값이 없을 때 디폴트 값 반환
         */
        String value = optionalValue.orElse("defaultValue");

        /**
         * 값이 없을 때 디폴트를 생성하는 함수 실행
         */
        String defaultValue = optionalValue.orElseGet(() -> {
            return "defaultValue";
        });

        /**
         * 값이 없을 떄 예외를 발생시키고 싶을 경우
         */
        optionalValue.orElseThrow(NoSuchElementException::new);
    }

    private static void basic(Optional<String> optionalValue) {
        /**
         * 안전한 사용
         */
        if (optionalValue.isPresent()) {
            System.out.println(optionalValue.get());
        }
    }
}
