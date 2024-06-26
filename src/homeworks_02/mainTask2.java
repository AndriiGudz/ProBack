package homeworks_02;

import homeworks_02.nation.countrysLeadership.President;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
Task 2
1. Разработать мини-приложение, похожее на то, которое делали на занятии.
2. Приложение должно содержать как минимум три сущности, которые должны
   зависеть друг от друга так, чтобы вызвав метод у одной из них, вызывались методы двух других.
4. Запустить приложение на Спринге, сконфигурировать его при помощи класса конфигурации.
 */
public class mainTask2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("homeworks_02.nation.config");
        President president = context.getBean(President.class);

        president.manageCountry();
    }
}
