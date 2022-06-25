package www.vip.com.DAO;

public class Person {

    String name;
    int age;
    String address;
    double salary;

    Person(){};
    Person(String name,int age, String address,double salary){
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
