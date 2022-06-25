package www.spring.Entity;

import java.util.Date;

public class School {

    private String name;
    private Integer age;
    private Date bornDate;

    public School(String name, Integer age, Date bornDate) {
        System.out.println("调用了多参构造-School");
        this.name = name;
        this.age = age;
        this.bornDate = bornDate;
    }

    public School() {
        System.out.println("调用了无参构造-School");
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
