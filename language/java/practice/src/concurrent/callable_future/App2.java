package concurrent.callable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return Thread.currentThread().getName() + " :: Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return Thread.currentThread().getName() + " :: Java";
        };

        Callable<String> haeny = () -> {
            Thread.sleep(1000L);
            return Thread.currentThread().getName() + " :: Haeny";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, haeny));
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        String result = executorService.invokeAny(Arrays.asList(hello, java, haeny));
        System.out.println(result);

        executorService.shutdown();
    }
}
