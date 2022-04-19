package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {

        String[] strings = {"a", "abgsd", "asd", "db"};
        List<String> list = Arrays.asList(strings);

        // 람다 표현식
        lambdaExpression(strings);

        // 메소드 레퍼런스
        methodReference(strings);

        // 생성자 레퍼런스
        constructorReference(list);

        // 변수 유효 범위
        repeatMessage("Hello", 100);

    }

    /**
     * repeatMessage 메서드의 지역변수인 message와 count를 람다 표현식 내에서 사용이 가능하다.
     * - 람다 표현식에서는 값이 변하지 않는 변수만 참조할 수 있다. (이유: ThreadSafe)
     * - 중첩 블록과 동일한 유효 범위를 가진다. -> 동일한 이름 및 가리기 규칙 적용된다.
     */
    private static void repeatMessage(String message, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
//                count--;  // 변경불가
//                String message = "aa"; // 사용불가
                System.out.println(message);
                Thread.yield();
            }
        };
        new Thread(r).start();
    }

    private static void constructorReference(List<String> list) {
        Object[] objects = list.toArray();
        String[] stringArray = list.toArray(String[]::new);
    }

    private static void methodReference(String[] strings) {
        Arrays.sort(strings, (first, second) ->
                Integer.compare(first.length(), second.length()));

        Arrays.sort(strings, Comparator.comparingInt((x) -> x.length()));

        Arrays.sort(strings, Comparator.comparingInt(String::length));
    }

    private static void lambdaExpression(String[] strings) {
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
         */}

    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String first, String second) {
            return Integer.compare(first.length(), second.length());
        }
    }
}
