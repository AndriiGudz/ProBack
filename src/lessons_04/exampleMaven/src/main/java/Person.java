import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
@Data

public class Person {
    private final String name;
    private int age;
    private String code;

    public Person(String name) {
        this.name = name;
    }
}
