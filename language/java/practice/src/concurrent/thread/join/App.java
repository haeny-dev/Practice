package concurrent.thread.join;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread joinThread = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });

        joinThread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        joinThread.join();
        System.out.println(joinThread + "is finished!");
    }
}
