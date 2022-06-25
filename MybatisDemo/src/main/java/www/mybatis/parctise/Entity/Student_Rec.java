package www.mybatis.parctise.Entity;

import java.util.Date;

public class Student_Rec {

    private String name;
    private String address;
    private int age;
    private Date time;

    public Student_Rec(String name, String address, int age, Date time) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.time = time;
    }

    public Student_Rec() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Student_Rec{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", time=" + time +
                '}';
    }
}
