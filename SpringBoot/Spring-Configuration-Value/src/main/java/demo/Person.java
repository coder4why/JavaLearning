package demo;

public class Person {
    private String name;
    private String city;
    private int age;
    private boolean isMarried;

    public Person(String name, String city, int age, boolean isMarried) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.isMarried = isMarried;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                '}';
    }
}
