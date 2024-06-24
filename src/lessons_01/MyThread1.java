package lessons_01;

public class MyThread1 extends Thread {


    @Override
    public void run() {
        System.out.println("Start Thread 1");

        for (int i = 100; i < 130; i++) {
            System.out.println("Thread1: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finish Thread 1");
    }
}
