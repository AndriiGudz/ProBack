package lessons_01;

public class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Start Thread 2");

        for (int i = 1000; i < 1010; i++) {
            System.out.println("Thread2: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finish Thread 2");
    }
}
