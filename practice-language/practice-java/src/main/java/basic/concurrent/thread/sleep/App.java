package basic.concurrent.thread.sleep;

public class App {

    /**
     * Thread를 상속받아 새로운 스레드 객체를 만드는 경우
     */
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        /**
         * Thread 객체를 생성할 때, Runnable 인터페이스를 넘겨주어 람다식으로 구현하여 사용하는 경우
         */
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L);    // 해당 스레드를 1000millis 동안 재운다.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread: " + Thread.currentThread().getName());
        });

        thread.start();
    }
}


