package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {

        String[] strings = {"a", "abgsd", "asd", "db"};

        /**
         * 람다식을 사용하지 않은 경우
         */
        Arrays.sort(strings, new LengthComparator());

        /**
         * 람다식을 사용할 경우
         * 람다 표현식의 파라미터 타임을 추정할 수 있는 경우에는 타입을 생략할 수 있다.
         */
        Arrays.sort(strings, (first, second) ->
                Integer.compare(first.length(), second.length()));

        /**
         * 메서드에서 추정되는 타입 한 개를 파라미터로 받으면 괄호를 생략할 수 있다.
         * event -> System.out.println("Click");
         */

        /**
         * 메서드 파라미터와 마찬가지 방식으로 람다 파라미터에 애노테이션이나 final 키워드를 사용할 수 있다.
         * (final String name) -> ...
         * (@NonNull String name) -> ...
         */

        /**
         * 람다 표현식이 파라미터를 받지 않는 경우 -> 빈 괄호를 사용한다.
         * () -> { for(int i = 0; i < 1000; i++) doWork(); }
         */

        /**
         * 표현식 하나가 아닐 경우
         */
        Arrays.sort(strings, (first, second) -> {
            if (first.length() < second.length()) return -1;
            else if (first.length() > second.length()) return 1;
            else return 0;
        });

        /**
         * 람다 표현식의 결과 타입은 지정하지 않는다. 결과 타입은 항상 문맥으로부터 추정된다.
         */
    }

    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String first, String second) {
            return Integer.compare(first.length(), second.length());
        }
    }
}
