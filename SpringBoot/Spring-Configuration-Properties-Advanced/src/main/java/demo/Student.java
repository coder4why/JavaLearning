package demo;

public class Student {

    private String name;
    private int age;
    private  String address;
    private String favorite;

    public Student(String name, int age, String address, String favorite) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.favorite = favorite;
    }

    public Student() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }
}
