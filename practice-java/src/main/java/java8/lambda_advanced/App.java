package java8.lambda_advanced;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class App {
    private static Logger logger = Logger.getLogger("App");

    public static void main(String[] args) {

        String[] strings = {"apple", "banana", "cook", "driver", "element", "float", "grape", "cook"};
        Stream<String> words = Stream.of(strings);

        String[] result = words.toArray(String[]::new);

        /**
         * 만약 가능하다면 staff 에 Person을 추가할 수 있는 상황이 벌어진다.
         * 리스트에서 읽기만 한다면 List<? extends Person> 을 받도록 할 수 있다.
         * 반대로 리스트에 쓰기만 한다면 List<? super Employee> 를 받을 수 있다.
         */
//        List<Employee> staff = new ArrayList<>();
//        List<Person> tenants = staff;
//        tenants.add(new Person("John Q. Public"));

    }

//    public static <T> void doInOrderAsync(Supplier<? extends T> first, Consumer<? super T> second, Consumer<? super Throwable> handler) {
//        ...
//    }

    private static void exceptionOfLambda() {
        /**
         * readAllBytes 메서드가 IOException을 던지는데도 불구하고 Supplier<T> 에 전달할 수 있다.
         */
        unchecked(() -> new String(Files.readAllBytes(
                Paths.get("/etc/passwd")), StandardCharsets.UTF_8));
    }

    public static <T> Supplier<T> unchecked(Callable<T> f) {
        return () -> {
            try {
                return f.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (Throwable t) {
                throw t;
            }
        };
    }

    /**
     * first가 예외를 던지면 doInOrder 메서드는 종료되고 second는 아예 실행되지 않음
     */
    public static void doInOrder(Runnable first, Runnable second) {
        first.run();
        second.run();
    }

    /**
     * first.run()이 예외를 던지면, 스레드가 종료되고 second는 아예 실행되지 않음
     * 하지만 doInOrderAsync는 바로 리턴되고 별도의 스레드에서 작업을 수행했기 때문에
     * 예외를 다시 던지는 일은 불가능하다. 이와 같은 상황에서는 처리기(handler)를 전달하는 것이 좋다.
     */
    public static void doInOrderAsync(Runnable first, Runnable second) {
        Thread t = new Thread(() -> {
            first.run();
            second.run();
        });
        t.start();
    }

    public static void doInOrderAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
        Thread thread = new Thread(() -> {
            try {
                first.run();
                second.run();
            } catch (Throwable t) {
                handler.accept(t);
            }
        });

        thread.start();
    }

    public static <T> void doInOrderAsync(Supplier<T> first, Consumer<T> second, Consumer<Throwable> handler) {
        Thread thread = new Thread(() -> {
            try {
                T result = first.get();
                second.accept(result);
            } catch (Throwable t) {
                handler.accept(t);
            }
        });
        thread.start();
    }

    public static <T> UnaryOperator<T> compose(UnaryOperator<T> op1, UnaryOperator<T> op2) {
        return t -> op2.apply(op1.apply(t));
    }

    private static void parameterOfLambda() {
        /**
         * 인자가 필요 없는 경우 인자를 받도록 강제하지 않는 Runnable 사용
         */
        repeat(10, () -> System.out.println("Hello, World!"));

        /**
         * 인자를 활용하여 IntConsumer의 연산에서 인자를 사용
         */
        repeat(10, i -> System.out.println("CountDown: " + (9 - i)));
    }

    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }
    
    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }

    private static void deferredExecution() {
        int x = 10;
        int y = 20;

        /**
         * INFO 레벨의 로그가 호출이 되는지 안되는지 여부와 상관없이
         * 메시지를 생성하는 연산이 발생함
         */
        logger.info("x: " + x + ", y: " + y);

        /**
         * 람다식을 활용하여 메시지를 생성하는 연산을 지연 실행하도록 하여
         * 로그를 남겨야 할 때만 추상 메서드 get을 호출하여 람다를 실행한다.
         */
        info(logger, () -> "x: " + x + ", y: " + y);
    }

    public static void info(Logger logger, Supplier<String> message) {
        if (logger.isLoggable(Level.INFO)) {
            logger.info(message.get());
        }
    }

}
