package basic.concurrent.callable_future;

import java.util.concurrent.*;

/**
 * get, isDone, cancel
 */
public class App1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        /**
         * Callable 객체는 Runnable 객체와 다르게 리턴타입을 정해줄 수 있다.
         */
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return Thread.currentThread().getName() + " :: Hello!";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());

        System.out.println("Started!");
        System.out.println(helloFuture.get());  // Blocking Call

        /**
         * true -> interrupt를 발생시키고, false -> 해당 작업을 기다린다.
         * cancel을 사용한 경우 get을 통해서 값을 가져올 수 없다.
         * => 취소한 작업에서 왜 값을 가져오려고 하냐는 예외를 발생시킴.
         */
        helloFuture.cancel(false);

        System.out.println(helloFuture.isDone());
        System.out.println("End!");
        executorService.shutdown();
    }
}
