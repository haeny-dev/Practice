package basic.concurrent.thread.interrupt;

public class App {

    public static void main(String[] args) {
        Thread interruptThread = new Thread(() -> {
            while (true) {
                System.out.println("Thread: " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("Interrupt!");
                    return;
                }
            }
        });
        interruptThread.start();
        interruptThread.interrupt();
    }
}
