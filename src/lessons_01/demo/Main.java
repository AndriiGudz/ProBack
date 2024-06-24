package lessons_01.demo;

public class Main {

    public static int counter;

    public static void main(String[] args) {

        MyThread[] threads = {new MyThread(), new MyThread(), new MyThread()};
        for (MyThread t:threads) {
            t.start();
        }

        // Треды используются, как правило, в высоко нагруженных процессах, проектах.

//        Ситуация гонки (или состояние гонки, race condition) — это ошибка,
//        возникающая в многопоточных или параллельных системах, когда два или более потоков или процессов
//        одновременно выполняют операции над общими данными или ресурсами, и результат выполнения зависит
//        от порядка их выполнения. Это может привести к непредсказуемому поведению программы,
//        ошибкам или некорректным данным.

        // Для решения проблемы использовать разные переменные.
        // Синхронизация, еще один способ решения проблемы. Синхронизовать наши Треды.

        for (int i = 0; i < 1_000_000; i++) {
            counter++;
        }
        for (MyThread t:threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("Counter: " + counter);

    }

}
