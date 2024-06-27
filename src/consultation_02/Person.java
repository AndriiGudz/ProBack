package consultation_02;

public class Person {
    private String name;
    private int age;
    private int department;
    private int amount;

    public Person(String name, int age, int department, int amount) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getDepartment() {
        return department;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", amount=" + amount +
                '}';
    }
}
