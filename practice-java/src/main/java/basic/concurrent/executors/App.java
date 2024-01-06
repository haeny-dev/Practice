package basic.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    /**
     * Runnable 인터페이스의 run 메서드의 경우 반환타입이 void 입니다.
     */
    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + " :: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        /**
         * Executor는 Runnable 객체만 구현하여 넘겨주고 나머지 스레드 관리는 Executor에게 넘겨주는 개념이며,
         * Runnable 객체를 받아서 사용하는 만큼 실행 결과 반환값이 없는 경우일 때 사용한다.
         */
        // 스레드가 1개인 ExecutorService 생성
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();

        // 스레드가 2개인 ExecutorService 생성
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(2);
        fixedExecutorService.submit(getRunnable("Hello"));
        fixedExecutorService.submit(getRunnable("Haeny"));
        fixedExecutorService.submit(getRunnable("The"));
        fixedExecutorService.submit(getRunnable("Java"));
        fixedExecutorService.submit(getRunnable("Thread"));

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(getRunnable("Schedule"), 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(
                getRunnable("ScheduleAtFixedRate"), 1, 2, TimeUnit.SECONDS);

        // 처리중인 작업을 기다렸다가 종료
        fixedExecutorService.shutdown();

        // 당장 종료
//        scheduledExecutorService.shutdownNow();
    }
}
