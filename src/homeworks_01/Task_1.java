package homeworks_01;

/*
Task 1
Дан диапазон чисел: от 1 до 2_000_000 включительно.
Задача: найти, сколько чисел из этого диапазона делятся нацело на 21 и при этом содержат цифру 3.
Решить данную задачу в один поток.
 */

public class Task_1 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2_000_000; i++) {
            if (i % 21 == 0 && containsDigit3(i)) {
                count++;
            }
        }
        System.out.println("Count in single thread: " + count);
    }

    private static boolean containsDigit3(int number) {
        return String.valueOf(number).contains("3");
    }
}
