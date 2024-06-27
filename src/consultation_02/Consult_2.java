package consultation_02;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
Task 1
Class person { String name } Нужен метод Public Person findbyname (List<person> list, string name)

Task 2
Class person { String name Int age; Int department; Int amount; }
Нужен метод который Public … getSumAmountBydepartment(List<person> list)
 */

public class Consult_2 {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Jack1", 19, 1, 200),
                new Person("Jack2", 19, 2, 203),
                new Person("Jack3", 18, 2, 208),
                new Person("Jack4", 22, 1, 60),
                new Person("Jack5", 21, 3, 1000),
                new Person("Jack6", 30, 2, 20)
        );
        Map<Integer, Long> sumAmountByDepartment = getSumAmountByDepartment(people);
        System.out.println(sumAmountByDepartment);

    }

    // Task 1
    public Person findbyName(List<Person> list, String name) {
        if (name == null || list == null) {
            return null;
        }
        return list.stream()
                //.filter(p -> p != null)
                //.filter(Objects::nonNull)
                .filter(p -> p != null && p.getName() != null && p.getName().equals(name))
                .findAny()
                .orElse(null);
    }


    // Task 2
    public static Map<Integer, Long> getSumAmountByDepartment(List<Person> list) {
        return list.stream().collect(Collectors.toMap(p -> p.getDepartment(), p -> Long.valueOf(p.getAmount()), (s1, s2) -> s1 + s2));
    }

//    public static void main(String[] args) {
//
//        Random rnd = new Random();
//        // rnd.ints(). // бесконечный поток или стрим
//
//        // Stream.of("jack", "john", "nicolaus"); // Ctrl + Alt + M - создаем метод
//        // Stream<String> stream = getStream();
//
//        // Стрим это не коллекция. Это внешний объект который перебирает и обрабатывает данные.
//        // Промежуточные методы - stream
//        // Завершающие поток - не содержат stream
//
//        List.of("jack", "john", "nicolaus").stream().filter();
//
//
//    }

//    private static Stream<String> getStream() {
//        List.of("jack", "john", "nicolaus").stream().sorted();
//    }


}
