package www.spring.Entity;

import java.util.Date;

public class Teacher {

    private String name;
    private Integer age;
    private Date bornDate;

    public Teacher(String name, Integer age, Date bornDate) {
        this.name = name;
        this.age = age;
        this.bornDate = bornDate;
        System.out.println("调用了多参构造-Teacher");
    }

    public Teacher() {
        System.out.println("调用了无参构造-Teacher");
    }

    public void doWhat(){
        System.out.println("开始上课");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }
}

