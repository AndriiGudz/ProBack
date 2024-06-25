package homeworks_01;
/*
Task 2
Дан диапазон чисел: от 1 до 2_000_000 включительно.
Задача: найти, сколько чисел из этого диапазона делятся нацело на 21 и при этом содержат цифру 3.
Решить данную задачу в два потока, разделив между потоками заданный диапазон чисел пополам.
 */
public class Task_2 {

    private static int count = 0;
    public static void main(String[] args) {

        MyThread2 thread1 = new MyThread2(1, 1_000_000);
        MyThread2 thread2 = new MyThread2(1_000_000, 2_000_001);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Count in single thread: " + count);
    }

    public static boolean containsDigit3(int number) {
        return String.valueOf(number).contains("3");
    }

    public static synchronized void incrementCounter(){
        count++;
    }
}

class MyThread2 extends Thread {
    private final int rangeStart;
    private final int rangeEnd;

    public MyThread2(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run() {
        for (int i = rangeStart; i < rangeEnd; i++) {
            if (i % 21 == 0 && Task_2.containsDigit3(i)){
                Task_2.incrementCounter();
            }
        }
    }
}