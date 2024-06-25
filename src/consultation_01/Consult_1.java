package consultation_01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Consult_1 {
    public static void main(String[] args) {
        List<String> list = List.of("jack", "john", "ann", "lane");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("---------------------------");

        for (String str : list) {
            System.out.println(str);
        }

        System.out.println("---------------------------");

        list.forEach(s -> System.out.println(s));

        System.out.println("---------------------------");
        list.stream()
                .filter(s -> s.length() > 3)
                .forEach(s -> System.out.println(s));

    }

    public static List<String> filter(List<String> list, Predicate<String> predicate){
        List<String> result = new ArrayList<>();
        for (String str: list){
            if(predicate.test(str)){
                result.add(str);
            }
        }
        return result;
    }

}
