package lessons_01;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start main");

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        Thread thread = new Thread(myThread2);
        Thread tread1 = new Thread(() -> {
            for (int i = 10000; i < 10010; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        myThread1.setDaemon(true); // Тред Демон можно объявить только до его старта.
        // Он завершается, как только завершаются основные Треды. Обычно таким образом вешают обслуживающие Треды.
        // еще один способ создание Треда, часто используемый способ в виде лямбды (стрелочной функции)
        tread1.start(); // запуск Треда

        myThread1.start(); // создает новый Тред (новый поток)
//        myThread1.run(); // не создает новый Тред
        myThread1.join(); // Метод join приостанавливает выполнения того Треда (в нашем случаи main) пока не выполнится myThread1
        thread.start(); // создаем новый Тред для объекта myThread2


        for (int i = 0; i < 10; i++) {
            System.out.println("main: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


//        Мой метод main будет ждать выполнения какого либа Треда
       try {
           // myThread1.join();
           thread.join();
           tread1.join();
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }

        System.out.println("finish main");
    }
}
