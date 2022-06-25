package demo;

public class Person {
    private String name;
    private int age;
    private  String city;
    private String hobbit;

    public Person(String name, int age, String city, String hobbit) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.hobbit = hobbit;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHobbit() {
        return hobbit;
    }

    public void setHobbit(String hobbit) {
        this.hobbit = hobbit;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", hobbit='" + hobbit + '\'' +
                '}';
    }
}
