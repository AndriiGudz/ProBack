package lessons_01.demo;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start");
        for (int i = 0; i < 1_000_000; i++) {
            Main.counter++;
        }
        System.out.println(Thread.currentThread().getName() + " Finish");
    }
}
